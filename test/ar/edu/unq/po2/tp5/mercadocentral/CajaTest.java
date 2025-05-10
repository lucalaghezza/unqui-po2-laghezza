package ar.edu.unq.po2.tp5.mercadocentral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaTest {
	private Producto arroz;
	private ProductoCooperativa yerbaCooperativa;
	private Caja caja;
	private Factura servicio;
	private Factura impuesto;
	private IAgencia agencia;
	
	@BeforeEach
	public void setUp() {
		arroz = new Producto(100d, 4);
		yerbaCooperativa = new ProductoCooperativa(50d, 50);
		caja = new Caja();
		agencia = new AgenciaStub();
		impuesto = new Impuesto(agencia, 10d);
		servicio = new Servicio(agencia, 5d, 3);
	}
	
	@Test
	public void testEmptyCaja() {
		assertEquals(0d, caja.totalAPagar());
		assertEquals(4, arroz.getStock());
		assertEquals(50, yerbaCooperativa.getStock());
		assertEquals(10d, impuesto.getPrecio());
		assertEquals(15, servicio.getPrecio());
	}
	
	@Test
	public void testCaja1Producto() throws Exception {
		caja.registrar(arroz);
		
		assertEquals(100d, caja.totalAPagar());
		assertEquals(3 , arroz.getStock());
		assertEquals(50, yerbaCooperativa.getStock());
	}
	
	@Test
	public void testCaja1Producto2Unidades() throws Exception {
		caja.registrar(arroz);
		caja.registrar(arroz);
		
		assertEquals(200d, caja.totalAPagar());
		assertEquals(2 , arroz.getStock());
		assertEquals(50, yerbaCooperativa.getStock());
	}
	
	@Test
	public void testCajaProductoCooperativo() throws Exception {
		caja.registrar(yerbaCooperativa);
		
		assertEquals(45d, caja.totalAPagar());
		assertEquals(4 , arroz.getStock());
		assertEquals(49, yerbaCooperativa.getStock());
	}
	
	@Test
	public void testCaja2ProductosCooperativo() throws Exception {
		caja.registrar(yerbaCooperativa);
		caja.registrar(yerbaCooperativa);
		caja.registrar(arroz);
		caja.registrar(arroz);
		caja.registrar(arroz);
		caja.registrar(arroz);

		
		assertEquals(490d, caja.totalAPagar());
		assertEquals(0 , arroz.getStock());
		assertEquals(48, yerbaCooperativa.getStock());
	}
	
	@Test
	public void testCajaErrorStock() throws Exception {
		caja.registrar(arroz);
		caja.registrar(arroz);
		caja.registrar(arroz);
		caja.registrar(arroz);

		Exception except = assertThrows(Exception.class,() -> caja.registrar(arroz));
		assertEquals("no hay suficiente stock", except.getMessage());
		assertEquals(0 , arroz.getStock());
	}
	
	@Test
	public void testRegistrarImpuesto() throws Exception {
		caja.registrar(impuesto);

		
		assertEquals(10d, caja.totalAPagar());
	}
	
	@Test
	public void testRegistrarServicio() throws Exception {
		caja.registrar(servicio);

		
		assertEquals(15d, caja.totalAPagar());
	}

}

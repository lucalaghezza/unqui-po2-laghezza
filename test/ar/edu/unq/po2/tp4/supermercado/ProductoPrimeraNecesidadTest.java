package ar.edu.unq.po2.tp4.supermercado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoPrimeraNecesidadTest {

	private ProductoPrimeraNecesidad leche;
	
	@BeforeEach
	public void setUp() {
		leche = new ProductoPrimeraNecesidad("Leche", 8d, false);
	}
	
	@Test
	public void testCalcularPrecio() {
		assertEquals(new Double(7.2), leche.getPrecio());
	}
	
	@Test
	public void testNuevoProductoDistintoDescuentoPrecio() throws Exception {
		ProductoPrimeraNecesidad arroz = new ProductoPrimeraNecesidad("arroz", 10d, false, 5d);
		assertEquals(new Double(9.5), arroz.getPrecio());
		
	}
	
	@Test
	public void testNuevoProductoDistintoDescuentoMayorPorcentaje() throws Exception {
		Exception except = assertThrows(Exception.class,() -> new ProductoPrimeraNecesidad("pila", 10d, false, 101d));
		assertEquals("el porcentaje debe ser entre 0 y 100", except.getMessage());
	}
	
	@Test
	public void testNuevoProductoDistintoDescuentoMenorPorcentaje() throws Exception {
		Exception except = assertThrows(Exception.class,() -> new ProductoPrimeraNecesidad("pila", 10d, false, -1d));
		assertEquals("el porcentaje debe ser entre 0 y 100", except.getMessage());
	}
}

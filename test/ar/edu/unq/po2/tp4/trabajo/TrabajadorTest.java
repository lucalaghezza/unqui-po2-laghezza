package ar.edu.unq.po2.tp4.trabajo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TrabajadorTest {
	private Trabajador lucarp;
	private Ingreso ingresoMes;
	private IngresoPorHorasExtras ingresoExtra;
	
	@BeforeEach
	public void setUp() {
		lucarp = new Trabajador();
		ingresoMes = new Ingreso("enero", "mensualidad", 100d);
		ingresoExtra = new IngresoPorHorasExtras("enero", "extras", 50d, 50);
	}
	
	@Test
	public void testImpuestosSinIngresos() {
		
		assertEquals(new Double(0), lucarp.getTotalPercibido());
		assertEquals(new Double(0), lucarp.getMontoImponible());
		assertEquals(new Double(0), lucarp.getImpuestoAPagar());
	}
	
	@Test
	public void testImpuestosConIngreso() {		
		lucarp.ingresar(ingresoMes);
		
		assertEquals(new Double(100), lucarp.getTotalPercibido());
		assertEquals(new Double(100), lucarp.getMontoImponible());
		assertEquals(new Double(2), lucarp.getImpuestoAPagar());
	}
	
	@Test
	public void testImpuestosConIngresosYExtras() {
		lucarp.ingresar(ingresoMes);
		lucarp.ingresar(ingresoExtra);

		assertEquals(new Double(150), lucarp.getTotalPercibido());
		assertEquals(new Double(100), lucarp.getMontoImponible());
		assertEquals(new Double(2), lucarp.getImpuestoAPagar());
	}
	
	@Test
	public void testImpuestosConIngresosExtra() {
		lucarp.ingresar(ingresoExtra);
		
		assertEquals(new Double(50), lucarp.getTotalPercibido());
		assertEquals(new Double(0), lucarp.getMontoImponible());
		assertEquals(new Double(0), lucarp.getImpuestoAPagar());
	}
	
	@Test
	public void testImpuestosConVariosIngresosYExtras() {
		Ingreso ingresoFebrero = new Ingreso ("febrero", "mensualidad", 100d);
		
		lucarp.ingresar(ingresoMes);
		lucarp.ingresar(ingresoExtra);
		lucarp.ingresar(ingresoFebrero);
		
		assertEquals(new Double(250), lucarp.getTotalPercibido());
		assertEquals(new Double(200), lucarp.getMontoImponible());
		assertEquals(new Double(4), lucarp.getImpuestoAPagar());
	}
	
	

}

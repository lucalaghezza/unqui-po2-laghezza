package ar.edu.unq.po2.tp3.rectangulo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class PuntoTest {
	Punto p;

	@BeforeEach
	public void setUp() {
		p = new Punto(1, 2);
	}

	@Test
	public void testGetter() {

		assertEquals(1, p.getX(), "falló el getter");

	}

	@Test
	public void testSetter() {

		p.setX(5);
		assertEquals(5, p.getX(), "falló el setter");

	}

	@Test
	public void testMover() {
		p.moverA(3, 4);
		assertEquals(3, p.getX(), "falló el mover");
		assertEquals(4, p.getY(), "falló el mover");
	}

	@Test
	public void testInitializeZero() {
		Punto i = new Punto();

		assertEquals(0, i.getX(), "falló el inicializar en 0");
		assertEquals(0, i.getY(), "falló el inicializar en 0");
	}
	
	@Test
	public void testSumar() {
		Punto i = new Punto(2,1);
		
		p.sumar(i);
		
		assertEquals(3, p.getX(), "falló el sumar");
		assertEquals(3, p.getY(), "falló el sumar");
		assertEquals(2, i.getX(), "falló el mover");
		assertEquals(1, i.getY(), "falló el mover");
	}
}

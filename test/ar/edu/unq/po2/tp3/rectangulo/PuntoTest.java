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
}

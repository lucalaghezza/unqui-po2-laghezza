package ar.edu.unq.po2.tp3.rectangulo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class RectanguloTest {
	Punto p;
	Rectangulo r;

	@BeforeEach
	public void setUp() {
		p = new Punto(1, 2);
		r = new Rectangulo(2,3, p);
	}

	@Test
	public void testNewRectangulo() {

		assertEquals(2, r.getBase(), "falló el getter");
		assertEquals(3, r.getAltura(), "falló el getter");
		assertEquals(p, r.getPuntoOrigen(), "falló el getter");
		assertEquals(6, r.getArea(), "falló el get altura");
		assertEquals(10, r.getPerimetro(), "falló el get perimetro");
		assertEquals("Vertical", r.getOrientacion(), "falló el get orientación");
		

	}

	@Test
	public void testSetters() {
		r.setAltura(2);
		r.setBase(4);
		assertEquals(4, r.getBase(), "falló el getter");
		assertEquals(2, r.getAltura(), "falló el getter");
		assertEquals(p, r.getPuntoOrigen(), "falló el getter");
		assertEquals(8, r.getArea(), "falló el get altura");
		assertEquals(12, r.getPerimetro(), "falló el get perimetro");
		assertEquals("Horizontal", r.getOrientacion(), "falló el get orientación");
		


	}

	@Test
	public void testCuadrado() {
		Cuadrado c = new Cuadrado(2,p);
		
		assertEquals(2, c.getBase(), "falló el getter");
		assertEquals(2, c.getAltura(), "falló el getter");
		assertEquals(p, c.getPuntoOrigen(), "falló el getter");
		assertEquals(4, c.getArea(), "falló el get altura");
		assertEquals(8, c.getPerimetro(), "falló el get perimetro");
		assertEquals("Cuadrado", c.getOrientacion(), "falló el get orientación");
		

	}

	
}

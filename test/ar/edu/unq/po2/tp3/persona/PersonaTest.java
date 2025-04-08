package ar.edu.unq.po2.tp3.persona;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

public class PersonaTest {
	Persona l;
	Persona c;

	@BeforeEach
	public void setUp() {
		l = new Persona("Luca", LocalDate.of(1993, 7, 29));
		c = new Persona("Cami", LocalDate.of(1994, 1, 11));
	}

	@Test
	public void testPersona() {
		
		assertEquals(31, l.getEdad(), "fallo el get edad");
		assertEquals("Luca", l.getNombre(), "fallo el get nombre");
		assertEquals(31, c.getEdad(), "fallo el get edad");
		assertEquals("Cami", c.getNombre(), "fallo el get nombre");
		assertFalse(l.menorQue(c));
		assertFalse(c.menorQue(l));
		
		Persona p = new Persona("Bernabeu", LocalDate.of(2018, 12, 9));
		
		assertTrue(p.menorQue(l));
		assertTrue(p.menorQue(c));
		assertFalse(l.menorQue(p));
		assertFalse(c.menorQue(p));


	}

}


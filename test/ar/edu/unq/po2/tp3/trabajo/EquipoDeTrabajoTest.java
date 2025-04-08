package ar.edu.unq.po2.tp3.trabajo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

public class EquipoDeTrabajoTest {
	Persona l;
	Persona c;
	List<Persona> integrantes = new ArrayList<Persona>();

	@BeforeEach
	public void setUp() {
		l = new Persona("Luca", "Laghezza", 31);
		c = new Persona("Cami", "de Cabo", 31);
		integrantes.add(c);
	}

	@Test
	public void testPersona() {

		assertEquals(31, l.getEdad(), "fallo el get edad");
		assertEquals("Luca", l.getNombre(), "fallo el get nombre");
		assertEquals(31, c.getEdad(), "fallo el get edad");
		assertEquals("Cami", c.getNombre(), "fallo el get nombre");

	}

	@Test
	public void testEquipoDeTrabajo() {
		EquipoDeTrabajo et = new EquipoDeTrabajo("team", integrantes);

		assertEquals("team", et.getNombre(), "falló el getNombre");
		assertEquals(integrantes, et.getIntegrantes(), "falló el getIntegrantes");
		assertEquals(31, et.getPromedioEdad(), "falló el get promedio de edad");

		et.agregarIntegrante(l);
		assertEquals("team", et.getNombre(), "falló el getNombre");
		assertEquals(2, et.getIntegrantes().size(), "falló el getIntegrantes");
		assertEquals(31, et.getPromedioEdad(), "falló el get promedio de edad");

	}

	@Test
	public void testEquipoDeTrabajoEdad() {
		EquipoDeTrabajo et = new EquipoDeTrabajo("team");

		assertEquals("team", et.getNombre(), "falló el getNombre");
		assertEquals(0, et.getIntegrantes().size(), "falló el getIntegrantes");
		assertEquals(0, et.getPromedioEdad(), "falló el get promedio de edad");

		et.agregarIntegrante(l);
		assertEquals("team", et.getNombre(), "falló el getNombre");
		assertEquals(1, et.getIntegrantes().size(), "falló el getIntegrantes");
		assertEquals(31, et.getPromedioEdad(), "falló el get promedio de edad");
		
		et.setNombre("nuevo");

		et.agregarIntegrante(new Persona("Jose","de San Martin", 9));
		assertEquals("nuevo", et.getNombre(), "falló el getNombre");
		assertEquals(2, et.getIntegrantes().size(), "falló el getIntegrantes");
		assertEquals(20, et.getPromedioEdad(), "falló el get promedio de edad");
	}

}

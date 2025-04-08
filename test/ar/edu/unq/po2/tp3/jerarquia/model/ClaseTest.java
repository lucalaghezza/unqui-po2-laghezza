package ar.edu.unq.po2.tp3.jerarquia.model;

import ar.edu.unq.po2.tp3.jerarquia.model.gui.*;
import ar.edu.unq.po2.tp3.jerarquia.model.stack.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class ClaseTest {
	/*  7.1 Las clases se organizan jerarquicamente en los paquetes 
		como se ve en los imports
		7.2 Si bien eclipse no muestra la carpeta bin, los .java (src) y .class 
			(bin) deberían respetar el mismo orden jerárquico entre los paquetes
*/
	
	@Test
	public void testClases() {
		Clase model = new Clase();
		ClaseGui gui = new ClaseGui();
		ClaseStack stack = new ClaseStack();
		
		assertEquals("modelo", model.mostrar(), "falló el mostrar");
		assertEquals("gui", gui.mostrar(), "falló el mostrar");
		assertEquals("stack", stack.mostrar(), "falló el mostrar");
		
	}

}

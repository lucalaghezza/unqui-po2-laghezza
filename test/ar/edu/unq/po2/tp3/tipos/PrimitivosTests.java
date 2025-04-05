package ar.edu.unq.po2.tp3.tipos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class PrimitivosTests {
	int a;
	Integer b;
	
	/*
	 1. ¿Qué son los tipos de datos primitivos?
	 Los tipos de datos primitivos son básicos y representan valores simples. Se almacenan directamente en la memoria y se utilizan para crear variables y asignarles números, caracteres o valores lógicos. 
	 
	 2. ¿Cuál es la diferencia entre un int y un Integer?
	 int primitivo asigna un valor directamente a la variable, no puede ser referenciado y al pasarse se pasa por copia por lo cual al modificarse se modifica la copia y no la variable original (no tiene la referencia)
	 Integer es de tipo referenciado, se almacena en memoria y se le asigna la dirección de la misma por lo que se puede acceder y modificar desde distintos lugares
	 
	 3. ¿Si se define una variable de instancia de tipo int cual sería su valor predeterminado? ¿Y si se
		define una de tipo Integer? Haga la prueba en Eclipse.
		int = 0
		Integer = null 
	 4. Responder la pregunta del punto anterior (3), pero ahora en lugar de definir una variable de
		instancia se define una variable de método.
		No me deja ver sus valores ya que no se inicializan, se ve un error antes de compilación.
		Directamente el compilador no me deja verlo.
	 */
	
	@Test
	public void testInt() {
		
		assertEquals(0, a);
		assertNull(b);
		
		
	}

}

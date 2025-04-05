package ar.edu.unq.po2.tp3.tipos;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class StringsTest {
	String a = "abc";
	String s = a;
	String t;
	
	
	@Test
	public void testExpressions() {
		
		assertEquals(3,s.length());
		// t da null pointer exception xq esta null (no fue instanciada)
		assertThrows(NullPointerException.class, () -> t.length());
		
		// el numero se mapea a string y se agrega a la cadena
		assertEquals("1abc", 1+a);
		assertEquals("ABC", a.toUpperCase());
		// toma el indice de r
		assertEquals(4,"Libertad".indexOf("r"));
		// toma el ultimo indice donde está 'i'
		assertEquals(7,"Universidad".lastIndexOf('i'));
		// toma desde hasta (indices)
		assertEquals("il", "Quilmes".substring(2,4));
		
		// falso porque le agregue el lenght al principio, queda = 3abc
		assertFalse((a.length() + a).startsWith("a"));
		assertTrue(s == a);
		assertTrue(a.substring(1,3).equals("bc"));

	}
}

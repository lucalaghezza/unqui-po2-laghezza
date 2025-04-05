package ar.edu.unq.po2.tp3.multioperador;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.*;

public class MultiOperadorTest {
	MultiOperador operador = new MultiOperador();

	@Test
	public void TestOperatorToAll() {
		ArrayList<Integer> numeros =  new ArrayList<>(Arrays.asList(1,2,3,4));
		
		assertEquals(10, operador.sumAll(numeros));
		assertEquals(-10, operador.restAll(numeros));
		assertEquals(24, operador.multiplyAll(numeros));
		
		numeros = new ArrayList<Integer>();
		
		assertEquals(0, operador.sumAll(numeros));
		assertEquals(0, operador.restAll(numeros));
		assertEquals(0, operador.multiplyAll(numeros));
		
		numeros.add(-1);
		
		assertEquals(-1, operador.sumAll(numeros));
		assertEquals(1, operador.restAll(numeros));
		assertEquals(-1, operador.multiplyAll(numeros));
		
		numeros.add(-10);
		
		assertEquals(-11, operador.sumAll(numeros));
		assertEquals(11, operador.restAll(numeros));
		assertEquals(10, operador.multiplyAll(numeros));
		
	}
}

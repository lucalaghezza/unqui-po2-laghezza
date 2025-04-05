package ar.edu.unq.po2.tp3.counter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

public class NumerosUtilsTest {

	@Test
	public void testDesarmandoNumeros() {
		List<Integer> numeros = new ArrayList<Integer>();

		numeros.add(123);
		numeros.add(456);
		numeros.add(1);
		numeros.add(22);
		numeros.add(2024);
		numeros.add(334588);


		int resultado = (int) NumerosUtils.getNumeroConMasDigitosPares(numeros);

		int esperado = 2024;

		assertEquals(esperado, resultado);

	}
	
	@Test
	public void testMaxMultiplo() {
		assertEquals(999, NumerosUtils.maxMultiplo(3,9));
		assertEquals(910, NumerosUtils.maxMultiplo(7,13));
		assertEquals(900, NumerosUtils.maxMultiplo(25, 30));
		assertEquals(1000, NumerosUtils.maxMultiplo(1000, 1000));
		assertEquals(-1, NumerosUtils.maxMultiplo(500,501));
		assertEquals(1000, NumerosUtils.maxMultiplo(5, 10));
		assertEquals(-1, NumerosUtils.maxMultiplo(1001, 1001));





		
	}
}

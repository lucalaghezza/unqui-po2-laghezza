package ar.edu.unq.po2.tp3.multioperador;

import java.util.ArrayList;

public class MultiOperador {

	public int sumAll(ArrayList<Integer> numeros) {
		return numeros.stream().mapToInt(Integer::intValue).sum();
	}

	public int restAll(ArrayList<Integer> numeros) {
		return numeros.stream().mapToInt(Integer::intValue).reduce(0, (a, b) -> a - b);
	}

	public int multiplyAll(ArrayList<Integer> numeros) {
		if (numeros.isEmpty()) {
			return 0;
		}
		return numeros.stream().mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b);
	}
}

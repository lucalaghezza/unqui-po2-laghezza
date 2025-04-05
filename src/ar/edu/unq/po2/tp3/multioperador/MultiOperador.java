package ar.edu.unq.po2.tp3.multioperador;

import java.util.ArrayList;

public class MultiOperador {

	public int sumAll(ArrayList<Integer> numeros) {
		return numeros.stream().mapToInt(Integer::intValue).sum();
	}
	
	public int restAll(ArrayList<Integer> numeros) {
	//	return numeros.stream().mapToInt(Integer::intValue).reduce(, )
		return 0;
		
	}
}

package ar.edu.unq.po2.tp3.counter;

import java.util.*;

public class Counter {

	List<Integer> numbers = new ArrayList<Integer>();

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void addNumber(int number) {
		this.numbers.add(number);
	}
	
	public int cantidadDePares() {
		return (int) this.getNumbers().stream().filter(number -> this.esPar(number)).count();
	}
	
	public int cantidadDeImpares() {
		return (int) this.getNumbers().stream().filter(number -> !this.esPar(number)).count();
	}
	
	public int cantidadDeMultiplos(Integer multiplo) {
		return (int) this.getNumbers().stream().filter(number -> this.esMultiplo(number, multiplo)).count();

	}
	
	private Boolean esPar(Integer x) {
		return x % 2 == 0;
	}
	
	private Boolean esMultiplo(Integer x, Integer y) {
		return x % y == 0;
	}
	
	
	
}

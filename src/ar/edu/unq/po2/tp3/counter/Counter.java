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

	public Integer getNumeroConMasDigitosPares(List<Integer> numbers) {
		if (numbers.isEmpty()) {
			return null;
		}

		Integer numberWithPairs = numbers.getFirst();

		for (int i = 1; i < numbers.size(); i++) {
			Integer number = numbers.get(i);
			if (this.tieneMasDigitosPares(number, numberWithPairs)) {
				numberWithPairs = number;
			}
		}

		return numberWithPairs;

	}

	private boolean tieneMasDigitosPares(Integer numberX, Integer numberWithPairs) {
		return this.cantidadDigitosPares(numberX) > this.cantidadDigitosPares(numberWithPairs);
	}

	private int cantidadDigitosPares(Integer numberX) {
		Counter counterX = new Counter();

		while (numberX > 0) {
			counterX.addNumber(numberX % 10);
			numberX = numberX / 10;
		}

		return counterX.cantidadDePares();
	}

}

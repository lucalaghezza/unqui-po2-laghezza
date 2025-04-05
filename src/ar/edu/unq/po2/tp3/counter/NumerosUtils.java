package ar.edu.unq.po2.tp3.counter;

import java.util.List;

public class NumerosUtils {
	
	
	public static Integer getNumeroConMasDigitosPares(List<Integer> numbers) {
		if (numbers.isEmpty()) {
			return null;
		}

		Integer numberWithPairs = numbers.getFirst();

		for (int i = 1; i < numbers.size(); i++) {
			Integer number = numbers.get(i);
			if (tieneMasDigitosPares(number, numberWithPairs)) {
				numberWithPairs = number;
			}
		}

		return numberWithPairs;

	}

	private static boolean tieneMasDigitosPares(Integer numberX, Integer numberWithPairs) {
		return cantidadDigitosPares(numberX) > cantidadDigitosPares(numberWithPairs);
	}

	private static int cantidadDigitosPares(Integer numberX) {
		Counter counterX = new Counter();

		while (numberX > 0) {
			counterX.addNumber(numberX % 10);
			numberX = numberX / 10;
		}

		return counterX.cantidadDePares();
	}

    // Función estática para calcular el Máximo Común Divisor (MCD)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Función estática para calcular el Mínimo Común Múltiplo (MCM)
    private static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }

    // Función estática que devuelve el múltiplo más alto entre 0 y 1000
    public static int maxMultiplo(int X, int Y) {
        // Calcular el MCM de X e Y
        int mcm = lcm(X, Y);
        
        // Si el MCM es mayor que 1000, retornar -1
        if (mcm > 1000) {
            return -1;
        }
        
        // Buscar el múltiplo de MCM más grande que sea <= 1000
        for (int i = 1000; i >= 0; i--) {
            if (i % mcm == 0) {
                return i;
            }
        }
        
        // Si no hay múltiplo en ese rango, retornar -1
        return -1;
    }
}

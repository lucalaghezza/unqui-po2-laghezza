package ar.edu.unq.po2.tp4.trabajo;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {
	List<Ingreso> ingresos;


	public Trabajador() {
		ingresos = new ArrayList<Ingreso>();
	}

	public double getTotalPercibido() {
		return ingresos.stream().mapToDouble(i -> i.getMonto()).sum();
	}

	public double getMontoImponible() {
		return ingresos.stream().mapToDouble(i -> i.getMontoImponible()).sum();

	}

	public double getImpuestoAPagar() {
		return this.getMontoImponible() * 0.02; // impuesto = 2% del monto imponible
	}

	public void ingresar(Ingreso ingreso) {
		ingresos.add(ingreso);
	}

}

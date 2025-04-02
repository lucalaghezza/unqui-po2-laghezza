package ar.edu.unq.po2.tp2.ej1;

public class Concepto {
	private String nombre;
	private Double monto;

	public Concepto(String nombre, Double monto) {
		this.nombre = nombre;
		this.monto = monto;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getMonto() {
		return monto;
	}

	@Override
	public String toString() {
		return nombre + ": " + monto;
	}

}

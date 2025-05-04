package ar.edu.unq.po2.tp4.trabajo;

public class Ingreso {
	String mes;
	String concepto;
	Double monto;
	
	public Ingreso(String mes, String concepto, Double monto) {
		super();
		this.mes = mes;
		this.concepto = concepto;
		this.monto = monto;
	}

	public double getMonto() {
		return this.monto;
	}
	
	public double getMontoImponible() {
		return this.getMonto();
	}
}

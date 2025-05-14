package ar.edu.unq.po2.tp5.solid;

public abstract class SolicitudDeCredito {
	private double montoSolicitado;
	private Cliente clienteSolicitador;
	private int plazoEnMeses;

	public SolicitudDeCredito (double monto, Cliente cliente, int plazo) {
		this.clienteSolicitador = cliente;
		this.montoSolicitado = monto;
		this.plazoEnMeses = plazo;
	}
	
	public double getMontoSolicitado() {
		return this.montoSolicitado;
	}

	public Cliente getClienteSolicitador() {
		return this.clienteSolicitador;
	}

	public int getPlazoEnMeses() {
		return this.plazoEnMeses;
	}

	public abstract boolean esAceptable();
	
	public double cuotaMensual() {
		return this.getMontoSolicitado() / this.getPlazoEnMeses();
	}
}

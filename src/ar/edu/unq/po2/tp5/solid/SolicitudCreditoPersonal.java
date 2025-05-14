package ar.edu.unq.po2.tp5.solid;

public class SolicitudCreditoPersonal extends SolicitudDeCredito {
	
	public SolicitudCreditoPersonal(double monto, Cliente cliente, int plazo) {
		super(monto,cliente,plazo);
	}

	@Override
	public boolean esAceptable() {
		return this.clienteTieneIngresosValidos() && this.elMontoNoSuperaIngresos();
	}

	private boolean elMontoNoSuperaIngresos() {
		return  this.cuotaMensual() <= (this.getClienteSolicitador().getSueldoNetoMensual() * 0.7d);
	}

	private boolean clienteTieneIngresosValidos() {
		return this.getClienteSolicitador().getSueldoNetoAnual() >= 15000d;
	}

}

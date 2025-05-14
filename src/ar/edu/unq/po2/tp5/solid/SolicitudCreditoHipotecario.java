package ar.edu.unq.po2.tp5.solid;

public class SolicitudCreditoHipotecario extends SolicitudDeCredito {
	private PropiedadInmobiliaria propiedad;

	public SolicitudCreditoHipotecario(double monto, Cliente cliente, int plazo, PropiedadInmobiliaria propiedad) {
		super(monto, cliente, plazo);
		this.propiedad = propiedad;
	}

	@Override
	public boolean esAceptable() {
		return this.clienteTieneEdadValida() && this.elMontoNoSuperaIngresos()
			 && this.elMontoSolicitadoEsValidoParaLaPropiedad();
	}

	private boolean elMontoSolicitadoEsValidoParaLaPropiedad() {
		return this.getMontoSolicitado() <= (this.getPropiedadInmobiliaria().getValorFiscal() * 0.7d);
	}

	private boolean clienteTieneEdadValida() {
		return this.getClienteSolicitador().getEdad() <= 65;
	}

	private boolean elMontoNoSuperaIngresos() {
		return  this.cuotaMensual() <= (this.getClienteSolicitador().getSueldoNetoMensual() * 0.5d);
	}


	public PropiedadInmobiliaria getPropiedadInmobiliaria() {
		return this.propiedad;
	}

}

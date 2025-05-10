package ar.edu.unq.po2.tp5.mercadocentral;

public class Impuesto extends Factura {
	private double tasa;

	public Impuesto(IAgencia agencia, double tasa) {
		super(agencia);
		this.tasa = tasa;
	}

	@Override
	public double getPrecio() {
		return this.tasa;
	}

}

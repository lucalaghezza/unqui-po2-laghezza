package ar.edu.unq.po2.tp5.mercadocentral;

public class Servicio extends Factura {
	private double costoPorUnidad;
	private int unidadesConsumidas;

	public Servicio(IAgencia agencia, double costoPorUnidad, int unidadesConsumidas) {
		super(agencia);
		this.costoPorUnidad = costoPorUnidad;
		this.unidadesConsumidas = unidadesConsumidas;
	}

	@Override
	public double getPrecio() {
		return this.costoPorUnidad * this.unidadesConsumidas;
	}
	

}

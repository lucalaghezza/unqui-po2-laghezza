package ar.edu.unq.po2.tp5.mercadocentral;

public class Caja {
	private double montoAPagar = 0;
	
	
	public void registrar(IPagable pagable) throws Exception {
		pagable.registrar();
		this.acumularMonto(pagable.getPrecio());
	}
	
	public double totalAPagar() {
		return this.montoAPagar;
	}
	
	private void acumularMonto(double monto) {
		this.montoAPagar += monto;
	}
}

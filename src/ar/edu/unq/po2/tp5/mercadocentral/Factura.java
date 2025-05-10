package ar.edu.unq.po2.tp5.mercadocentral;

public abstract class Factura implements IPagable {
	private IAgencia agencia;
	
	public Factura(IAgencia agencia) {
		this.agencia = agencia;
	}
	
	public abstract double getPrecio();
	
	public void registrar() throws Exception {
		agencia.registrarPago(this);
	};
	

}

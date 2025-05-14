package ar.edu.unq.po2.tp5.solid;

public class PropiedadInmobiliaria {
	@SuppressWarnings("unused")
	private String descripcion;
	@SuppressWarnings("unused")
	private String direccion;
	private double valorFiscal;
	
	
	public PropiedadInmobiliaria(String descripcion, String direccion, double valorFiscal) {
		super();
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.valorFiscal = valorFiscal;
	}


	public double getValorFiscal() {
		return this.valorFiscal;
	}
	
	

}

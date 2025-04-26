package ar.edu.unq.po2.tp4.supermercado;

public class ProductoPrimeraNecesidad extends Producto {
	
	public ProductoPrimeraNecesidad(String nombre, double precio, Boolean esPrecioCuidado) {
		super(nombre, precio, esPrecioCuidado);
	}
	
	@Override
	public Double getPrecio() {
		return this.precio * 0.9;
	}

}

package ar.edu.unq.po2.tp4.supermercado;

public class Producto {
	String nombre;
	Double precio;
	Boolean esPrecioCuidado = false;
	
	public Producto(String nombre, double precio, Boolean esPrecioCuidado) {
		this.nombre = nombre;
		this.precio = precio;
		this.esPrecioCuidado = esPrecioCuidado;
	}
	
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return this.nombre;
	}


	public Double getPrecio() {
		return this.precio;
	}
	
	public Boolean esPrecioCuidado() {
		return this.esPrecioCuidado;
	}
	
	public void aumentarPrecio(double montoAumento) {
		this.precio += montoAumento;
	}
}

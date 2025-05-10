package ar.edu.unq.po2.tp5.mercadocentral;

public class Producto implements IPagable {
	private double precioBase;
	private int stock;

	public Producto(double precio, int stock) {
		this.precioBase = precio;
		this.stock = stock;
	}

	public double getPrecio() {
		return this.precioBase;
	}

	public int getStock() {
		return this.stock;
	}
	
	public void aumentarStock(int cantidad) {
		this.stock += cantidad;
	}
	
	public void registrar() throws Exception {
		this.verificarDisminuirStock();
		this.stock --;
	}
	
	private void verificarDisminuirStock() throws Exception {
		if (this.getStock() <= 0) {
			throw new Exception("no hay suficiente stock");
		}
	}
}

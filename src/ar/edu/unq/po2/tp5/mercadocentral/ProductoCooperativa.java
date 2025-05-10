package ar.edu.unq.po2.tp5.mercadocentral;

public class ProductoCooperativa extends Producto {
	private int porcentajeDescuento = 10;
	
	public ProductoCooperativa(double precio, int stock) {
		super(precio, stock);
	}
	
	@Override
	public double getPrecio() {
		return super.getPrecio() * this.multiploDescuento();
		
	}
	
	private double multiploDescuento() {
		return (100d - this.getPorcentajeDescuento()) / 100d;
	}
	
	private double getPorcentajeDescuento() {
		return this.porcentajeDescuento;
	}

}

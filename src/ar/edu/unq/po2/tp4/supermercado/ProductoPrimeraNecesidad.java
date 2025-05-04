package ar.edu.unq.po2.tp4.supermercado;

public class ProductoPrimeraNecesidad extends Producto {
	double porcentajeDescuento = 10;
	
	public ProductoPrimeraNecesidad(String nombre, double precio, Boolean esPrecioCuidado) {
		super(nombre, precio, esPrecioCuidado);
	}
	
	public ProductoPrimeraNecesidad(String nombre, double precio, boolean esPrecioCuidado, double porcentajeDto) throws Exception {
		super(nombre, precio, esPrecioCuidado);
		this.setPorcentajeDescuento(porcentajeDto);
	}
	
	@Override
	public Double getPrecio() {
		return this.precio * getMultiploAplicarDescuento();
	}
	
	private double getMultiploAplicarDescuento() {
		return (100 - this.getPorcentajeDescuento()) / 100;
	}

	private void validarPorcentaje(double porcentaje) throws Exception {
		if (porcentaje < 0 || porcentaje > 100) {
			throw new Exception("el porcentaje debe ser entre 0 y 100");
		}
	}
	
	private double getPorcentajeDescuento() {
		return this.porcentajeDescuento;
	}
	
	private void setPorcentajeDescuento(double porcentaje) throws Exception {
		this.validarPorcentaje(porcentaje);
		this.porcentajeDescuento = porcentaje;
	}

}

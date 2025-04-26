package ar.edu.unq.po2.tp4.supermercado;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	String nombre;
	String direccion;
	List<Producto> productos;

	public Supermercado(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.productos = new ArrayList<Producto>();
	}

	public int getCantidadDeProductos() {
		return this.productos.size();
	}

	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}

	public Double getPrecioTotal() {
		return this.productos.stream().mapToDouble(p -> p.getPrecio()).sum();
	}

}

package ar.edu.unq.po2.tp8.observer.publicaciones;

import java.util.HashSet;
import java.util.Set;

public class SistemaBibliografico implements RepositorioDeArticulos{
	private Set<Articulo> articulos;
	private Set<Suscripcion> suscripciones;
	 
	
	public SistemaBibliografico() {
		super();
		this.articulos = new HashSet<Articulo>();;
		this.suscripciones = new HashSet<Suscripcion>();;
	}


	public Set<Articulo> getArticulos() {
		return this.articulos;
	}
	
	public Set<Suscripcion> getSuscripciones() {
		return this.suscripciones;
	}


	@Override
	public void agregarArticulo(Articulo articulo) {
		this.articulos.add(articulo);
		this.notificar(articulo);
	}
	
	private void notificar(Articulo articulo) {
		this.suscripciones.forEach(s -> s.notificar(articulo));
	}
	
	public void agregarSuscripcion(Suscripcion suscripcion) {
		this.suscripciones.add(suscripcion);
	}

}

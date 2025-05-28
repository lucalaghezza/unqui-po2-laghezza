package ar.edu.unq.po2.tp8.observer.publicaciones;

import java.util.HashSet;
import java.util.Set;

public class Investigador implements Suscriptor{
	private String nombre;
	private Set<Articulo> articulosRecibidos;
	private RepositorioDeArticulos repositorioDeArticulos;
	
	public Investigador(String nombre, RepositorioDeArticulos repositorioDeArticulos) {
		super();
		this.nombre = nombre;
		this.repositorioDeArticulos = repositorioDeArticulos;
		this.articulosRecibidos = new HashSet<Articulo>();
	}

	public String getNombre() {
		return nombre;
	}

	public Set<Articulo> getArticulosRecibidos() {
		return articulosRecibidos;
	}

	public RepositorioDeArticulos getRepositorioDeArticulos() {
		return repositorioDeArticulos;
	}

	@Override
	public void recibirArticulo(Articulo articulo) {
		this.articulosRecibidos.add(articulo);
		
	}
	
	
	
	
	
	
}

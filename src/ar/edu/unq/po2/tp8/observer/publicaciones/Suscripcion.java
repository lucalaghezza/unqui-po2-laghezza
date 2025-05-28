package ar.edu.unq.po2.tp8.observer.publicaciones;

public interface Suscripcion {
	public void suscribe(Suscriptor suscriptor);
	public void notificar(Articulo articulo);
}

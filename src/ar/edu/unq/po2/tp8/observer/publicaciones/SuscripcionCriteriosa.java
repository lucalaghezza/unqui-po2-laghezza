package ar.edu.unq.po2.tp8.observer.publicaciones;

import java.util.HashSet;
import java.util.Set;

public class SuscripcionCriteriosa implements Suscripcion {
	private CriterioMatcher criterio;
	private Set<Suscriptor> suscriptores;
	
	public SuscripcionCriteriosa(CriterioMatcher criterio) {
		super();
		this.criterio = criterio;
		this.suscriptores = new HashSet<Suscriptor>();
	}

	public CriterioMatcher getCriterio() {
		return criterio;
	}

	public Set<Suscriptor> getSuscriptores() {
		return suscriptores;
	}
	
	@Override
	public void suscribe(Suscriptor suscriptor) {
		this.suscriptores.add(suscriptor);
	}


	@Override
	public void notificar(Articulo articulo) {
		if (this.getCriterio().cumpleCriterio(articulo)) {
			this.getSuscriptores().forEach(s -> s.recibirArticulo(articulo));
		}
	}
	
}

package ar.edu.unq.po2.tp8.observer.publicaciones;

public class CriterioPorConferencia implements CriterioMatcher {
    private String conferencia;

    public CriterioPorConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    @Override
    public boolean cumpleCriterio(Articulo articulo) {
        return articulo.getLugarPublicacion().equalsIgnoreCase(conferencia);
    }
}

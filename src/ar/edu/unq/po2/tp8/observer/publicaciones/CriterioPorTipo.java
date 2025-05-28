package ar.edu.unq.po2.tp8.observer.publicaciones;

public class CriterioPorTipo implements CriterioMatcher {
    private String tipo;

    public CriterioPorTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean cumpleCriterio(Articulo articulo) {
        return articulo.getTipo().equalsIgnoreCase(tipo);
    }
}

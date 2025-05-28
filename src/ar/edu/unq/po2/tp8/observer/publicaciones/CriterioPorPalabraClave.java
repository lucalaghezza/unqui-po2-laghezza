package ar.edu.unq.po2.tp8.observer.publicaciones;

public class CriterioPorPalabraClave implements CriterioMatcher {
    private String palabraClave;

    public CriterioPorPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    @Override
    public boolean cumpleCriterio(Articulo articulo) {
        return articulo.getPalabrasClave().stream()
                .anyMatch(p -> p.equalsIgnoreCase(palabraClave));
    }
}

package ar.edu.unq.po2.tp8.observer.publicaciones;

import java.util.List;

public class CriterioAnd implements CriterioMatcher {
    private List<CriterioMatcher> criterios;

    public CriterioAnd(List<CriterioMatcher> criterios) {
        this.criterios = criterios;
    }

    @Override
    public boolean cumpleCriterio(Articulo articulo) {
        return criterios.stream().allMatch(c -> c.cumpleCriterio(articulo));
    }
}
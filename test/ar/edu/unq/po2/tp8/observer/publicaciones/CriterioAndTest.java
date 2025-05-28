
package ar.edu.unq.po2.tp8.observer.publicaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CriterioAndTest {

    @Test
    void criterioAndTrueSiTodosCoinciden() {
        Articulo a = new Articulo("A", List.of(), "", "Artículo", "Smalltalks", List.of("Java"));
        CriterioMatcher c1 = new CriterioPorConferencia("Smalltalks");
        CriterioMatcher c2 = new CriterioPorTipo("Artículo");
        CriterioMatcher c3 = new CriterioPorPalabraClave("Java");

        CriterioMatcher and = new CriterioAnd(List.of(c1, c2, c3));
        assertTrue(and.cumpleCriterio(a));
    }

    @Test
    void criterioAndFalseSiUnoNoCoincide() {
        Articulo a = new Articulo("A", List.of(), "", "Artículo", "Smalltalks", List.of("Ruby"));
        CriterioMatcher c1 = new CriterioPorConferencia("Smalltalks");
        CriterioMatcher c2 = new CriterioPorTipo("Artículo");
        CriterioMatcher c3 = new CriterioPorPalabraClave("Java");

        CriterioMatcher and = new CriterioAnd(List.of(c1, c2, c3));
        assertFalse(and.cumpleCriterio(a));
    }
}

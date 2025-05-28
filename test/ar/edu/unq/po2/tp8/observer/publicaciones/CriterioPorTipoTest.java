
package ar.edu.unq.po2.tp8.observer.publicaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CriterioPorTipoTest {

    @Test
    void criterioPorTipoDevuelveTrueSiCoincide() {
        Articulo a = new Articulo("A", List.of(), "", "Poster", "", List.of());
        CriterioMatcher c = new CriterioPorTipo("Poster");
        assertTrue(c.cumpleCriterio(a));
    }

    @Test
    void criterioPorTipoDevuelveFalseSiNoCoincide() {
        Articulo a = new Articulo("A", List.of(), "", "Artículo", "", List.of());
        CriterioMatcher c = new CriterioPorTipo("Poster");
        assertFalse(c.cumpleCriterio(a));
    }
}

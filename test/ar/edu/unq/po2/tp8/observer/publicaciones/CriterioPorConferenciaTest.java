
package ar.edu.unq.po2.tp8.observer.publicaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CriterioPorConferenciaTest {

    @Test
    void cumpleCriterioDevuelveTrueSiCoincide() {
        Articulo a = new Articulo("A", List.of(), "", "", "Smalltalks", List.of());
        CriterioMatcher criterio = new CriterioPorConferencia("Smalltalks");
        assertTrue(criterio.cumpleCriterio(a));
    }

    @Test
    void cumpleCriterioDevuelveFalseSiNoCoincide() {
        Articulo a = new Articulo("A", List.of(), "", "", "PLDI", List.of());
        CriterioMatcher criterio = new CriterioPorConferencia("Smalltalks");
        assertFalse(criterio.cumpleCriterio(a));
    }
}

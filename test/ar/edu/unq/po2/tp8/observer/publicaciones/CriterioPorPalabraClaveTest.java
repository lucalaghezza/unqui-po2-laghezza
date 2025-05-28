
package ar.edu.unq.po2.tp8.observer.publicaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CriterioPorPalabraClaveTest {

    @Test
    void cumpleCriterioTrueSiPalabraPresente() {
        Articulo a = new Articulo("A", List.of(), "", "", "", List.of("OOP", "Java"));
        CriterioMatcher c = new CriterioPorPalabraClave("Java");
        assertTrue(c.cumpleCriterio(a));
    }

    @Test
    void cumpleCriterioFalseSiPalabraAusente() {
        Articulo a = new Articulo("A", List.of(), "", "", "", List.of("AI"));
        CriterioMatcher c = new CriterioPorPalabraClave("Java");
        assertFalse(c.cumpleCriterio(a));
    }
}

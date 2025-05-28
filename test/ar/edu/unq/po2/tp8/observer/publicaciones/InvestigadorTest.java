
package ar.edu.unq.po2.tp8.observer.publicaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class InvestigadorTest {

    @Test
    void investigadorRecibeArticuloCorrectamente() {
        Investigador inv = new Investigador("Laura", null);
        Articulo articulo = new Articulo("Test", List.of("A"), "UNQ", "Artículo", "Conf", List.of("AI"));

        inv.recibirArticulo(articulo);

        assertEquals(1, inv.getArticulosRecibidos().size());
        assertEquals("Test", inv.getArticulosRecibidos().stream().findFirst().get().getTitulo());
    }
}

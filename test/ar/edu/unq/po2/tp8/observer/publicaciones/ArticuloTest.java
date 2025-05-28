
package ar.edu.unq.po2.tp8.observer.publicaciones;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArticuloTest {

    @Test
    void articuloGuardaYRetornaDatosCorrectamente() {
        Articulo articulo = new Articulo("Título", List.of("Ana", "Juan"), "UNQ",
                "Artículo", "Smalltalks", List.of("OOP", "Java"));

        assertEquals("Título", articulo.getTitulo());
        assertEquals("UNQ", articulo.getFilicacion());
        assertEquals("Artículo", articulo.getTipo());
        assertEquals("Smalltalks", articulo.getLugarPublicacion());
        assertTrue(articulo.getAutores().contains("Ana"));
        assertTrue(articulo.getPalabrasClave().contains("Java"));
    }
}

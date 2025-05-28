
package ar.edu.unq.po2.tp8.observer.publicaciones;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class SistemaBibliograficoTest {

    @Test
    void sistemaNotificaSuscripciones() {
        SistemaBibliografico sistema = new SistemaBibliografico();
        Suscripcion suscripcion = mock(Suscripcion.class);
        Articulo articulo = mock(Articulo.class);

        sistema.agregarSuscripcion(suscripcion);
        sistema.agregarArticulo(articulo);

        verify(suscripcion).notificar(articulo);
    }
}

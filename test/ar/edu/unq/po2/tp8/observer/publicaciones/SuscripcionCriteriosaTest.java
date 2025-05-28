package ar.edu.unq.po2.tp8.observer.publicaciones;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class SuscripcionCriteriosaTest {

    @Test
    void notificaAlSuscriptorSiCumpleCriterio() {
        // Mocks
        CriterioMatcher criterio = mock(CriterioMatcher.class);
        Suscriptor suscriptor = mock(Suscriptor.class);

        // Stub del criterio: se cumple
        Articulo articulo = mock(Articulo.class);
        when(criterio.cumpleCriterio(articulo)).thenReturn(true);

        // Suscripción
        SuscripcionCriteriosa suscripcion = new SuscripcionCriteriosa(criterio);
        suscripcion.suscribe(suscriptor);

        // Acción
        suscripcion.notificar(articulo);

        // Verificación
        verify(suscriptor, times(1)).recibirArticulo(articulo);
    }

    @Test
    void noNotificaSiCriterioNoSeCumple() {
        CriterioMatcher criterio = mock(CriterioMatcher.class);
        Suscriptor suscriptor = mock(Suscriptor.class);
        Articulo articulo = mock(Articulo.class);

        when(criterio.cumpleCriterio(articulo)).thenReturn(false);

        SuscripcionCriteriosa suscripcion = new SuscripcionCriteriosa(criterio);
        suscripcion.suscribe(suscriptor);

        suscripcion.notificar(articulo);

        verify(suscriptor, never()).recibirArticulo(any());
    }
}

package ar.edu.unq.po2.tp7.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ActividadServiceTests {

    ActividadService servicio;

    @BeforeEach
    void setUp() {
        List<ActividadSemanal> actividades = List.of(
                new ActividadSemanal(DiaDeLaSemana.LUNES, 10, 1, Deporte.FUTBOL),
                new ActividadSemanal(DiaDeLaSemana.SABADO, 9, 2, Deporte.FUTBOL),
                new ActividadSemanal(DiaDeLaSemana.MARTES, 18, 1, Deporte.BASKET),
                new ActividadSemanal(DiaDeLaSemana.JUEVES, 20, 1, Deporte.JABALINA),
                new ActividadSemanal(DiaDeLaSemana.DOMINGO, 8, 1, Deporte.TENNIS)
        );
        servicio = new ActividadService(actividades);
    }

    @Test
    void testActividadesDeFutbol() {
        List<ActividadSemanal> futbol = servicio.actividadesDeFutbol();
        assertEquals(2, futbol.size());
    }

    @Test
    void testActividadesPorComplejidad() {
        List<ActividadSemanal> complejidad2 = servicio.actividadesPorComplejidad(2);
        assertEquals(3, complejidad2.size()); // futbol (2) y basket
    }

    @Test
    void testTotalHoras() {
        assertEquals(6, servicio.totalHoras());
    }

    @Test
    void testActividadMenorCostoParaFutbol() {
        Optional<ActividadSemanal> min = servicio.actividadMenorCosto(Deporte.FUTBOL);
        assertTrue(min.isPresent());
        assertEquals(DiaDeLaSemana.LUNES, min.get().getDia()); // porque lunes es más barato
    }

    @Test
    void testActividadMasEconomicaPorDeporte() {
        Map<Deporte, ActividadSemanal> mapa = servicio.actividadMasEconomicaPorDeporte();
        assertEquals(4, mapa.size());
        assertEquals(DiaDeLaSemana.LUNES, mapa.get(Deporte.FUTBOL).getDia());
    }

    @Test
    void testToString() {
        ActividadSemanal actividad = new ActividadSemanal(DiaDeLaSemana.LUNES, 19, 1, Deporte.FUTBOL);
        assertEquals("Deporte: FUTBOL. Dia: LUNES A LAS: 19 . Duración: 1 hora(s).", actividad.toString());
    }
}
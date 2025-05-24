package ar.edu.unq.po2.tp7.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class ColorLesionTests {

    @Test
    void testDescripcionYNivelRiesgo() {
        assertEquals("Lesión activa", ColorLesion.ROJO.getDescripcion());
        assertEquals(3, ColorLesion.ROJO.getNivelRiesgo());

        assertEquals("Lesión en regresión", ColorLesion.GRIS.getDescripcion());
        assertEquals(2, ColorLesion.GRIS.getNivelRiesgo());

        assertEquals("Lesión con secreción", ColorLesion.AMARILLO.getDescripcion());
        assertEquals(4, ColorLesion.AMARILLO.getNivelRiesgo());

        assertEquals("Lesión cicatrizando", ColorLesion.MIEL.getDescripcion());
        assertEquals(1, ColorLesion.MIEL.getNivelRiesgo());
    }

    @Test
    void testSiguienteColor() {
        assertEquals(ColorLesion.GRIS, ColorLesion.ROJO.siguienteColor());
        assertEquals(ColorLesion.AMARILLO, ColorLesion.GRIS.siguienteColor());
        assertEquals(ColorLesion.MIEL, ColorLesion.AMARILLO.siguienteColor());
        assertEquals(ColorLesion.ROJO, ColorLesion.MIEL.siguienteColor()); // circular
    }

    @Test
    void testToString() {
        String esperado = "ROJO (Descripción: Lesión activa, Riesgo: 3)";
        assertEquals(esperado, ColorLesion.ROJO.toString());
    }

    @Test
    void testMaximoNivelDeRiesgo() {
        int maxRiesgo = Arrays.stream(ColorLesion.values())
                .mapToInt(ColorLesion::getNivelRiesgo)
                .max()
                .orElse(-1);

        assertEquals(4, maxRiesgo);
    }
}
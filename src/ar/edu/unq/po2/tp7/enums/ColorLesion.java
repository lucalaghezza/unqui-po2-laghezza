package ar.edu.unq.po2.tp7.enums;

public enum ColorLesion {
    ROJO("Lesión activa", 3),
    GRIS("Lesión en regresión", 2),
    AMARILLO("Lesión con secreción", 4),
    MIEL("Lesión cicatrizando", 1);

    private final String descripcion;
    private final int nivelRiesgo;

    ColorLesion(String descripcion, int nivelRiesgo) {
        this.descripcion = descripcion;
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNivelRiesgo() {
        return nivelRiesgo;
    }

    public ColorLesion siguienteColor() {
        int nextOrdinal = (this.ordinal() + 1) % ColorLesion.values().length;
        return ColorLesion.values()[nextOrdinal];
    }

    @Override
    public String toString() {
        return name() + " (Descripción: " + descripcion + ", Riesgo: " + nivelRiesgo + ")";
    }
}
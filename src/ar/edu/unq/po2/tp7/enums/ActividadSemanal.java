package ar.edu.unq.po2.tp7.enums;

public class ActividadSemanal {
    private DiaDeLaSemana dia;
    private int horaInicio;
    private int duracion; // en horas
    private Deporte deporte;

    public ActividadSemanal(DiaDeLaSemana dia, int horaInicio, int duracion, Deporte deporte) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        this.deporte = deporte;
    }

    public DiaDeLaSemana getDia() {
        return dia;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public int calcularCosto() {
        int costoBasePorHora = switch (dia) {
            case LUNES, MARTES, MIERCOLES -> 500;
            case JUEVES, VIERNES, SABADO, DOMINGO -> 1000;
        };
        return (costoBasePorHora * duracion) + (deporte.getComplejidad() * 200);
    }

    @Override
    public String toString() {
        return String.format("Deporte: %s. Dia: %s A LAS: %d . Duración: %d hora(s).",
                deporte.name(), dia.name(), horaInicio, duracion);
    }
 
}

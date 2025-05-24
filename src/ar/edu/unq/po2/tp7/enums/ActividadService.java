package ar.edu.unq.po2.tp7.enums;

import java.util.*;
import java.util.stream.Collectors;

public class ActividadService {
    private List<ActividadSemanal> actividades;

    public ActividadService(List<ActividadSemanal> actividades) {
        this.actividades = actividades;
    }

    public List<ActividadSemanal> actividadesDeFutbol() {
        return actividades.stream()
                .filter(a -> a.getDeporte() == Deporte.FUTBOL)
                .collect(Collectors.toList());
    }

    public List<ActividadSemanal> actividadesPorComplejidad(int complejidad) {
        return actividades.stream()
                .filter(a -> a.getDeporte().getComplejidad() == complejidad)
                .collect(Collectors.toList());
    }

    public int totalHoras() {
        return actividades.stream()
                .mapToInt(ActividadSemanal::getDuracion)
                .sum();
    }

    public Optional<ActividadSemanal> actividadMenorCosto(Deporte deporte) {
        return actividades.stream()
                .filter(a -> a.getDeporte() == deporte)
                .min(Comparator.comparingInt(ActividadSemanal::calcularCosto));
    }

    public Map<Deporte, ActividadSemanal> actividadMasEconomicaPorDeporte() {
        return actividades.stream()
                .collect(Collectors.groupingBy(
                        ActividadSemanal::getDeporte,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(ActividadSemanal::calcularCosto)),
                                Optional::get
                        )
                ));
    }

    public void imprimirTodasLasActividades() {
        actividades.forEach(System.out::println);
    }
}
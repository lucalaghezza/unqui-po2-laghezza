package ar.edu.unq.po2.tp2.ej1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoPlantaPermanente extends Empleado {
	private int cantidadHijos;
	private int antiguedad = 0;
	private int porcentajeAportesJubilatorios = 15;
	
	
	public EmpleadoPlantaPermanente(String nombre, Double sueldoBasico, String direccion, String estadoCivil, LocalDate fechaDeNacimiento,
			int cantidadHijos) {
		super.setNombre(nombre);
		super.setDireccion(direccion);
		super.setEstadoCivil(estadoCivil);
		super.setFechaDeNacimiento(fechaDeNacimiento);
		super.setSueldoBasico(sueldoBasico);
		this.cantidadHijos = cantidadHijos;
	}
	

	@Override
	public List<Concepto> SueldoBruto() {
		Concepto basico = this.getConceptoSueldoBasico();
		Concepto antiguedad = this.getConceptoAntiguedad();
		Concepto asigNacionPorHijo = this.getConceptoAsignacionPorHijo();
		Concepto asignacionPorConyugue = this.getConceptoAsignacionPorConyugue();
		
		return new ArrayList<>(List.of(basico, antiguedad, asigNacionPorHijo, asignacionPorConyugue));
	}
	
	
	private Concepto getConceptoAntiguedad() {
	 return new Concepto("antiguedad", (double) 50*this.getAntiguedad());
	}
	
	private Concepto getConceptoAsignacionPorHijo() {
		return new Concepto("asignacion por hijo", (double) 150 * this.getCantidadHijos());
	}
	
	private Concepto getConceptoAsignacionPorConyugue() {
		int multiplicador = 0;
		if (super.getEstadoCivil() == "casado" || super.getEstadoCivil() == "union") {
			multiplicador = 1;
		}
		return new Concepto("asignacion por conyugue", (double) 100 * multiplicador);
		
	}

	@Override
	public List<Concepto> Retenciones() {
		Concepto obraSocial = this.getConceptoObraSocial();
		Concepto apotesJubilatorios = this.getConceptoAportesJubilatorios();
		return new ArrayList<>(List.of(obraSocial, apotesJubilatorios));
	}
	
	private Concepto getConceptoObraSocial() {
		Double montoObraSocial = this.MontoSueldoBruto() * super.getPorcentajeObraSocial() / 100; // puede ser super
		Double extraPorHijos = this.getCantidadHijos() * 20.0;
		return new Concepto("obra social", montoObraSocial + extraPorHijos);
	}
	
	private Concepto getConceptoAportesJubilatorios() {
		Double montoJubilatorio = this.MontoSueldoBruto() * this.getPorcentajeAportesJubilatorios() / 100;
		
		return new Concepto("aportes jubilatorios", montoJubilatorio);
	}

	public int getAntiguedad() {
		return this.antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public int getCantidadHijos() {
		return this.cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

	private int getPorcentajeAportesJubilatorios() {
		return porcentajeAportesJubilatorios;
	}

	

}

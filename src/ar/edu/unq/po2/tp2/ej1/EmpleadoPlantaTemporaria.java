package ar.edu.unq.po2.tp2.ej1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoPlantaTemporaria extends Empleado {
	private int cantidadHorasExtra;
	private int añosAportados;
	private int porcentajeAportesJubilatorios = 10;

	public EmpleadoPlantaTemporaria(String nombre, Double sueldoBasico, String direccion, String estadoCivil, LocalDate fechaDeNacimiento,
			int añosAportados) {
		super.setNombre(nombre);
		super.setDireccion(direccion);
		super.setEstadoCivil(estadoCivil);
		super.setFechaDeNacimiento(fechaDeNacimiento);
		super.setSueldoBasico(sueldoBasico);
		this.añosAportados = añosAportados;
	}

	@Override
	public List<Concepto> SueldoBruto() {
		Concepto basico = this.getConceptoSueldoBasico();
		Concepto horasExtra = this.getConceptoHorasExtra();
		return new ArrayList<>(List.of(basico, horasExtra));
	}

	private Concepto getConceptoHorasExtra() {
		return new Concepto("horas extra", (double) 40 * this.getCantidadHorasExtra());
	}

	@Override
	public List<Concepto> Retenciones() {
		Concepto obraSocial = this.getConceptoObraSocial();
		Concepto apotesJubilatorios = this.getConceptoAportesJubilatorios();
		return new ArrayList<>(List.of(obraSocial, apotesJubilatorios));
	}

	private Concepto getConceptoObraSocial() {
		Double montoObraSocial = this.MontoSueldoBruto() * super.getPorcentajeObraSocial() / 100;
		Double extraPorAportes = (this.getAñosAportados() >= 50) ? 25.0 : 0.0;
		return new Concepto("obra social", montoObraSocial + extraPorAportes);
	}

	private Concepto getConceptoAportesJubilatorios() {
		Double montoJubilatorio = this.MontoSueldoBruto() * this.getPorcentajeAportesJubilatorios() / 100;
		Double jubilacionPorHorasExtra = this.getCantidadHorasExtra() * 5.00;

		return new Concepto("aportes jubilatorios", montoJubilatorio + jubilacionPorHorasExtra);
	}

	public int getCantidadHorasExtra() {
		return cantidadHorasExtra;
	}

	public void setCantidadHorasExtra(int cantidadHorasExtra) {
		this.cantidadHorasExtra = cantidadHorasExtra;
	}

	public int getAñosAportados() {
		return añosAportados;
	}

	public void setAñosAportados(int añosAportados) {
		this.añosAportados = añosAportados;
	}

	private int getPorcentajeAportesJubilatorios() {
		return porcentajeAportesJubilatorios;
	}

}
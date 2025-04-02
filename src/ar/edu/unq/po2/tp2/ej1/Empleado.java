package ar.edu.unq.po2.tp2.ej1;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public abstract class Empleado {
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDate fechaDeNacimiento;
	private LocalDate fechaIngreso;
	private Double sueldoBasico;
	private int porcentajeObraSocial = 10;
	private List<ReciboDeHaberes> recibos = new ArrayList<>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fecha) {
		this.fechaDeNacimiento = fecha;
	}

	public LocalDate fechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fecha) {
		this.fechaIngreso = fecha;
	}

	public int AñosDeAntiguedad() {
		return Period.between(this.fechaIngreso(), LocalDate.now()).getYears();
	}

	public int getPorcentajeObraSocial() {
		return porcentajeObraSocial;
	}

	public Double SueldoNeto() {
		return this.MontoSueldoBruto() - this.MontoRetenciones();
	}

	public Double MontoSueldoBruto() {
		return this.SueldoBruto().stream().mapToDouble(Concepto::getMonto).sum();
	}

	public Double MontoRetenciones() {
		return this.Retenciones().stream().mapToDouble(Concepto::getMonto).sum();
	}

	public abstract List<Concepto> SueldoBruto();

	public abstract List<Concepto> Retenciones();

	public List<ReciboDeHaberes> getRecibos() {
		return this.recibos;
	}

	public void agregarRecibo(ReciboDeHaberes recibo) {
		this.recibos.add(recibo);
	}

	public Double getSueldoBasico() {
		return this.sueldoBasico;
	}

	public void setSueldoBasico(Double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	public Concepto getConceptoSueldoBasico() {
		return new Concepto("sueldo basico", this.getSueldoBasico());
	}

}

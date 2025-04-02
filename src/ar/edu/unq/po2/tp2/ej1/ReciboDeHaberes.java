package ar.edu.unq.po2.tp2.ej1;

import java.time.LocalDate;
import java.util.List;

public class ReciboDeHaberes {
	private String NombreEmpleado;
	private String DireccionEmpleado;
	private LocalDate FechaEmision;
	private Double MontoSueldoBruto;
	private Double MontoSueldoNeto;
	private List<Concepto> Retenciones;
	private List<Concepto> SueldoBruto;

	public ReciboDeHaberes(Empleado empleado) {
		this.NombreEmpleado = empleado.getNombre();
		this.DireccionEmpleado = empleado.getDireccion();
		this.FechaEmision = LocalDate.now();
		this.MontoSueldoBruto = empleado.MontoSueldoBruto();
		this.MontoSueldoNeto = empleado.SueldoNeto();
		this.Retenciones = empleado.Retenciones();
		this.SueldoBruto = empleado.SueldoBruto();
	}

	public String getNombreEmpleado() {
		return this.NombreEmpleado;
	}

	public String getDireccionEmpleado() {
		return this.DireccionEmpleado;
	}

	public LocalDate getFechaEmision() {
		return this.FechaEmision;
	}

	public Double getMontoSueldoBruto() {
		return this.MontoSueldoBruto;
	}

	public Double getMontoSueldoNeto() {
		return this.MontoSueldoNeto;
	}

	public List<Concepto> Retenciones() {
		return this.Retenciones;
	}

	public List<Concepto> SueldoBruto() {
		return this.SueldoBruto;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Recibo de Haberes - Empleado: ").append(this.NombreEmpleado).append("\n");
		sb.append("Fecha de emisión: ").append(this.FechaEmision).append("\n\n");

		sb.append("Totales:\n");
		sb.append("Sueldo Bruto: ").append(this.MontoSueldoBruto).append("\n");
		sb.append("Sueldo Neto: ").append(this.MontoSueldoNeto).append("\n\n");

		sb.append("Sueldo Bruto:\n");
		if (SueldoBruto != null && !SueldoBruto.isEmpty()) {
			for (Concepto concepto : SueldoBruto) {
				sb.append(concepto).append("\n");
			}
		} else {
			sb.append("No hay conceptos de sueldo bruto.\n");
		}

		sb.append("Retenciones:\n");
		if (Retenciones != null && !Retenciones.isEmpty()) {
			for (Concepto concepto : Retenciones) {
				sb.append(concepto).append("\n");
			}
		} else {
			sb.append("No hay retenciones.\n");
		}

		sb.append("\n");

		return sb.toString();
	}

}

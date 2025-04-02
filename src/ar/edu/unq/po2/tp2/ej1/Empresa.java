package ar.edu.unq.po2.tp2.ej1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private String nombre;
	private String cuit;
	private List<Empleado> empleados;
	private List<ReciboDeHaberes> recibos;

	// Constructor
	public Empresa(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.empleados = new ArrayList<>();
		this.recibos = new ArrayList<>();
	}

	public void agregarEmpleado(Empleado empleado) {
		empleado.setFechaIngreso(LocalDate.now());
		empleados.add(empleado);
	}

	public Double calcularTotalSueldosNetos() {
		return empleados.stream().mapToDouble(Empleado::SueldoNeto).sum();

	}

	public void generarLiquidacionSueldos() {
		empleados.forEach(empleado -> this.liquidarSueldo(empleado));
	}

	private void liquidarSueldo(Empleado empleado) {
		ReciboDeHaberes recibo = new ReciboDeHaberes(empleado);
		empleado.agregarRecibo(recibo);
		this.agregarRecibo(recibo);
	}

	public String getCuit() {
		return this.cuit;
	}

	public String getNombre() {
		return this.nombre;
	}

	public List<ReciboDeHaberes> getRecibos() {
		return this.recibos;
	}
	
	public List<Empleado> getEmpleados(){
		return this.empleados;
	}

	public void agregarRecibo(ReciboDeHaberes recibo) {
		this.recibos.add(recibo);
	}

}
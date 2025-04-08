package ar.edu.unq.po2.tp3.persona;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	String nombre;
	LocalDate fechaNacimiento;
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		this.nombre= nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public int getEdad() {
		// la edad se calcula, el mecanismo de abstraccion es el encapsulamiento
		// ya que oculta los detalles del "como", solo sabemos el "que"
		return Period.between(this.getFechaNacimiento(), LocalDate.now()).getYears();
	}
	
	public boolean menorQue(Persona p) {
		// si quiero ser exacto debería comparar las fechas de nacimiento
		// pero para este ejemplo basta con comparar las edades según el enunciado
		return this.getEdad() < p.getEdad();
	}
	
	
	
	
}

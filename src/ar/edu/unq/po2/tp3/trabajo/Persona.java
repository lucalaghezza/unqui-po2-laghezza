package ar.edu.unq.po2.tp3.trabajo;

public class Persona {
	String nombre;
	String apellido;
	int edad;
	
	public Persona(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}


	public int getEdad() {
		return edad;
	}


}

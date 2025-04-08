package ar.edu.unq.po2.tp3.trabajo;

import java.util.ArrayList;
import java.util.List;

public class EquipoDeTrabajo {
	String nombre;
	List<Persona> integrantes;

	public EquipoDeTrabajo(String nombre, List<Persona> integrantes) {
		this.nombre = nombre;
		this.integrantes = integrantes;
	}
	
	public EquipoDeTrabajo(String nombre) {
		this.nombre = nombre;
		this.integrantes = new ArrayList<Persona>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getIntegrantes() {
		return integrantes;
	}

	public void agregarIntegrante(Persona integrante) {
		this.integrantes.add(integrante);
	}

	public int getPromedioEdad() {
		// decido retornar 0 en vez que un error
		if (this.getIntegrantes().isEmpty()) {
			return 0;
		}
		return this.getIntegrantes().stream().mapToInt(Persona::getEdad).sum() / this.getIntegrantes().size();

	}

}

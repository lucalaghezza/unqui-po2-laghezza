package ar.edu.unq.po2.tp6.state.videojuegos;

public class MaquinaVideoJuegos {
	private FichasState estadoInicial;
	private FichasState estadoFichas;
	
	public MaquinaVideoJuegos(FichasState estadoInicio) {
		this.estadoFichas = estadoInicio;
		this.estadoInicial = estadoInicio;
	}

	public void insertarFicha() {
		this.estadoFichas.insertarFicha(this);
	}

	public void iniciar() {
		this.estadoFichas.iniciar(this);
		this.setEstadoFichas(estadoInicial);
	}
	
	public void setEstadoFichas(FichasState estado) {
		this.estadoFichas = estado;
	}
	
	public FichasState getEstadoFichas() {
		return this.estadoFichas;
	}
}

package ar.edu.unq.po2.tp6.state.videojuegos;

public class UnaFicha extends FichasState {
	private FichasState estadoAlInsertarFicha;
	
	public UnaFicha(FichasState estadoAlInsertarFicha) {
		this.estadoAlInsertarFicha = estadoAlInsertarFicha;
	}

	@Override
	public void iniciar(MaquinaVideoJuegos m) {
		System.out.println("Iniciando juego para 1 jugador");
		
	}

	@Override
	public void insertarFicha(MaquinaVideoJuegos m) {
		System.out.println("Ficha insertada");
		m.setEstadoFichas(this.estadoAlInsertarFicha);
		
	}

}
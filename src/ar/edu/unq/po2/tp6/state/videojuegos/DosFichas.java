package ar.edu.unq.po2.tp6.state.videojuegos;

public class DosFichas extends FichasState {


	@Override
	public void iniciar(MaquinaVideoJuegos m) {
		System.out.println("Iniciando juego para 2 jugadores");
		
	}

	@Override
	public void insertarFicha(MaquinaVideoJuegos m) {
		System.out.println("Ya hay un maximo de fichas");		
	}

}

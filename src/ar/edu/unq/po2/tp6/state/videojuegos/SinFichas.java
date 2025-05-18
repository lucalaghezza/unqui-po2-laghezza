package ar.edu.unq.po2.tp6.state.videojuegos;

public class SinFichas extends FichasState {
	private FichasState estadoAlInsertarFichas;
	
	public SinFichas(FichasState estadoAlInsertarFichas) {
		this.estadoAlInsertarFichas = estadoAlInsertarFichas;
	}

	@Override
	public void iniciar(MaquinaVideoJuegos m) {
		System.out.println("Maquina encendida, No hay fichas");
		
	}

	@Override
	public void insertarFicha(MaquinaVideoJuegos m) {
		System.out.println("Ficha insertada");
		m.setEstadoFichas(estadoAlInsertarFichas);
		
	}

}

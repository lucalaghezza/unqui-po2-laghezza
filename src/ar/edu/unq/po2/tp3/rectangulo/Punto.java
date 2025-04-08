package ar.edu.unq.po2.tp3.rectangulo;

public class Punto {

	int x;
	int y;

	public Punto(int x, int y) {
		super(); // convención, hace lo que hace mi padre (en este caso object)
		this.x = x;
		this.y = y;
	}

	public Punto() {
		// TODO Auto-generated constructor stub
		this.x = 0;
		this.y = 0;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	/**
	 * Este es el método setter
	 * @param y es el valor para el segundo componente
	 * @author luca
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	public void moverA(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public void sumar(Punto p) {
		this.x += p.getX();
		this.y += p.getY();
	}
}

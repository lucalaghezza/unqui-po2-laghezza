package ar.edu.unq.po2.tp3.rectangulo;

public class Rectangulo {
	int base;
	int altura;
	Punto puntoOrigen;

	public Rectangulo(int base, int altura, Punto puntoOrigen) {
		super();
		this.base = base;
		this.altura = altura;
		this.puntoOrigen = puntoOrigen;
	}

	
	public int getBase() {
		return base;
	}

	public void setBase(int b) {
		this.base = b;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int a) {
		this.altura = a;
	}


	public Punto getPuntoOrigen() {
		return puntoOrigen;
	}


	public int getArea() {
		return this.getBase() * this.getAltura();
	}
	
	public int getPerimetro() {
		return 2 * (this.getBase() + this.getAltura());
	}
	
	// Determinar si el rectángulo es horizontal o vertical
    public String getOrientacion() {
        if (base > altura) {
            return "Horizontal";
        } else if (base < altura) {
            return "Vertical";
        } else {
            return "Cuadrado";
        }
    }
	
}

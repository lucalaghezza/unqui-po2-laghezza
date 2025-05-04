package ar.edu.unq.po2.tp4.trabajo;

public class IngresoPorHorasExtras extends Ingreso {
	int cantHorasExtra;

	public IngresoPorHorasExtras(String mes, String concepto, Double monto, int hsExtra) {
		super(mes, concepto, monto);
		this.cantHorasExtra = hsExtra;
	}
	
	@Override
	public double getMontoImponible() {
		return 0; // los ingresos por horas extra no son imponibles
		
	}

}

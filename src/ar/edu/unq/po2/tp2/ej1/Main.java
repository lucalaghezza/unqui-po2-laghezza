package ar.edu.unq.po2.tp2.ej1;

import java.time.LocalDate;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		EmpleadoPlantaPermanente empleadoPermanente = new EmpleadoPlantaPermanente("Jose", 180000.50, "Madrid 18", "casado",
				LocalDate.of(2018, 12, 9), 3);
		EmpleadoPlantaPermanente empleadoPermanente2 = new EmpleadoPlantaPermanente("Jose2", 182000.00, "Madrid 182", "soltero",
				LocalDate.of(2014, 12, 9), 0);

		EmpleadoPlantaTemporaria empleadoTemporaria = new EmpleadoPlantaTemporaria("Juan", 90000.0, "Temporal", "soltero",
				LocalDate.of(2018, 3, 14), 10);
		EmpleadoPlantaTemporaria empleadoTemporaria2 = new EmpleadoPlantaTemporaria("Juan2", 80000.0, "Temporal2", "casado",
				LocalDate.of(2015, 3, 14), 51);

		Empresa empresa = new Empresa("nombre", "20-1812-09");

		empresa.agregarEmpleado(empleadoPermanente);
		empresa.agregarEmpleado(empleadoPermanente2);
		empresa.agregarEmpleado(empleadoTemporaria2);
		empresa.agregarEmpleado(empleadoTemporaria);
		
		empleadoPermanente.setAntiguedad(10);

		System.out.println("Total Sueldos netos: " + empresa.calcularTotalSueldosNetos().toString());

		empresa.generarLiquidacionSueldos();

		List<ReciboDeHaberes> recibos = empresa.getRecibos();

		System.out.println("Recibos:");
		recibos.forEach(recibo -> System.out.println(recibo.toString()));

	}

}

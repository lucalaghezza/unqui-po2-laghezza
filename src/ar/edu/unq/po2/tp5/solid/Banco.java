package ar.edu.unq.po2.tp5.solid;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private List<Cliente> clientes;
	private List<SolicitudDeCredito> solicitudes;

	public Banco() {
		this.clientes = new ArrayList<Cliente>();
		this.solicitudes = new ArrayList<SolicitudDeCredito>();
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public List<SolicitudDeCredito> getSolicitudes() {
		return this.solicitudes;
	}

	public double montoADesembolsar() {
		return this.getSolicitudes().stream().filter(s -> s.esAceptable()).mapToDouble(s -> s.getMontoSolicitado())
				.sum();
	}

	public void agregarCliente(Cliente cliente1) {
		if (!this.getClientes().contains(cliente1)) {
			this.clientes.add(cliente1);
		}

	}

	public void registrarSolicitud(SolicitudDeCredito solicitudCredito1) throws Exception {
		if (!this.getClientes().contains(solicitudCredito1.getClienteSolicitador())){
			throw new Exception("El cliente no etá registrado en el banco");
		}
		this.solicitudes.add(solicitudCredito1);

	}
}

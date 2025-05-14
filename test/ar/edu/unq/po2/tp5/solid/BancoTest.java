package ar.edu.unq.po2.tp5.solid;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BancoTest {
	private Banco banco;
	private Cliente cliente1;
	private SolicitudDeCredito solicitudCredito1;
	private PropiedadInmobiliaria propiedad;
	private SolicitudDeCredito solicitudCreditoH;

	@BeforeEach
	public void setUp() {
		banco = new Banco();
		cliente1 = new Cliente("jose", "paradela", "madrid 2018", 31, 1250d); // 15000 anual
		solicitudCredito1 = new SolicitudCreditoPersonal(4375d, cliente1, 5); // cuotas de 875 -> 70% de 1250
		propiedad = new PropiedadInmobiliaria("desc", "test", 10000d);
		solicitudCreditoH = new SolicitudCreditoHipotecario(1250d, cliente1, 2, propiedad); // cuotas de 750d -> 50% 1250
	}

	@Test
	public void testEmptyBanco() {
		assertEquals(0, banco.montoADesembolsar());
		assertEquals(0, banco.getClientes().size());
		assertEquals(0, banco.getSolicitudes().size());

	}

	@Test
	public void testAgregarCliente() {
		banco.agregarCliente(cliente1);

		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(0, banco.getSolicitudes().size());
	}

	@Test
	public void testAgregar2VecesElMismoCliente() {
		banco.agregarCliente(cliente1);
		banco.agregarCliente(cliente1);

		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(0, banco.getSolicitudes().size());
	}

	@Test
	public void testAgregarSolicitudPersonalDeUnCliente() throws Exception {
		banco.agregarCliente(cliente1);
		banco.registrarSolicitud(solicitudCredito1);

		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(1, banco.getSolicitudes().size());
		assertEquals(solicitudCredito1, banco.getSolicitudes().getFirst());
	}

	@Test
	public void testSolicitudPersonalEsAceptableValoresOk() throws Exception { // acá lo ideal sería mockear..
		banco.agregarCliente(cliente1);
		banco.registrarSolicitud(solicitudCredito1);

		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(1, banco.getSolicitudes().size());
		assertEquals(solicitudCredito1, banco.getSolicitudes().getFirst());
		assertTrue(solicitudCredito1.esAceptable());
		assertEquals(solicitudCredito1.getMontoSolicitado(), banco.montoADesembolsar());
	}
	
	@Test
	public void testSolicitudPersonalNoEsAceptableSueldoInsuficiente() throws Exception { // acá lo ideal sería mockear..
		banco.agregarCliente(cliente1);
		cliente1.setSueldoNetoMensual(1000d); // 12000 anual
		banco.registrarSolicitud(solicitudCredito1);

		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(1, banco.getSolicitudes().size());
		assertEquals(solicitudCredito1, banco.getSolicitudes().getFirst());
		assertFalse(solicitudCredito1.esAceptable());
		assertEquals(0d, banco.montoADesembolsar());
	}
	
	@Test
	public void testSolicitudPersonalNoEsAceptableMontoSuperior() throws Exception { // acá lo ideal sería mockear..
		banco.agregarCliente(cliente1);
		solicitudCredito1 = new SolicitudCreditoPersonal(4375.10d, cliente1, 5); // cuotas de 875.01 > 70% de 1250
		banco.registrarSolicitud(solicitudCredito1);

		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(1, banco.getSolicitudes().size());
		assertEquals(solicitudCredito1, banco.getSolicitudes().getFirst());
		assertFalse(solicitudCredito1.esAceptable());
		assertEquals(0d, banco.montoADesembolsar());
	}
	
	@Test
	public void testAgregarSolicitudHipotecariaDeUnCliente() throws Exception {
		banco.agregarCliente(cliente1);
		banco.registrarSolicitud(solicitudCreditoH);

		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(1, banco.getSolicitudes().size());
		assertEquals(solicitudCreditoH, banco.getSolicitudes().getFirst());
	}

	
	@Test
	public void testSolicitudHipotecariaEsAceptableValoresOk() throws Exception { // acá lo ideal sería mockear..
		banco.agregarCliente(cliente1);
		banco.registrarSolicitud(solicitudCreditoH);

		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(1, banco.getSolicitudes().size());
		assertEquals(solicitudCreditoH, banco.getSolicitudes().getFirst());
		assertTrue(solicitudCreditoH.esAceptable());
		assertEquals(solicitudCreditoH.getMontoSolicitado(), banco.montoADesembolsar());
	}
	
	
	@Test
	public void testSolicitudHipotecariaNoEsAceptableSueldoInsuficiente() throws Exception { // acá lo ideal sería mockear..
		banco.agregarCliente(cliente1);
		cliente1.setSueldoNetoMensual(1000d); // 12000 anual
		banco.registrarSolicitud(solicitudCreditoH);

		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(1, banco.getSolicitudes().size());
		assertEquals(solicitudCreditoH, banco.getSolicitudes().getFirst());
		assertFalse(solicitudCreditoH.esAceptable());
		assertEquals(0d, banco.montoADesembolsar());
	}
	
	
	
	@Test
	public void testSolicitudHipotecariaNoEsAceptableMontoSuperiorInmobiliario() throws Exception { // acá lo ideal sería mockear..
		banco.agregarCliente(cliente1);
		solicitudCreditoH = new SolicitudCreditoHipotecario(7001d, cliente1, 5, propiedad); // > 70% de la prop
		banco.registrarSolicitud(solicitudCreditoH);

		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(1, banco.getSolicitudes().size());
		assertEquals(solicitudCreditoH, banco.getSolicitudes().getFirst());
		assertFalse(solicitudCreditoH.esAceptable());
		assertEquals(0d, banco.montoADesembolsar());
	}
	
	@Test
	public void testSolicitudHipotecariaNoEsAceptableMayorDe65() throws Exception { // acá lo ideal sería mockear..
		cliente1 = new Cliente("Pity", "Martinez", "Bernabeu", 66, 1250d);
		solicitudCreditoH = new SolicitudCreditoHipotecario(1250d, cliente1, 2, propiedad);
		banco.agregarCliente(cliente1);
		banco.registrarSolicitud(solicitudCreditoH);

		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(1, banco.getSolicitudes().size());
		assertEquals(solicitudCreditoH, banco.getSolicitudes().getFirst());
		assertFalse(solicitudCreditoH.esAceptable());
		assertEquals(0, banco.montoADesembolsar());
	}
	
	@Test
	public void testSumarMontoADesembolsar2Solicitudes() throws Exception {
		banco.agregarCliente(cliente1);
		banco.registrarSolicitud(solicitudCredito1);
		banco.registrarSolicitud(solicitudCreditoH);
		
		double expectedAmount = solicitudCredito1.getMontoSolicitado() + solicitudCreditoH.getMontoSolicitado();
		
		assertEquals(1, banco.getClientes().size());
		assertEquals(cliente1, banco.getClientes().getFirst());
		assertEquals(2, banco.getSolicitudes().size());
		assertEquals(expectedAmount, banco.montoADesembolsar());
	}
	
	@Test
	public void testAgregarSolicitudNoEsClienteEntoncesError() {
		
		
		Exception except = assertThrows(Exception.class,() -> banco.registrarSolicitud(solicitudCredito1));
		
		assertEquals("El cliente no etá registrado en el banco", except.getMessage());
		assertEquals(0, banco.getClientes().size());
		assertEquals(0, banco.getSolicitudes().size());
		assertEquals(0, banco.montoADesembolsar());
	}
	

}

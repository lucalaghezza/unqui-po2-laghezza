package ar.edu.unq.po2.tp6.state.mp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class MP3PlayerTest {
	private MP3Player mp3;

	@Before
	public void setUp() {
		Song s = new Song("Mi canción");
		mp3 = new MP3Player(s);
	}

	@Test
	public void testPlayDesdeSeleccion() {
		assertDoesNotThrow(() -> mp3.play());
	}

	@Test
	public void testPauseDesdeSeleccionLanzaExcepcion() {
		assertThrows(IllegalStateException.class, () -> mp3.pause());
	}

	@Test
	public void testStopDesdeSeleccionNoLanzaError() {
		assertDoesNotThrow(() -> mp3.stop()); // no hace nada, pero no lanza excepción
	}

	@Test
	public void testPlayYPauseDesdeReproduciendo() {
		mp3.play(); // cambia a Reproduciendo
		assertDoesNotThrow(() -> mp3.pause()); // cambia a Pausado
	}

	@Test
	public void testPlayDesdeReproduciendoLanzaExcepcion() {
		mp3.play(); // cambia a Reproduciendo
		assertThrows(IllegalStateException.class, () -> mp3.play());
	}

	@Test
	public void testPauseDesdePausadoLanzaExcepcion() {
		mp3.play(); // Reproduciendo
		mp3.pause(); // Pausado
		assertDoesNotThrow(() -> mp3.pause()); // vuelve a reproducir
	}

	@Test
	public void testStopDesdeReproduciendoVuelveASeleccion() {
		mp3.play(); // Reproduciendo
		assertDoesNotThrow(() -> mp3.stop()); // debe volver a Seleccion
	}

	@Test
	public void testStopDesdePausadoVuelveASeleccion() {
		mp3.play(); // Reproduciendo
		mp3.pause(); // Pausado
		assertDoesNotThrow(() -> mp3.stop());
	}

	@Test
	public void testPlayDesdePausadoRetomaReproduccion() {
		mp3.play(); // Reproduciendo
		mp3.pause(); // Pausado
		assertThrows(IllegalStateException.class, () -> mp3.play()); 
	}
}

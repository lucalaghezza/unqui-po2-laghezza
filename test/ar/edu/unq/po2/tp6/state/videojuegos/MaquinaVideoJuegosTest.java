package ar.edu.unq.po2.tp6.state.videojuegos;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MaquinaVideoJuegosTest {
	private MaquinaVideoJuegos maquina;
    private SinFichas sinFichas;
    private UnaFicha unaFicha;
    private DosFichas dosFichas;

    @Before
    public void setup() {
        // Creamos estados y los encadenamos
        dosFichas = new DosFichas();
        unaFicha = new UnaFicha(dosFichas);
        sinFichas = new SinFichas(unaFicha);
        
        maquina = new MaquinaVideoJuegos(sinFichas);
    }

    @Test
    public void testEstadoInicialEsSinFichas() {
        assertTrue(maquina.getEstadoFichas() instanceof SinFichas);
    }

    @Test
    public void testInsertarUnaFichaCambiaAUnaFicha() {
        maquina.insertarFicha();
        assertTrue(maquina.getEstadoFichas() instanceof UnaFicha);
    }

    @Test
    public void testInsertarDosFichasCambiaADosFichas() {
        maquina.insertarFicha(); // pasa a UnaFicha
        maquina.insertarFicha(); // pasa a DosFichas
        assertTrue(maquina.getEstadoFichas() instanceof DosFichas);
    }

    @Test
    public void testInsertarTresFichasNoCambiaEstadoDeDosFichas() {
        maquina.insertarFicha(); // UnaFicha
        maquina.insertarFicha(); // DosFichas
        maquina.insertarFicha(); // No cambia
        assertTrue(maquina.getEstadoFichas() instanceof DosFichas);
    }

    @Test
    public void testIniciarConUnaFichaVuelveASinFichas() {
        maquina.insertarFicha(); // UnaFicha
        maquina.iniciar(); // Juega 1 jugador, vuelve a SinFichas
        assertTrue(maquina.getEstadoFichas() instanceof SinFichas);
    }

    @Test
    public void testIniciarConDosFichasVuelveASinFichas() {
        maquina.insertarFicha(); // UnaFicha
        maquina.insertarFicha(); // DosFichas
        maquina.iniciar(); // Juega 2 jugadores, vuelve a SinFichas
        assertTrue(maquina.getEstadoFichas() instanceof SinFichas);
    }
}


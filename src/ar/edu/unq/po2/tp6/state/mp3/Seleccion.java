package ar.edu.unq.po2.tp6.state.mp3;

public class Seleccion implements MP3State {
    @Override
    public void play(MP3Player player) {
        System.out.println("Reproduciendo canción");
        player.getSong().play();
        player.setState(new Reproduciendo());
    }

    @Override
    public void pause(MP3Player player) {
        throw new IllegalStateException("No se puede pausar si no se está reproduciendo.");
    }

    @Override
    public void stop(MP3Player player) {
        System.out.println("Nada que detener, ya está en selección");
    }
}

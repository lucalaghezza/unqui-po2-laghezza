package ar.edu.unq.po2.tp6.state.mp3;

public class Pausado implements MP3State {
    @Override
    public void play(MP3Player player) {
    	throw new IllegalStateException("No se puede reproducir si no esta en modo selección.");
    }

    @Override
    public void pause(MP3Player player) {
        System.out.println("Reanudando canción");
        player.getSong().play();
        player.setState(new Reproduciendo());
    }

    @Override
    public void stop(MP3Player player) {
        System.out.println("Deteniendo canción pausada");
        player.getSong().stop();
        player.setState(new Seleccion());
    }
}

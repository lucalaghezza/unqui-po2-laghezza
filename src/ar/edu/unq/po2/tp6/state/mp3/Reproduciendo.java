package ar.edu.unq.po2.tp6.state.mp3;

public class Reproduciendo implements MP3State {
    @Override
    public void play(MP3Player player) {
        throw new IllegalStateException("La canción ya está en reproducción.");
    }

    @Override
    public void pause(MP3Player player) {
        System.out.println("Pausando canción");
        player.getSong().pause();
        player.setState(new Pausado());
    }

    @Override
    public void stop(MP3Player player) {
        System.out.println("Deteniendo reproducción");
        player.getSong().stop();
        player.setState(new Seleccion());
    }
}

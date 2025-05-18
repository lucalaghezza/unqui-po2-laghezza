package ar.edu.unq.po2.tp6.state.mp3;

public interface MP3State {
    void play(MP3Player player);
    void pause(MP3Player player);
    void stop(MP3Player player);
}

package ar.edu.unq.po2.tp6.state.mp3;

public class MP3Player {
    private MP3State state;
    private Song song;

    public MP3Player(Song song) {
        this.song = song;
        this.state = new Seleccion();
    }

    public void play() {
        state.play(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void stop() {
        state.stop(this);
    }

    public void setState(MP3State state) {
        this.state = state;
    }

    public MP3State getState() {
        return this.state;
    }

    public Song getSong() {
        return this.song;
    }
}
package ar.edu.unq.po2.tp8.observer.publicaciones;

import java.util.List;

public class Articulo {
    private String titulo;
    private List<String> autores;
    private String filicacion;
    private String tipo;
    private String lugarPublicacion;
    private List<String> palabrasClave;

    public Articulo(String titulo, List<String> autores, String filicacion, String tipo, String lugarPublicacion, List<String> palabrasClave) {
        this.titulo = titulo;
        this.autores = autores;
        this.filicacion = filicacion;
        this.tipo = tipo;
        this.lugarPublicacion = lugarPublicacion;
        this.palabrasClave = palabrasClave;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getAutores() {
        return autores;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLugarPublicacion() {
        return lugarPublicacion;
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }
    
    public String getFilicacion() {
    	return this.filicacion;
    }
}
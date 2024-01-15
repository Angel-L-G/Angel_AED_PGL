package es.iespto.agl.recyclerView;

public class Pelicula {
    String titulo;
    int duracion;
    String caratula;

    public Pelicula() {
    }

    public Pelicula(String titulo, int duracion, String caratula) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.caratula = caratula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }
}

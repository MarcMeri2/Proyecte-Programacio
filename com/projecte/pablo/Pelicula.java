import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;

public class Pelicula implements Serializable, Comparable<Pelicula>, Gestionable {

    public enum Genero {
        ACCIO, AVENTURA, COMEDIA, DRAMA, TERROR, FICCIO, FANTASIA, ROMANTIC, MUSICAL, DOCUMENTAL;
    }

    private static int contador = 0;

    private int id;
    private String titulo;
    private int duracion;
    private int anyo;
    private Enum genero;
    private Director director;
    private ArrayList<Actor> actores;

    public Pelicula(String titulo, int duracion, int anyo, Enum<Genero> genero, Director director) {
        contador++;
        this.id = contador;
        this.titulo = titulo;
        this.duracion = duracion;
        this.anyo = anyo;
        this.genero = genero;
        this.director = director;
        this.actores = new ArrayList<Actor>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public void setDurada(int duracion) {
        this.duracion = duracion;
    }
    public int getAnyo() {
        return anyo;
    }
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
    public Enum getGenero() {
        return genero;
    }
    public void setGenero(Enum genero) {
        this.genero = genero;
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }
    public ArrayList<Actor> getActores() {
        return actores;
    }
    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public int compareTo(Pelicula o) {
        if (this.titulo.compareToIgnoreCase(o.getTitulo()) == 0) {
            return 0;
        } else if (this.titulo.compareToIgnoreCase(o.getTitulo()) < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String getIdentificador() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdentificador'");
    }

    @Override
    public String resumen() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resumen'");
    }

    @Override
    public void mostrarDetalles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarDetalles'");
    }

    @Override
    public String toString() {
        return this.id + " | " + this.titulo + " | " + this.director.getNombre() + " | " + this.genero + " | " + this.duracion;
    }

}
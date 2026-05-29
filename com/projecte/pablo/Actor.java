import java.io.Serializable;
import java.time.LocalDate;

public class Actor implements Serializable, Gestionable{
    
    private static int contador = 0;

    private int id;
    private String nombre;
    private int edad;
    private String nacionalidad;
    private LocalDate fechaNacimiento;

    public Actor(String nombre, String nacionalidad, LocalDate fechaNacimiento, int edad) {
        contador++;
        this.id = contador;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
    }

    public static int getContador() {
        return contador;
    }
    public static void setContador(int contador) {
        Actor.contador = contador;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
        return this.id + " | " + this.nombre + " | " + this.edad + " | " + this.nacionalidad + " | " + this.fechaNacimiento;
    } 

}

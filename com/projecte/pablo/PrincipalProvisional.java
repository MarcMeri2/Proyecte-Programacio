import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class PrincipalProvisional {
    
    static ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        
        PrincipalProvisional programa = new PrincipalProvisional();
        programa.inici();

    }

    public void inici() {

        int opcion = 0;

        try {
            
            menuOrdenacio();
            opcion = Integer.parseInt(entrada.nextLine());

            if (opcion > 3 || opcion < 1) {
                throw new IllegalArgumentException("\nError: Valor fuera de rango.\n");
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- ORDEN NATURALMENTE ---");
                    ordenNaturalmente();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\n--- ORDEN POR DURACION ---");
                    comparadorPorDuracion();

                    Iterator<Pelicula> it = peliculas.iterator();

                    while (it.hasNext()) {
                        Pelicula p = it.next();
                        System.out.println(" - " + p.toString());
                    }

                    break;
                case 3:
                    System.out.println("\n--- ORDEN POR AÑO Y TITULO ---");
                    ordenar(new ComparadorPorAnyoTitulo());
                    System.out.println();
                    break;
                default:
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println("\nError: Valor no numerico.\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public void ordenar(Comparator<Pelicula> comparador) {
        Collections.sort(peliculas, comparador);

        Iterator<Pelicula> it = peliculas.iterator();

        while (it.hasNext()) {
            Pelicula p = it.next();
            System.out.println(" - " + p.toString());
        }
    }

    public void ordenNaturalmente() {
        Collections.sort(peliculas);

        Iterator<Pelicula> it = peliculas.iterator();

        while (it.hasNext()) {
            Pelicula p = it.next();
            System.out.println(" - " + p.toString());
        }
    }

    public void comparadorPorDuracion() {
        Collections.sort(peliculas, new Comparator<Pelicula>() {

            @Override
            public int compare(Pelicula o1, Pelicula o2) {
                if (o1.getDurada().compareTo(o2.getDurada()) == 0) {
                    return 0;
                } else if (o1.getDurada().compareTo(o2.getDurada()) < 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
            
        });
    }

    public void menuOrdenacio() {
        System.out.println("===== ELIGE COMP QUIERES ORDENARLO =====");
        System.out.println("1 - Ordenacion por titulo");
        System.out.println("2 - Ordenacion Por duracion");
        System.out.println("3 - Ordenacion por año y titulo");
        System.out.print("\nElige una opcion: ");
    }

    public void mostrarPeliculas() {
        for (Pelicula p : peliculas) {
            System.out.println(" - " + p.toString());
        }
    }

}

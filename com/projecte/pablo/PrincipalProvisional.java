import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class PrincipalProvisional implements Iterable<Pelicula>{
    
    static ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        
        PrincipalProvisional programa = new PrincipalProvisional();
        programa.inici();

    }

    class CatalogoPeliculas implements Iterator<Pelicula> {

        private Pelicula.Genero genero;
        private int duracion;
        int posicion = 0;

        public CatalogoPeliculas(Pelicula.Genero genero, int duracion) {
            this.genero = genero;
            this.duracion = duracion;
        }

        @Override
        public boolean hasNext() {
            while (posicion < peliculas.size() &&
                    (!peliculas.get(posicion).getGenero().equals(genero) ||
                    peliculas.get(posicion).getDuracion() > duracion)) {
                posicion++;
            }
            return posicion < peliculas.size();
        }

        @Override
        public Pelicula next() {
            return peliculas.get(posicion++);
        }

    }

    public void inici() {

        int opcion = 0;

        try {
            
            menuOrdenacio();
            opcion = Integer.parseInt(entrada.nextLine());

            if (opcion > 4 || opcion < 1) {
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
                case 4:
                    System.out.println("\n--- MOSTRAR PELICULAS FILTRADAS ---");
                    System.out.print("Introduce la duracion maxima de la pelicula: ");
                    int duracion = Integer.parseInt(entrada.nextLine());
                    System.out.println("Introduce el genero de la Pelicula: ");
                    String genero = entrada.nextLine();
                    Pelicula.Genero g = Pelicula.Genero.valueOf(genero.toUpperCase());

                    CatalogoPeliculas cp = new CatalogoPeliculas(g, duracion);

                    while (cp.hasNext()) {
                        Pelicula p = cp.next();
                        System.out.println(" - " + p.toString());
                    }
                    
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
                if (Integer.compare(o1.getDuracion(), o2.getDuracion()) == 0) {
                    return 0;
                } else if (Integer.compare(o1.getDuracion(), o2.getDuracion()) < 0) {
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
        System.out.println("4 - Filtrar peliculas por duracion");
        System.out.print("\nElige una opcion: ");
    }

    public void mostrarPeliculas() {
        for (Pelicula p : peliculas) {
            System.out.println(" - " + p.toString());
        }
    }

    @Override
    public Iterator<Pelicula> iterator() {
        return peliculas.iterator();
    }

}

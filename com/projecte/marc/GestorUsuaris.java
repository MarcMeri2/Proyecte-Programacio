import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GestorUsuaris {

    ArrayList<Usuari> usuaris = new ArrayList<Usuari>();
    Scanner entrada = new Scanner(System.in);
    int contadorId = 1;

    public GestorUsuaris() {
        crearAdminAMano();
    }

    public void carregarUsuaris() {
    }

    public void guardarUsuaris() {
    }

    public void registrarUsuari() {
        System.out.println("--- REGISTRAR DE NOU USUARI ---");
        System.out.print("Nom: ");
        String nom = entrada.nextLine();
        System.out.print("Cognoms: ");
        String cognoms = entrada.nextLine();
        System.out.print("Correu: ");
        String correu = entrada.nextLine();
        System.out.print("Poblacio: ");
        String poblacio = entrada.nextLine();
        System.out.print("Data naixement: ");
        String dataNaixement = entrada.nextLine();

        String contrasenya = "";
        boolean coinciden = false;

        while (!coinciden) {
            try {
                System.out.print("Contrasenya: ");
                contrasenya = entrada.nextLine();
                System.out.print("Repetix la contraseña: ");
                String repeteix = entrada.nextLine();

                if (!contrasenya.equals(repeteix)) {
                    throw new IllegalArgumentException("Error: Les contrasenyes no coincideixen");
                }

                coinciden = true;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        UsuariNormal nou = new UsuariNormal(contadorId, nom, cognoms, correu, contrasenya, poblacio, dataNaixement);
        usuaris.add(nou);

        crearCarpetaPersonal(nou);

        System.out.println("Usuari registrat amb ID: " + contadorId );
        contadorId++;
    }

    public void crearCarpetaPersonal(Usuari u) {
        int posicioAt = u.getCorreuElectronic().indexOf("@");
        String partCorreu = u.getCorreuElectronic().substring(0, posicioAt);

        String nomCarpeta = u.getId() + partCorreu;
        File carpeta = new File(nomCarpeta);
        carpeta.mkdirs();

        File fPelicules = new File(carpeta, "pelicules.llista");
        File fActors = new File(carpeta, "actors.llista");
        File fDirectors = new File(carpeta, "directors.llista");

        try {
            fPelicules.createNewFile();
            fActors.createNewFile();
            fDirectors.createNewFile();
        } catch (IOException e) {
            System.out.println("\nError en crear fitxers: " + e.getMessage() + "\n");
        }
    }

    public Usuari login() {
        Usuari inicisesio = null;

        while (inicisesio == null) {
            System.out.println("--- INICI DE SESSIO ---");
            System.out.print("Usuari (Nom): ");
            String nomIn = entrada.nextLine();
            System.out.print("Contrasenya: ");
            String contrasenyaIN = entrada.nextLine();

            try {
                Iterator<Usuari> it = usuaris.iterator();
                boolean trobat = false;

                while (it.hasNext() && !trobat) {
                    Usuari u = it.next();
                    if (u.getNom().equals(nomIn) && u.getContrasenya().equals(contrasenyaIN)) {
                        System.out.println("\nLogin correcte. Rol: " + u.getRolUsuari() + "\n");
                        inicisesio = u;
                        trobat = true;
                    }
                }

                if (!trobat) {
                    throw new IllegalArgumentException("\nError: Credencials incorrectes.\n");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return inicisesio;
    }

    private void crearAdminAMano() {
        Administrador admin = new Administrador(contadorId, "admin", "admin", "admin@cinema.com", "admin", "local", "01/01/2000");
        usuaris.add(admin);
        contadorId++;
    }
}
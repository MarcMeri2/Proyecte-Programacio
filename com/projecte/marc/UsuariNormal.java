import java.util.ArrayList;

public class UsuariNormal extends Usuari {

    private ArrayList<Pelicula> peliculas;
    private ArrayList<Actor> actores;
    private ArrayList<Director> directores;

    public UsuariNormal(String nom, String cognoms, String correu, String contrasenya,
                        String poblacio, String dataNaixement) {
        super(nom, cognoms, correu, contrasenya, poblacio, dataNaixement, Roles.RolUsuari);

        this.peliculas = new ArrayList<>();
        this.actores = new ArrayList<>();
        this.directores = new ArrayList<>();
    }
}
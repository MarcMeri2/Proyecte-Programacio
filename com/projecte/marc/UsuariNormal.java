import java.util.ArrayList;

public class UsuariNormal extends Usuari {
    private static final long serialVersionUID = 1L;

    private ArrayList<Pelicula> peliculesPersonals;
    private ArrayList<Actor> actorsPersonals;
    private ArrayList<Director> directorsPersonals;

    public UsuariNormal(int id, String nom, String cognoms, String correu, String contrasenya,
                        String poblacio, String dataNaixement) {
        super(id, nom, cognoms, correu, contrasenya, poblacio, dataNaixement, Roles.RolUsuari);

        this.peliculesPersonals = new ArrayList<>();
        this.actorsPersonals = new ArrayList<>();
        this.directorsPersonals = new ArrayList<>();
    }
}
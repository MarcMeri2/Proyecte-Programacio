public class Administrador extends Usuari {

    public Administrador(String nom, String cognoms, String correu, String contrasenya,
                         String poblacio, String dataNaixement) {
        super(nom, cognoms, correu, contrasenya, poblacio, dataNaixement, Roles.RolAdmin);
    }
}
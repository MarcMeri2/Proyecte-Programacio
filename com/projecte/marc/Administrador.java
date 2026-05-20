public class Administrador extends Usuari {

    public Administrador(int id, String nom, String cognoms, String correu, String contrasenya,
                         String poblacio, String dataNaixement) {
        super(id, nom, cognoms, correu, contrasenya, poblacio, dataNaixement, Roles.RolAdmin);
    }
}
import java.io.Serializable;

public class Usuari implements Serializable {

    protected int id;
    protected String nom;
    protected String cognoms;
    protected String correuElectronic;
    protected String contrasenya;
    protected String poblacio;
    protected String dataNaiximent;
    protected Roles rolUsuari;

    public Usuari(int id, String nom, String cognoms, String correuElectronic, String contrasenya, 
                  String poblacio, String dataNaiximent, Roles rolUsuari) {

        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.correuElectronic = correuElectronic;
        this.contrasenya = contrasenya;
        this.poblacio = poblacio;
        this.dataNaiximent = dataNaiximent;
        this.rolUsuari = rolUsuari;
    }

    public String nombreCompleto(){
        return nom + " " + cognoms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getCorreuElectronic() {
        return correuElectronic;
    }

    public void setCorreuElectronic(String correuElectronic) {
        this.correuElectronic = correuElectronic;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public String getDataNaiximent() {
        return dataNaiximent;
    }

    public void setDataNaiximent(String dataNaiximent) {
        this.dataNaiximent = dataNaiximent;
    }

    public Roles getRolUsuari() {
        return rolUsuari;
    }

    public void setRolUsuari(Roles rolUsuari) {
        this.rolUsuari = rolUsuari;
    }
    

}
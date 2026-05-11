public class Categorie {
    private String libelle;
    private int salaire;

    public Categorie(String libelle, int salaire) {
        this.libelle = libelle;
        this.salaire = salaire;
    }

    public int getSalaire() {
        return salaire;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" + "libelle='" + libelle + "', salaire=" + salaire + '}';
    }
}
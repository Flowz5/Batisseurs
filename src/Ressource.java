public class Ressource {
    private String libelle;

    public Ressource(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return "Ressource{" + "libelle='" + libelle + '\'' + '}';
    }
}
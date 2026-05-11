public class Outil {
    private String libelle;
    private int quantite;
    private int prix;
    private Ressource laRessource;

    public Outil(String libelle, Ressource laRessource, int quantite, int prix) {
        this.libelle = libelle;
        this.laRessource = laRessource;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Ressource getLaRessource() {
        return laRessource;
    }

    public int getQuantite() {
        return quantite;
    }

    @Override
    public String toString() {
        return "Outil{" + "libelle='" + libelle + "', quantite=" + quantite + ", prix=" + prix + '}';
    }
}
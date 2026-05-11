import java.util.HashMap;
import java.util.Map;

public class Ouvrier {
    private String nom;
    private Map<Ressource, Integer> lesRessources;
    private Categorie laCategorie;
    private Outil lOutil;

    public Ouvrier(String nom) {
        this.nom = nom;
        this.lesRessources = new HashMap<>();
    }

    public void ajouterRessource(Ressource r, int quantite) {
        this.lesRessources.put(r, quantite);
    }

    public int cout() {
        int coutTotal = 0;
        if (laCategorie != null) {
            coutTotal += laCategorie.getSalaire();
        }
        return coutTotal;
    }

    public int quantiteByRessource(Ressource r) {
        int quantiteBase = lesRessources.getOrDefault(r, 0);

        // Prise en compte du bonus de l'outil s'il correspond à la ressource demandée
        if (lOutil != null && lOutil.getLaRessource().equals(r)) {
            quantiteBase += lOutil.getQuantite();
        }
        return quantiteBase;
    }

    public void setLaCategorie(Categorie laCategorie) {
        this.laCategorie = laCategorie;
    }

    public void equiper(Outil lOutil) {
        this.lOutil = lOutil;
    }

    @Override
    public String toString() {
        return "Ouvrier{" + "nom='" + nom + "', cout=" + cout() + '}';
    }
}
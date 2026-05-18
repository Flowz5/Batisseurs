import java.util.Map;
import java.util.Set;

public class Machine extends Batiment {

    private Map<Ressource, Integer> ressourcesOffertes;
    private boolean estConstruite;

    public Machine(String libelle, int pointVictoire, int gainSesterces, Map<Ressource, Integer> lesMateriaux, Map<Ressource, Integer> ressourcesOffertes) {
        super(libelle, pointVictoire, gainSesterces);

        for (Map.Entry<Ressource, Integer> entree : lesMateriaux.entrySet()) {
            this.ajouterRessource(entree.getKey(), entree.getValue());
        }

        this.ressourcesOffertes = ressourcesOffertes;
        this.estConstruite = false;
    }

    public void setConstruite(boolean statut) {
        this.estConstruite = statut;
    }

    public boolean isConstruite() {
        return this.estConstruite;
    }

    public Set<Ressource> materiauxOfferts() {
        return ressourcesOffertes.keySet();
    }

    public int quantiteByRessourcesOffertes(Ressource ressource) {
        if (this.estConstruite) {
            return this.ressourcesOffertes.getOrDefault(ressource, 0);
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " De plus, lorsque cette machine est construite, elle dispose de " + this.ressourcesOffertes;
    }
}
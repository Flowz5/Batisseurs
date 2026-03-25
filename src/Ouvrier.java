import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ouvrier {
    private String nom;
    private Map<Ressource, Integer> lesRessources;

    public Ouvrier(String nom, HashMap<Ressource, Integer> lesRessources) {
        this.nom = nom;
        this.lesRessources = lesRessources;
    }

    public String getNom() {
        return nom;
    }

    public List<Ressource> ressourcesProduites() {
        return new ArrayList<>(lesRessources.keySet());
    }

    public int quantiteByRessource(Ressource r) {
        return lesRessources.getOrDefault(r, 0);
    }

    @Override
    public String toString() {
        return "Ouvrier{" + "nom='" + nom + '\'' + ", lesRessources=" + lesRessources + '}';
    }
}
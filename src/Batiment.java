import java.util.HashMap;
import java.util.Map;

public class Batiment {
    private String libelle;
    private int pointsVictoire;
    private int gainsSesterces;
    private Map<Ressource, Integer> lesMateriaux;

    public Batiment(String libelle, int pointsVictoire, int gainsSesterces) {
        this.libelle = libelle;
        this.pointsVictoire = pointsVictoire;
        this.gainsSesterces = gainsSesterces;
        this.lesMateriaux = new HashMap<>();
    }

    public void ajouterRessource(Ressource r, int quantite) {
        this.lesMateriaux.put(r, quantite);
    }

    public String getLibelle() {
        return libelle;
    }

    public int quantiteByMateriau(Ressource r) {
        return lesMateriaux.getOrDefault(r, 0);
    }

    public Map<Ressource, Integer> getLesMateriaux() {
        return lesMateriaux;
    }

    @Override
    public String toString() {
        return "Batiment{" + "libelle='" + libelle + "', pointsVictoire=" + pointsVictoire + ", gainsSesterces=" + gainsSesterces + '}';
    }
}
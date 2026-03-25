import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Batiment {
    private String libelle;
    private int pointsVictoire;
    private int gainsSesterces;
    private Map<Ressource, Integer> lesMateriaux;

    public Batiment(String libelle, int pointsVictoire, int gainsSesterces, HashMap<Ressource, Integer> lesMateriaux) {
        this.libelle = libelle;
        this.pointsVictoire = pointsVictoire;
        this.gainsSesterces = gainsSesterces;
        this.lesMateriaux = lesMateriaux;
    }

    public String getLibelle() {
        return libelle;
    }

    public List<Ressource> materiauxNecessaires() {
        return new ArrayList<>(lesMateriaux.keySet());
    }

    public int quantiteByMateriau(Ressource r) {
        return lesMateriaux.getOrDefault(r, 0);
    }

    @Override
    public String toString() {
        return "Batiment{" + "libelle='" + libelle + '\'' + ", pointsVictoire=" + pointsVictoire + ", gainsSesterces=" + gainsSesterces + ", lesMateriaux=" + lesMateriaux + '}';
    }
}
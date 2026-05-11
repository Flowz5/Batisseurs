import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Chantier {
    private boolean termine;
    private Batiment leBatiment;
    private List<Ouvrier> lesOuvriers;

    public Chantier(Batiment leBatiment) {
        this.leBatiment = leBatiment;
        this.lesOuvriers = new ArrayList<>();
        this.termine = false;
    }

    public boolean envoyerTravaillerOuvrier(Ouvrier unOuvrier) {
        if (!termine && !lesOuvriers.contains(unOuvrier)) {
            lesOuvriers.add(unOuvrier);
            return true;
        }
        return false;
    }

    public void retirerOuvrier(Ouvrier unOuvrier) {
        lesOuvriers.remove(unOuvrier);
    }

    public boolean estTermine() {
        if (termine) {
            return true;
        }

        // Vérification logique pour savoir si les ouvriers actuels produisent assez pour le bâtiment
        for (Map.Entry<Ressource, Integer> materiau : leBatiment.getLesMateriaux().entrySet()) {
            Ressource ressourceRequise = materiau.getKey();
            int quantiteRequise = materiau.getValue();

            int quantiteProduite = 0;
            for (Ouvrier ouvrier : lesOuvriers) {
                quantiteProduite += ouvrier.quantiteByRessource(ressourceRequise);
            }

            if (quantiteProduite < quantiteRequise) {
                return false;
            }
        }

        this.termine = true;
        return true;
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Chantier {
    private boolean termine;
    private Batiment leBatiment;
    private List<Ouvrier> lesOuvriers;
    private List<Machine> lesMachinesDeployees;

    public Chantier(Batiment leBatiment) {
        this.leBatiment = leBatiment;
        this.lesOuvriers = new ArrayList<>();
        this.lesMachinesDeployees = new ArrayList<>();
        this.termine = false;
    }

    public boolean envoyerTravaillerOuvrier(Ouvrier unOuvrier) {
        if (!termine && !lesOuvriers.contains(unOuvrier)) {
            lesOuvriers.add(unOuvrier);
            return true;
        }
        return false;
    }

    public boolean envoyerTravaillerMachine(Machine uneMachine) {
        if (!termine && !lesMachinesDeployees.contains(uneMachine) && uneMachine.isConstruite()) {
            lesMachinesDeployees.add(uneMachine);
            return true;
        }
        return false;
    }

    public void retirerOuvrier(Ouvrier unOuvrier) {
        lesOuvriers.remove(unOuvrier);
    }

    public void retirerMachine(Machine uneMachine) {
        lesMachinesDeployees.remove(uneMachine);
    }

    public boolean estTermine() {
        if (termine) {
            return true;
        }

        for (Map.Entry<Ressource, Integer> materiau : leBatiment.getLesMateriaux().entrySet()) {
            Ressource ressourceRequise = materiau.getKey();
            int quantiteRequise = materiau.getValue();

            int quantiteProduite = 0;
            for (Ouvrier ouvrier : lesOuvriers) {
                quantiteProduite += ouvrier.quantiteByRessource(ressourceRequise);
            }

            for (Machine machine : lesMachinesDeployees) {
                quantiteProduite += machine.quantiteByRessourcesOffertes(ressourceRequise);
            }

            if (quantiteProduite < quantiteRequise) {
                return false;
            }
        }

        this.termine = true;

        if (leBatiment instanceof Machine) {
            ((Machine) leBatiment).setConstruite(true);
        }

        return true;
    }
}
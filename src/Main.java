import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ressource pierre = new Ressource("Pierre");
        Ressource bois = new Ressource("Bois");
        Ressource savoir = new Ressource("Savoir");
        Ressource tuile = new Ressource("Tuile");

        Categorie catManoeuvre = new Categorie("Manœuvre", 3);
        Categorie catCompagnon = new Categorie("Compagnon", 4);
        Categorie catMaitre = new Categorie("Maître", 5);

        Ouvrier manoeuvre1 = new Ouvrier("Manœuvre 1");
        manoeuvre1.setLaCategorie(catManoeuvre);
        manoeuvre1.ajouterRessource(savoir, 1);
        manoeuvre1.ajouterRessource(tuile, 1);

        Ouvrier maitre1 = new Ouvrier("Maître 1");
        maitre1.setLaCategorie(catMaitre);
        maitre1.ajouterRessource(pierre, 1);
        maitre1.ajouterRessource(savoir, 1);
        maitre1.ajouterRessource(tuile, 2);

        Ouvrier compagnon1 = new Ouvrier("Compagnon 1");
        compagnon1.setLaCategorie(catCompagnon);
        compagnon1.ajouterRessource(pierre, 1);
        compagnon1.ajouterRessource(tuile, 2);

        Ouvrier compagnon2 = new Ouvrier("Compagnon 2");
        compagnon2.setLaCategorie(catCompagnon);
        compagnon2.ajouterRessource(bois, 1);
        compagnon2.ajouterRessource(tuile, 3);

        Batiment ziggourat = new Batiment("La Ziggourat", 5, 14);
        ziggourat.ajouterRessource(savoir, 2);
        ziggourat.ajouterRessource(tuile, 3);

        List<Ouvrier> ouvriersDisponibles = new ArrayList<>();
        ouvriersDisponibles.add(manoeuvre1);
        ouvriersDisponibles.add(maitre1);
        ouvriersDisponibles.add(compagnon1);
        ouvriersDisponibles.add(compagnon2);

        Chantier chantierEnCours = new Chantier(ziggourat);
        Scanner scanner = new Scanner(System.in);

        int sesterces = 10;
        boolean partieActive = true;

        System.out.println("--- BIENVENUE DANS LES BATISSEURS ---");
        System.out.println("Objectif : Construire " + ziggourat.getLibelle());

        while (partieActive) {
            System.out.println("\n-------------------------------------------------");
            System.out.println("Vos finances : " + sesterces + " sesterces");
            System.out.println("Ouvriers en attente d'affectation :");

            for (int i = 0; i < ouvriersDisponibles.size(); i++) {
                Ouvrier o = ouvriersDisponibles.get(i);
                System.out.println((i + 1) + " - " + o.getNom() + " (Salaire: " + o.cout() + " sesterces)");
            }

            System.out.println("\nChoisissez une action :");
            System.out.println("1 : Envoyer un ouvrier sur le chantier");
            System.out.println("2 : Récolter des fonds (+3 sesterces)");
            System.out.println("3 : Quitter la partie");
            System.out.print("Votre choix : ");

            int choixMenu = scanner.nextInt();

            if (choixMenu == 1) {
                if (ouvriersDisponibles.isEmpty()) {
                    System.out.println("Il n'y a plus d'ouvriers disponibles.");
                } else {
                    System.out.print("Saisissez le numéro de l'ouvrier à recruter : ");
                    int indexChoix = scanner.nextInt() - 1;

                    if (indexChoix >= 0 && indexChoix < ouvriersDisponibles.size()) {
                        Ouvrier ouvrierSelectionne = ouvriersDisponibles.get(indexChoix);

                        if (sesterces >= ouvrierSelectionne.cout()) {
                            sesterces -= ouvrierSelectionne.cout();
                            chantierEnCours.envoyerTravaillerOuvrier(ouvrierSelectionne);
                            ouvriersDisponibles.remove(indexChoix);
                            System.out.println(ouvrierSelectionne.getNom() + " a rejoint le chantier.");

                            if (chantierEnCours.estTermine()) {
                                System.out.println("\nVICTOIRE ! Vous avez terminé " + ziggourat.getLibelle() + ".");
                                System.out.println("Ce bâtiment vous rapporte " + ziggourat.getPointsVictoire() + " points de victoire.");
                                partieActive = false;
                            } else {
                                System.out.println("Le chantier avance, mais des ressources manquent encore.");
                            }
                        } else {
                            System.out.println("Fonds insuffisants pour recruter cet ouvrier.");
                        }
                    } else {
                        System.out.println("Sélection invalide.");
                    }
                }
            } else if (choixMenu == 2) {
                sesterces += 3;
                System.out.println("Vous avez travaillé pour d'autres artisans et gagné 3 sesterces.");
            } else if (choixMenu == 3) {
                System.out.println("Abandon du chantier. À bientôt.");
                partieActive = false;
            } else {
                System.out.println("Action non reconnue.");
            }
        }

        scanner.close();
    }
}
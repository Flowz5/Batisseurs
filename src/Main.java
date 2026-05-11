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

        System.out.println("--- Début de la partie ---");
        Chantier chantier = new Chantier(ziggourat);
        System.out.println("Ouverture du chantier : " + ziggourat.getLibelle());

        Ouvrier[] equipe = {manoeuvre1, maitre1, compagnon1, compagnon2};
        int coutTotal = 0;

        for (Ouvrier ouvrier : equipe) {
            if (!chantier.estTermine()) {
                System.out.println("\nEnvoi de l'ouvrier " + ouvrier.getNom() + " sur le chantier.");
                chantier.envoyerTravaillerOuvrier(ouvrier);
                coutTotal += ouvrier.cout();

                if (chantier.estTermine()) {
                    System.out.println("Victoire ! Le bâtiment " + ziggourat.getLibelle() + " est achevé.");
                    System.out.println("L'investissement total en salaires s'élève à " + coutTotal + " sesterces.");
                    break;
                } else {
                    System.out.println("Le chantier progresse, mais il manque encore des ressources. On continue.");
                }
            }
        }
    }
}
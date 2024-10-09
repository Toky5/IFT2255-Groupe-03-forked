import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Travaux {

    private static List<String> listeTravaux;

    public Travaux() {
        listeTravaux = new ArrayList<>();

    }


    public void ajouterTravail(String travail) {
        listeTravaux.add(travail);
    }



    public static void afficherTravaux() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Assurez-vous que listeTravaux est accessible dans ce contexte
        if (listeTravaux.isEmpty()) {
            System.out.println("Aucun travail en cours.");
            return; // Sortir si la liste est vide
        }

        System.out.println("Travaux en cours dans la municipalité de Montréal :");

        for (int i = 0; i < listeTravaux.size(); i++) {
            System.out.println((i + 1) + ". " + listeTravaux.get(i));
        }

        while (true) {
            System.out.println("Tapez 'EXIT' pour revenir au menu.");
            String choix = scanner.nextLine();

            if (choix.equalsIgnoreCase("EXIT")) {
                System.out.println("Vous revenez au menu.");
                return; // Sortir de la méthode
            } else {
                System.out.println("Choix invalide. Veuillez taper 'EXIT' pour revenir au menu.");
            }
        }
    }



    public static List<String> getListeTravaux() {
        return listeTravaux;
    }




}

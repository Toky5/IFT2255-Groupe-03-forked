import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Acceuil {

    public static void AfficherAcceuilResidents(Resident resident) throws InterruptedException {
        System.out.println("####################Choisissez les options######################");
        System.out.println("1 - Afficher la liste des travaux en cours");
        System.out.println("2 - Requête de travail");
        System.out.println("3 - Signaler Problème");
        System.out.println("4 - Plannification perticipative");
        System.out.println("5 - Géré Notifications");
        System.out.println("EXIT - Quitter");

        // Initialisation de la liste des travaux
        Travaux listeTravaux = new Travaux();
        listeTravaux.ajouterTravail("Réfection de la rue Saint-Denis");
        listeTravaux.ajouterTravail("Construction d'une nouvelle piste cyclable sur le boulevard De Maisonneuve");

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            // Afficher le menu
            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    System.out.println("/////Afficher la liste de travaux en cours/////");
                    listeTravaux.afficherTravaux();  // Affichage de la liste de travaux
                    break;
                case "2":
                    afficherSousMenuRequetes(resident);  //  sous-menuu
                    break;
                case "3":
                    System.out.println("/////Signaler problème/////");
                    resident.signalerProbleme(scanner);
                    break;
                case "4":
                    System.out.println("/////Plannification participative/////");
                    afficherSousMenuPlanification(resident);
                    break;
                case "5":
                    System.out.println("/////Gérer les notifications/////");
                    resident.gererNotif(scanner);
                case "EXIT":
                    System.out.println("Retour à la page d'authentification");
                    exit = true;
                    Main.afficherMenu();
                    break;

                default:
                    System.out.println("Option non valide, veuillez réessayer.");
                    break;
            }
        }
    }

    private static void afficherSousMenuRequetes(Resident resident) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("3 - Soumettre requête de travail");
        System.out.println("4 - Afficher requêtes en cours");
        System.out.println("EXIT - Retour au menu principal");

        boolean retour = false;

        while (!retour) {
            String choixSousMenu = scanner.nextLine();

            switch (choixSousMenu) {
                case "3":
                    System.out.println("-- Soumettre requête --");
                    resident.soummettre();
                    break;

                case "4":
                    System.out.println("-- Requêtes en cours --");
                    System.out.println("- Réfection de la rue Sainte-Catherine, 2024/12/30");
                    System.out.println("- Travaux sur le Boulevard Pie-IX, 2025/01/14");
                    break;

                case "EXIT":
                    retour = true;
                    AfficherAcceuilResidents(resident);
                    break;

                default:
                    System.out.println("Option non valide, veuillez réessayer.");
                    break;
            }
        }
    }
    private static void afficherSousMenuPlanification(Resident resident) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("3 - Envoyer ses préférences de plage horaire");
        System.out.println("4 - Envoyer son avis sur les travaux terminés");
        System.out.println("EXIT - Retour au menu principal");

        boolean retour = false;

        while (!retour) {
            String choixSousMenu = scanner.nextLine();

            switch (choixSousMenu) {
                case "3":
                    System.out.println("Vous pourrez bientôt le faire");
                    break;

                case "4":
                    System.out.println("Vous pourrez bientôt le faire");
                    break;

                case "EXIT":
                    retour = true;
                    AfficherAcceuilResidents(resident);
                    break;

                default:
                    System.out.println("Option non valide, veuillez réessayer.");
                    break;
            }
        }
    }

    public static void afficherAcceuilIntervenant(Intervenant intervenant) throws InterruptedException {
        System.out.println("####################Choisissez les options######################");
        System.out.println("1 - Afficher la liste des requêtes en cours");
        System.out.println("2 - Soumettre une requête de travail");
        System.out.println("3 - Mettre à jour les infos de chantier");
        System.out.println("EXIT - Quitter");

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            String choix = scanner.nextLine(); // Obtenir le choix de l'utilisateur

            switch (choix) {
                case "1":
                    System.out.println("/////Afficher la liste de travaux en cours/////");
                    Travaux.afficherTravaux(); // Affichage de la liste de travaux
                    break;
                case "2":
                    System.out.println("/////Soumettre nouveau projet/////");
                    intervenant.soummettre();
                    break;
                case "3":
                    System.out.println("/////Mettre à jour les infos de chantier/////");
                    System.out.println("RIEN À AFFICHER POUR LE MOMENT!!!!");
                    break;
                case "EXIT":
                    System.out.println("Vous quittez le menu.");
                    exit = true;
                    afficherAcceuilIntervenant(intervenant);
                    break;
                default:
                    System.out.println("Option non valide, veuillez réessayer.");
                    break;
            }
        }
    }

}
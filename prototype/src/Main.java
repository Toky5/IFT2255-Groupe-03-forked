import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            afficherMenu();  // Afficher le menu
            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    System.out.println("Connexion utilisateur sélectionnée.");
                    User.loginUtilisateur();
                    TimeUnit.SECONDS.sleep(2);
                    break;
                case "2":
                    System.out.println("Création de compte sélectionnée.");
                    User.creerCompte();
                    TimeUnit.SECONDS.sleep(2);
                    break;
                case "4":  // Option pour quitter et retourner au menu principal
                    System.out.println("Retour au menu principal...");
                    break;
                case "EXIT":
                    System.out.println("Fermeture de l'application.");
                    exit = true;
                    break;
                default:
                    System.out.println("Option non valide, veuillez réessayer.");
                    break;
            }
        }
    }

    // Afficher un simple menu de login
    public static void afficherMenu() {
        System.out.println("Bienvenue sur MaVille");
        System.out.println("1 - Connexion utilisateur");
        System.out.println("2 - Créer un compte");
        System.out.println("EXIT - Quitter l'application");
        System.out.print("Veuillez sélectionner une option : ");
    }
}
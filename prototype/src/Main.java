import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    static Utilisateur resident = new Resident();
    static Utilisateur intervenant = new Intervenant();
    public static String separator = "################################################################################";

    public static void main(String[] args) throws IOException, InterruptedException {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

         while (!exit) {
            afficherMenu();  // Afficher le menu
            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    System.out.println(separator);
                    System.out.println("Connexion résident sélectionnée.");
                    resident.connection(scanner);
                    
                    break;

                case "2":
                    System.out.println(separator);
                    System.out.println("Connexion intervenant sélectionnée.");
                    intervenant.connection(scanner);
                    
                    break;

                case "3":
                    System.out.println(separator);
                    System.out.println("Création de compte résident sélectionnée.");
                    resident.inscription(scanner);
                    
                    break;

                case "4":
                    System.out.println(separator);
                    System.out.println("Création de compte intervenant sélectionnée.");
                    intervenant.inscription(scanner);
                    
                    break;

                case "EXIT":
                    System.out.println(separator);
                    System.out.println("Fermeture de l'application.");
                    exit = true;
                    break;

                default:
                    System.out.println(separator);
                    System.out.println("Option non valide, veuillez réessayer.");
                    break;
            }
        }
    }

    // Afficher un simple menu de login
    public static void afficherMenu() {
        System.out.println("     M     M    AAAAA    V     V    IIIII   L         L         EEEEE ");
        System.out.println("     MM   MM   A     A   V     V      I     L         L         E     ");
        System.out.println("     M M M M   AAAAAAA    V   V       I     L         L         EEEEE ");
        System.out.println("     M  M  M   A     A     V V        I     L         L         E     ");
        System.out.println("     M     M   A     A      V       IIIII   LLLLLL    LLLLLL    EEEEE ");
        System.out.println("\n---------------------- Bienvenue sur Maville! -----------------------");
        System.out.println("\n1 - Connexion résident");
        System.out.println("2 - Connexion intervenant");
        System.out.println("3 - Créer un compte résident");
        System.out.println("4 - Créer un compte intervenant");
        System.out.println("EXIT - Quitter l'application");
        System.out.print("\nVeuillez sélectionner une option:" +
                "\n(ex: tapez 1 pour vous connecter en tant que résident)" +
                "\n");
    }
}

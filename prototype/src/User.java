import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User {

    // Méthode pour gérer la connexion utilisateur
    public static void loginUtilisateur() {
        String BonMail = "User@gmail.com";
        String BonMdp  = "User123";
        Scanner scanner = new Scanner(System.in);
        boolean exit2 = false;

        while (!exit2) {
            System.out.println("Pour quitter, tapez EXIT à tout moment.");
            System.out.println("Entrez votre email: ");
            String emailAuthentificateur = scanner.nextLine();

            // Retour au menu principal si l'utilisateur tape "EXIT"
            if (emailAuthentificateur.equalsIgnoreCase("EXIT")) {
                System.out.println("Retour au menu principal...");
                return;
            }

            if (Objects.equals(emailAuthentificateur, BonMail)) {
                System.out.println("Entrez votre mot de passe:");
                String mdpAuthentificateur = scanner.nextLine();

                if (mdpAuthentificateur.equalsIgnoreCase("EXIT")) {
                    System.out.println("Retour au menu principal...");
                    return;
                }

                if (Objects.equals(mdpAuthentificateur, BonMdp)) {
                    System.out.println("Connexion réussie! Bienvenue dans MaVille...");
                    exit2 = true;
                } else {
                    System.out.println("Mot de passe incorrect, veuillez réessayer.");
                }
            } else {
                System.out.println("Email incorrect, veuillez réessayer.");
            }
        }
    }

    // Méthode pour créer un nouveau compte avec validation
    public static void creerCompte() {
        Scanner scanner = new Scanner(System.in);
        boolean exit3 = false;

        while (!exit3) {
            System.out.println("Pour quitter, tapez EXIT à tout moment.");
            System.out.println("Entrez votre email: ");
            String email = scanner.nextLine();

            if (email.equalsIgnoreCase("EXIT")) {
                System.out.println("Retour au menu principal...");
                return;
            }
            // Chatgpt m'a aidé avec regex.
            // Vérifier que l'email est au format correct
            if (!Pattern.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", email)) {
                System.out.println("Format d'email invalide. Veuillez réessayer.");
                continue;
            }

            System.out.println("Entrez votre mot de passe:");
            String mdp = scanner.nextLine();
            if (mdp.equalsIgnoreCase("EXIT")) {
                System.out.println("Retour au menu principal...");
                return;
            }

            System.out.println("Entrez votre numéro de téléphone:");
            String num = scanner.nextLine();
            if (num.equalsIgnoreCase("EXIT")) {
                System.out.println("Retour au menu principal...");
                return;
            }

            // Vérifier que le numéro de téléphone est un entier
            try {
                Integer.parseInt(num);
            } catch (NumberFormatException e) {
                System.out.println("Numéro de téléphone invalide. Veuillez entrer uniquement des chiffres.");
                continue;
            }

            System.out.println("Entrez votre nom:");
            String nom = scanner.nextLine();
            if (nom.equalsIgnoreCase("EXIT")) {
                System.out.println("Retour au menu principal...");
                return;
            }

            System.out.println("Entrez votre prénom:");
            String prenom = scanner.nextLine();
            if (prenom.equalsIgnoreCase("EXIT")) {
                System.out.println("Retour au menu principal...");
                return;
            }

            System.out.println("Entrez votre adresse:");
            String adresse = scanner.nextLine();
            if (adresse.equalsIgnoreCase("EXIT")) {
                System.out.println("Retour au menu principal...");
                return;
            }

            // Si toutes les informations sont correctes, on sort de la boucle
            System.out.println("Vos informations ont été enregistrer. Compte créé avec succès ! Bienvenue dans MaVille.");

            exit3 = true;
        }
    }
}
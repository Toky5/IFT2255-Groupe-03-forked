import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static Registre registre = new Registre();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("!! Bienvenue dans l'application MaVille !! \n");

        while (true) {
            System.out.println("1. Inscription en tant que Résident");
            System.out.println("2. Inscription en tant qu'Intervenant");
            System.out.println("3. Connexion en tant que Résident");
            System.out.println("4. Connexion en tant qu'Intervenant");
            System.out.println("5. Quitter");

            int choix = getChoix(scanner, 1, 5);

            switch (choix) {
                case 1:
                    inscriptionResident(scanner);
                    break;
                case 2:
                    inscriptionIntervenant(scanner);
                    break;
                case 3:
                    connexionResident(scanner);
                    break;
                case 4:
                    connexionIntervenant(scanner);
                    break;
                case 5:
                    System.out.println("Deconnexion.");
                    scanner.close();
                    return;
            }
        }
    }

    public static int getChoix(Scanner scanner, int min, int max) {
        while (true) {
            System.out.print("Votre choix : ");
            if (scanner.hasNextInt()) {
                int choix = scanner.nextInt();
                scanner.nextLine(); // Consommer la nouvelle ligne restante
                if (choix >= min && choix <= max) {
                    return choix;
                } else {
                    System.out.println("Veuillez entrer un nombre entre " + min + " et " + max + ".");
                }
            } else {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.nextLine(); // Consommer l'entrée incorrecte
            }
        }
    }

    public static void inscriptionResident (Scanner scanner){
        String nom,prenom,email,password,adresse,age,numero;

        while (true) {
            System.out.println("* Entrez votre prenom : ");
            prenom = scanner.nextLine();
            if (!prenom.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. La prenom ne peut pas être vide.");
            }
        }

        while (true) {
            System.out.println("* Entrez votre nom  : ");
            nom = scanner.nextLine();
            if (!nom.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. La nom ne peut pas être vide.");
            }
        }

        while (true) {
            System.out.println("* Entrez votre adresse email  : ");
            email = scanner.nextLine();
            if (!email.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. L'adresse Email ne peut pas être vide.");
            }
        }

        while (true) {
            System.out.println("* Entrez votre adresse  : ");
            adresse = scanner.nextLine();
            if (!adresse.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. L'adresse ne peut pas être vide.");
            }
        }

        while (true) {
            System.out.println("* Entrez votre mots de passe  : ");
            password = scanner.nextLine();
            if (!password.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. Veuillez choisir un mot de passe.");
            }
        }

        while (true) {
            System.out.println("* Entrez votre date de naissance (Format yyyy/mm/dd) : ");
            age = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate birthdate = LocalDate.parse(age,formatter);
            int diff = LocalDate.now().getYear() - birthdate.getYear();

            if (!age.trim().isEmpty() && birthdate.isBefore(LocalDate.now()) && diff >= 16) {
                break;

            } else {
                System.out.println("Age non valide. Il faut avoir 16 ans et plus pour l'inscription.");
            }
        }


        System.out.println(" Entrez votre numéro de téléphone (Optionnel) : ");
        numero = scanner.nextLine();
        if (!numero.trim().isEmpty() && numero.length() == 10) {
            System.out.println("Vous avez choisi d'ajoutez le numéro."+numero);
        } else if (numero.trim().isEmpty()){
            System.out.println("Vous avez choisi de ne pas ajoutez de numéro.");
        }

        Resident resident = new Resident(prenom,nom,email,age,password,adresse,numero);
        registre.inscriptionResident(resident);

        System.out.println("Vos informations ont été enregistrées.");

        System.out.println(resident);
    }

    public static void inscriptionIntervenant (Scanner scanner) {
        String nom,email,password,type,identifiant;

        while (true) {
            System.out.println("* Entrez votre nom  : ");
            nom = scanner.nextLine();
            if (!nom.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. La nom ne peut pas être vide.");
            }
        }

        while (true) {
            System.out.println("* Entrez votre adresse email  : ");
            email = scanner.nextLine();
            if (!email.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. L'adresse Email ne peut pas être vide.");
            }
        }

        while (true) {
            System.out.println("* Entrez votre identifiant à 8 chiffres: ");
            identifiant = scanner.nextLine();
            if (!identifiant.trim().isEmpty() && identifiant.matches("\\d+") && identifiant.length() == 8) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. Veuillez entrez un identifiant valide.");
            }
        }

        while (true) {
            System.out.println("* Entrez votre mots de passe  : ");
            password = scanner.nextLine();
            if (!password.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. Veuillez choisir un mot de passe.");
            }
        }

        while (true) {
            System.out.println("* Veuillez choisir votre secteur d'activité : \n");
            System.out.println("1. Entrepreneur public");
            System.out.println("2. Entrepreneur privé");
            System.out.println("3. Particulier");

            int choix = getChoix(scanner,1,3);

            if (choix == 1) {
                type = "Entrepreneur public";
                break;
            } else if (choix == 2) {
                type = "Entrepreneur privé";
                break;
            } else if (choix == 3) {
                type = "Particulier";
                break;
            } else {
                System.out.println("Veuillez choisir l'une des options citées précédemment.");
            }
        }

        Intervenant intervenant = new Intervenant(nom,email,password,type,identifiant);
        registre.inscriptionIntervenant(intervenant);

        System.out.println("Vos informations ont été enregistrées.");

        System.out.println(intervenant);
    }

    public static void connexionResident(Scanner scanner) {
        String email, password;

        System.out.println("\n Veuillez entrez votre adresse mail");
        email = scanner.nextLine();
        System.out.println("Veuillez entrez votre mot de passe");
        password = scanner.nextLine();

        System.out.println(registre.connexionResident(email,password));
    }

    public static void connexionIntervenant(Scanner scanner) {
        String email, password;

        System.out.println("\n Veuillez entrez votre adresse mail");
        email = scanner.nextLine();
        System.out.println("Veuillez entrez votre mot de passe");
        password = scanner.nextLine();

        System.out.println(registre.connexionIntervenant(email,password));
    }

}
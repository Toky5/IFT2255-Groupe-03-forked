import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm");
    private static final Registre registre = new Registre();
    private static final Repertoire repertoire = new Repertoire();


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
                    Resident resident = inscriptionResident(scanner);
                    break;
                case 2:
                    Intervenant intervenant = inscriptionIntervenant(scanner);
                    lvl2Intervenant(scanner,intervenant);
                    break;
                case 3:
                    Resident resident1 = connexionResident(scanner);
                    break;
                case 4:
                    Intervenant intervenant1 = connexionIntervenant(scanner);
                    lvl2Intervenant(scanner,intervenant1);
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
            System.out.print(" \n Votre choix : \n");
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

    public static Resident inscriptionResident (Scanner scanner){
        String nom,prenom,email,password,adresse,numero;
        LocalDate age;

        while (true) {
            System.out.println("* Entrez votre prenom : ");
            prenom = scanner.nextLine();
            if (!prenom.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. Le prenom ne peut pas être vide.");
            }
        }

        while (true) {
            System.out.println("* Entrez votre nom  : ");
            nom = scanner.nextLine();
            if (!nom.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. Le nom ne peut pas être vide.");
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
            try {
                System.out.println("* Entrez votre date de naissance (Format yyyy/mm/dd) : ");

                String birthdate = scanner.nextLine();
                age = LocalDate.parse(birthdate,formatter);
                int diff = LocalDate.now().getYear() - age.getYear();

                if (!birthdate.trim().isEmpty() && age.isBefore(LocalDate.now()) && diff >= 16) {
                    break;

                } else {
                    System.out.println("Age non valide. Il faut avoir 16 ans et plus pour l'inscription.");
                }
            } catch (DateTimeParseException e){
                System.out.println("Format de date incorrect. Veuillez utiliser le format yyyy/MM/dd.");
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

        System.out.println("Vos informations ont été enregistrées. Bienvenue :"+
                resident.getPrenom()+" "+ resident.getNom());

        return resident;
    }

    public static Intervenant inscriptionIntervenant (Scanner scanner) {
        String nom,email,password,type,identifiant;

        while (true) {
            System.out.println("* Entrez votre nom  : ");
            nom = scanner.nextLine();
            if (!nom.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. Le nom ne peut pas être vide.");
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

        System.out.println("\n Vos informations ont été enregistrées. Bienvenue: "+intervenant.getNom()+ "\n");

        return intervenant;
    }

    public static Resident connexionResident(Scanner scanner) {
        String email, password;

        System.out.println("\n Veuillez entrez votre adresse mail");
        email = scanner.nextLine();
        System.out.println("Veuillez entrez votre mot de passe");
        password = scanner.nextLine();

        return registre.connexionResident(email,password);
    }

    public static Intervenant connexionIntervenant(Scanner scanner) {
        String email, password;

        System.out.println("\n Veuillez entrez votre adresse mail");
        email = scanner.nextLine();
        System.out.println("Veuillez entrez votre mot de passe");
        password = scanner.nextLine();

        return registre.connexionIntervenant(email,password);
    }

    public static void lvl2Intervenant(Scanner scanner, Intervenant intervenant) {
        while (true) {
            System.out.println("Bienvenue : " + intervenant.getNom()+"\n");

            System.out.println("1. Ajouter un projet");

            // Options sur la consultations des requêtes de travail à faire.

            System.out.println("2. Mettre à jour les informations d'un chantier");
            System.out.println("3. Deconnexion");

            int choix = getChoix(scanner, 1, 3);

            switch (choix) {
                case 1:
                    ajoutProjet(scanner,intervenant);
                    break;
                case 2:
                    majInfo(scanner,intervenant);
                    break;
                case 3:
                    System.out.println("\n Deconnexion reussie. Retour à l'accueil.");
                    scanner.close();
                    return;
            }
        }
    }

    public static void ajoutProjet(Scanner scanner, Intervenant intervenant) {
        String titre,description,type,quartiers,rues,jours;
        Date horaireDebut,horaireFin;
        LocalDate dateDebut,dateFin;

        while (true) {
            System.out.println("* Veuillez entrez un titre pour votre projet : ");
            titre = scanner.nextLine();
            if (!titre.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. Le titre ne peut pas être vide.");
            }
        }

        while (true) {
            System.out.println("* Veuillez donner une description détaillé de votre projet : ");
            description = scanner.nextLine();
            if (!description.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Cette case est obligatoire. Veuillez donner une description.");
            }
        }

        while (true) {
            try {
                System.out.println("Veuillez entrez une date de début prévu pour les travaux (format yyyy/mm/dd) :");

                String date1 = scanner.nextLine();
                dateDebut = LocalDate.parse(date1,formatter);

                if (!date1.trim().isEmpty()) {
                    break;

                } else {
                    System.out.println("Cette case est obligatoire. Veuillez entrez une date de debut.");
                }
            } catch (DateTimeParseException e){
                System.out.println("Format de date incorrect. Veuillez utiliser le format yyyy/MM/dd.");
            }
        }

        while (true) {
            try {
                System.out.println("Veuillez entrez une date de fin prévu pour les travaux (format yyyy/mm/dd) :");

                String date2 = scanner.nextLine();
                dateFin = LocalDate.parse(date2,formatter);

                if (!date2.trim().isEmpty()) {
                    break;

                } else {
                    System.out.println("Cette case est obligatoire. Veuillez entrez une date de fin.");
                }
            } catch (DateTimeParseException e){
                System.out.println("Format de date incorrect. Veuillez utiliser le format yyyy/MM/dd.");
            }
        }

        while (true) {
            System.out.println("* Veuillez choisir le type de travaux à effectuer : \n");
            System.out.println("1. Travaux routiers");
            System.out.println("2. Travaux de gaz ou électricité");
            System.out.println("3. Construction ou rénovation");
            System.out.println("4. Entretien paysager");
            System.out.println("5. Travaux liés aux transports en commun");
            System.out.println("6. Travaux de signalisation et éclairage");
            System.out.println("7. Travaux souterrains");
            System.out.println("8. Travaux résidentiel");
            System.out.println("9. Entretien urbain");
            System.out.println("10. Entretien des réseaux de télécommunication");

            int choix = getChoix(scanner,1,10);

            if (choix == 1) {
                type = "Travaux routiers";
                break;
            } else if (choix == 2) {
                type = "Travaux de gaz ou électricité";
                break;
            } else if (choix == 3) {
                type = "Construction ou rénovation";
                break;
            } else if (choix == 4) {
                type = "Entretien paysager";
                break;
            }else if (choix == 5) {
                type = "Travaux liés aux transports en commun";
                break;
            }else if (choix == 6) {
                type = "Travaux de signalisation et éclairage";
                break;
            }else if (choix == 7) {
                type = "Travaux souterrains";
                break;
            }else if (choix == 8) {
                type = "Travaux résidentiel";
                break;
            }else if (choix == 9) {
                type = "Entretien urbain";
                break;
            }else if (choix == 10) {
                type = "Entretien des réseaux de télécommunication";
                break;
            }else {
                System.out.println("Veuillez choisir l'une des options citées précédemment.");
            }
        }

        while (true) {
            try {
                System.out.println("* Veuillez entrez une heure de début des travaux (Format HH:MM): ");
                String horaireD = scanner.nextLine();
                horaireDebut = timeformat.parse(horaireD);

                if (!horaireD.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Cette case est obligatoire. Veuillez entrez une heure de début des travaux.");
                }
            } catch (ParseException e) {
                System.out.println("Format invalide. Veuillez Réessayer");
            }
        }

        while (true) {
            System.out.println("* Veuillez entrez une heure de fin des travaux (Format HH:MM): ");
            try {
                String horaireF = scanner.nextLine();
                horaireFin = timeformat.parse(horaireF);

                if (!horaireF.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Cette case est obligatoire. Veuillez entrez une heure de début des travaux.");
                }
            } catch (ParseException e) {
            System.out.println("Format invalide. Veuillez Réessayer");
        }
        }

        Projet projet = new Projet(titre,description,type,dateDebut,dateFin,horaireDebut,horaireFin,intervenant);

        while (true) {
            System.out.println("* Veuillez choisir les numéros des quartiers affectés parmis ceux ci-dessous " +
                    "(Choisissez le Numéro EXIT pour finir la selection de vos choix): \n");
            System.out.println("1. Montreal");
            System.out.println("2. Longueuil");
            System.out.println("3. Laval");
            System.out.println("4. EXIT");

            int choix = getChoix(scanner,1,4);

            if (choix == 1) {
                quartiers = "Montreal";
                projet.ajoutQuartiers(quartiers);
                System.out.println("Vous avez ajouté : "+ quartiers);
            } else if (choix == 2) {
                quartiers = "Longueuil";
                projet.ajoutQuartiers(quartiers);
                System.out.println("Vous avez ajouté : "+ quartiers);
            } else if (choix == 3) {
                quartiers = "Laval";
                projet.ajoutQuartiers(quartiers);
                System.out.println("Vous avez ajouté : "+ quartiers);
            } else if (choix == 4){
                System.out.println("Les quartiers choisis sont : \n" + projet.listeQuartiers());
                break;
            }else {
                System.out.println("\n Veuillez choisir l'une des options citées plus haut.");
            }

        }   // quartiers

        while (true) {
            System.out.println("* Veuillez choisir les numéros des rues affectées parmis ceux ci-dessous " +
                    "(Le Numéro EXIT pour finir la selection de vos choix) \n");
            System.out.println("1. Rue1");
            System.out.println("2. Rue2");
            System.out.println("3. EXIT");

            int choix = getChoix(scanner,1,3);

            if (choix == 1) {
                rues = "Rue1";
                projet.ajoutRues(rues);
                System.out.println("Vous avez ajouté : "+ rues);
            } else if (choix == 2) {
                rues = "Rue2";
                projet.ajoutRues(rues);
                System.out.println("Vous avez ajouté : "+ rues);
            } else if (choix == 3) {
                System.out.println("Les rues choisies sont : \n" + projet.listeRues());
                break;
            } else {
                System.out.println("Veuillez choisir l'une des options citées précédemment.");
            }
        }   // rues

        while (true) {
            try {
                System.out.println("* Veuillez saisir un jour pour les travaux (Saisissez EXIT lorsque vous aurez fini) : ");
                jours = scanner.nextLine();
                if (!jours.trim().isEmpty() && !jours.equalsIgnoreCase("exit") && !jours.matches("\\d+")) {
                    projet.ajoutJours(jours);
                    System.out.println("Inscription réussie.");
                } else if (jours.equalsIgnoreCase("exit")) {
                    System.out.println("Inscription reussie. L'horaires des travaux est : \n" + projet.afficherHoraire());
                    break;
                } else {
                    System.out.println("Cette case est obligatoire. Le titre ne peut pas être vide.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Veuillez entrez une jour de la semaine valide");
            }

        }

        System.out.println("Inscription réussie. \n");
        repertoire.ajouterProjet(projet);
        System.out.println(projet);
    }

    public static void consultationRequetes(Scanner scanner) {}

    public static void majInfo(Scanner scanner, Intervenant intervenant) {
        int idx = 0;
        String choice;

        List<Projet> rep = repertoire.projetCree(intervenant);

        if (!rep.isEmpty()){
            System.out.println("Vos projets sont : \n");
            for(Projet projet : rep) {
                idx ++;
                System.out.println(idx + "\n" + projet);
            }
            System.out.println("\n Veuillez choisir le numéro du projet à modifier.");

            int choix1 = getChoix(scanner,0,idx);
            choix1 --;
            Projet projetNum = rep.get(choix1);

            if (choix1 == 0) {
                System.out.println("Choix Incorrect.");
            }

            while (true) {
                System.out.println("* Veuillez choisir l'une des options ci-dessous " +
                        "(Choisissez EXIT pour finir la selection de vos choix): \n");
                System.out.println("1. Mettre à jour la description du projet");
                System.out.println("2. Mettre à jour la date de fin prévue");
                System.out.println("3. Changer le statut du projet");
                System.out.println("4. EXIT");

                int choix = getChoix(scanner,1,4);

                if (choix == 1) {
                    System.out.println("Veuillez saisir la nouvelle description du projet : \n");
                    choice = scanner.nextLine();
                    projetNum.modificationDescriptif(choice);
                    repertoire.majProjet(projetNum);
                } else if (choix == 2) {
                    while (true) {
                        try {
                            System.out.println("Veuillez entrez une nouvelle date de fin pour les travaux (format yyyy/mm/dd) :");

                            choice = scanner.nextLine();
                            LocalDate dateFin = LocalDate.parse(choice,formatter);

                            if (!choice.trim().isEmpty()) {
                                projetNum.modifierDateFin(dateFin);
                                repertoire.majProjet(projetNum);
                                break;

                            } else {
                                System.out.println("Cette case est obligatoire. Veuillez entrez une date de debut.");
                            }
                        } catch (DateTimeParseException e){
                            System.out.println("Format de date incorrect. Veuillez utiliser le format yyyy/MM/dd.");
                        }
                    }
                } else if (choix == 3) {
                    while (true) {
                        System.out.println("* Veuillez choisir un statut pour votre chantier: \n");
                        System.out.println("1. En cours");
                        System.out.println("2. Suspendu");
                        System.out.println("3. Terminé");

                        int choix2 = getChoix(scanner,1,3);

                        if (choix2 == 1) {
                            projetNum.modifierStatut("En cours");
                            repertoire.majProjet(projetNum);
                            break;
                        } else if (choix2 == 2) {
                            projetNum.modifierStatut("Suspendu");
                            repertoire.majProjet(projetNum);
                            break;
                        } else if (choix2 == 3) {
                            projetNum.modifierStatut("Terminé");
                            repertoire.majProjet(projetNum);
                            break;
                        } else {
                            System.out.println("Veuillez choisir l'une des options citées précédemment.");
                        }
                    }
                } else if (choix == 4){
                    System.out.println("Modifications enregistrées. Affichage du projet modifié ci-dessous: \n"
                            + projetNum);
                    break;
                }else {
                    System.out.println("\n Veuillez choisir l'une des options citées plus haut.");
                }
            }

        } else {
            System.out.println("Vous n'avez pas de projets");
        }
    }

}
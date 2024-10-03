import java.time.LocalDate;
import java.util.*;

public class Projet {
    private String titre;
    private String description;
    private String type;
    private List<String> quartiers;
    private List<String> rues;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Date horaireDebut;
    private Date horaireFin;
    private String statut;
    private Intervenant intervenant;
    private List<Integer> jours;

    public Projet (String title, String description, String type, LocalDate dateDebut, LocalDate dateFin,
                   Date horairesDebut, Date horaireFin, Intervenant intervenant) {
        this.titre = title;
        this.description = description;
        this.type = type;
        this.statut = "Prevue";

        this.quartiers = new ArrayList<>();
        this.rues = new ArrayList<>();
        this.jours = new ArrayList<>();

        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.horaireDebut = horairesDebut;
        this.horaireFin = horaireFin;


        this.intervenant = intervenant;
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public String getTitre() {
        return titre;
    }

    public void ajoutRues(String street) {
        this.rues.add(street);
    }

    public String listeRues() {
        return this.rues.toString();
    }

    public void ajoutQuartiers(String quartier) {
        this.quartiers.add(quartier);
    }

    public String listeQuartiers() {
        return this.quartiers.toString();
    }

    public void modificationDescriptif(String descriptif) {
        this.description = descriptif;
    }

    public void ajoutJours(String jour) {

        if(jour.equalsIgnoreCase("dimanche")) {
            this.jours.add(Calendar.SUNDAY);
        } else if (jour.equalsIgnoreCase("lundi")) {
            this.jours.add(Calendar.MONDAY);
        } else if (jour.equalsIgnoreCase("mardi")) {
            this.jours.add(Calendar.TUESDAY);
        }else if (jour.equalsIgnoreCase("mercredi")){
            this.jours.add(Calendar.WEDNESDAY);
        }else if (jour.equalsIgnoreCase("jeudi")){
            this.jours.add(Calendar.THURSDAY);
        }else if (jour.equalsIgnoreCase("vendredi")){
            this.jours.add(Calendar.FRIDAY);
        }else if (jour.equalsIgnoreCase("samedi")){
            this.jours.add(Calendar.SATURDAY);
        }else {
            System.out.println("Jour invalide : " + jour);
        }
    }

    public StringBuilder afficherHoraire() {
        Calendar calendar = Calendar.getInstance();
        StringBuilder affichage = new StringBuilder();

        for (int day : this.jours){
            calendar.set(Calendar.DAY_OF_WEEK, day);

            String jour = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.FRENCH);
            String horaire = jour + " de "+ horaireDebut.getHours()+ ":"+ horaireDebut.getMinutes() + " à "+ horaireFin.getHours()+ ":"+ horaireFin.getMinutes() + "\n";
            affichage.append(horaire);
        }

        return affichage;
    }

    public void modifierDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void modifierStatut(String update) {
        this.statut = update;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Information du Projet :\n");
        sb.append(" Titre : ").append(titre).append("\n");
        sb.append(" Projet soumis par : ").append(intervenant.getNom()).append("\n");
        sb.append(" Type de travaux : ").append(type).append("\n");
        sb.append(" Rues affectées : \n").append(listeRues()).append("\n");
        sb.append(" Quartiers affectés : \n").append(listeQuartiers()).append("\n");
        sb.append(" Date de debut des travaux: ").append(dateDebut).append("\n");
        sb.append(" Date de fin prévu des travaux: ").append(dateFin).append("\n");
        sb.append(" Horaire : \n").append(afficherHoraire()).append("\n");
        sb.append(" Description générale du travail: \n").append(description).append("\n");
        sb.append(" Statue: ").append(statut).append("\n");

        return sb.toString();
    }
}

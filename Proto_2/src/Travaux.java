import java.time.LocalDate;

public class Travaux {

    private String title;
    private String description;
    private String type;
    private String localisation;
    private LocalDate dateDebut;
    private String statut;
    public Resident resident;

    public Travaux (Resident resident,String title, String description, String type, LocalDate dateDebut) {
        this.resident = resident;
        this.title = title;
        this.description = description;
        this.type = type;
        this.statut = "En Attente";
        this.localisation = resident.getAdresse();
        this.dateDebut = dateDebut;
    }

    public void modifierStatue(String statue){
        this.statut = statue;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Requête de travail :\n");
        sb.append(" Titre : ").append(title).append("\n");
        sb.append(" Type de travaux : ").append(type).append("\n");
        sb.append(" Requête déposée par : ").append(resident.getPrenom()).append(" ").append(resident.getNom()).append("\n");
        sb.append(" Emplacement : ").append(localisation).append("\n");
        sb.append(" Date de debut des travaux: ").append(dateDebut).append("\n");
        sb.append(" Description détaillée : \n").append(description).append("\n");
        sb.append(" Statue : ").append(statut).append("\n");

        return sb.toString();
    }
}

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Travaux {
    private String titre;
    private String type;
    private String localisation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;
    private String statue;

    public Travaux (String title,String localisation,String dateDebut,String dateFin) {
        this.titre = title;
        this.localisation = localisation;
        this.statue = "Prevue";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.dateDebut = LocalDate.parse(dateDebut,formatter);
        this.dateFin = LocalDate.parse(dateFin, formatter);
    }

    public String getTitre(){
        return this.titre;
    }

    public void modificationDescriptif(String descriptif) {
        this.titre = descriptif;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Information :\n");
        sb.append(" Titre : ").append(titre).append("\n");
        sb.append(" Type de travaux : ").append(type).append("\n");
        sb.append(" Emplacement : ").append(localisation).append("\n");
        sb.append(" Date de debut des travaux: ").append(dateDebut).append("\n");
        sb.append(" Date de fin prévu des travaux: ").append(dateFin).append("\n");
        sb.append(" Description générale du travail: \n").append(description).append("\n");
        sb.append(" Statue: ").append(statue).append("\n");

        return sb.toString();
    }
}

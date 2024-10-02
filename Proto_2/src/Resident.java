import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Resident {

    private String prenom;
    private String nom;
    private String password;
    private String number;
    private String email;
    private String adresse;
    private LocalDate birthdate;

    public Resident(String prenom,String nom, String email,String age,String password,String adresse, String numero) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.adresse = adresse;
        this.number = numero;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.birthdate = LocalDate.parse(age,formatter);
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getNumber() {
        return number;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Profil :\n");
        sb.append(" Nom : ").append(nom).append("  ").append(prenom).append("\n");
        sb.append(" Date de naissance : ").append(birthdate).append("\n");
        sb.append(" Email : ").append(email).append("\n");
        sb.append(" Numero de Telephone: ").append(number).append("\n");
        sb.append(" Adresse: ").append(adresse).append("\n");

        return sb.toString();
    }
}

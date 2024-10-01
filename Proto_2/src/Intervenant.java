public class Intervenant {

    private String nom;
    private String email;
    private String password;
    private String Type;
    private String identifiant;

    public Intervenant(String nom, String email, String password, String type, String identifiant){
        this.nom = nom;
        this.password = password;
        this.email = email;
        this.identifiant = identifiant;
        this.Type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Profil :\n");
        sb.append(" Nom: ").append(nom).append("\n");
        sb.append(" Email: ").append(email).append("\n");
        sb.append(" Type: ").append(Type).append("\n");
        sb.append(" Identifiant: ").append(identifiant).append("\n");

        return sb.toString();
    }
}

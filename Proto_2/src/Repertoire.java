import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


public class Repertoire {

    private List<Travaux> travauxEnCours;
    private Map<String,Travaux> repertoireTravaux;

    public Repertoire() {
        this.travauxEnCours = new ArrayList<>();
        this.repertoireTravaux = new HashMap<>();
    }

    public void ajouterUnTravail(Travaux travaux) {
        travauxEnCours.add(travaux);
        repertoireTravaux.put(travaux.getTitre(),travaux);
    }

    public Travaux rechercherTravaux(String descriptif){
        return repertoireTravaux.get(descriptif);
    }

    public void afficherTravaux() {
        for (Travaux chantier : travauxEnCours) {
            System.out.println(chantier);
        }
    }
}

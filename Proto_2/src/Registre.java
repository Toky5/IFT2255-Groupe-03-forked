import java.util.ArrayList;
import java.util.List;

public class Registre {

    private List<Resident> residentsInscrits;
    private List<Intervenant> intervenantsInscrits;

    public Registre() {
        this.residentsInscrits = new ArrayList<>();
        this.intervenantsInscrits = new ArrayList<>();
    }

    public List<Intervenant> getIntervenantsInscrits() {
        return intervenantsInscrits;
    }

    public List<Resident> getResidentsInscrits() {
        return residentsInscrits;
    }

    public Resident connexionResident(String email, String password) {
        Resident inscrit = null;

        for (Resident resident : residentsInscrits) {
            if (resident.getPassword().equals(password) && resident.getEmail().equals(email)){
                System.out.println("Résident trouvé");
                inscrit = resident;
                break;

            }else {
                System.out.println("Ce résident n'est pas inscrit. Veuillez réesayer");
            }
        }
        return inscrit;
    }

    public Intervenant connexionIntervenant(String email, String password) {
        Intervenant inscrits = null;

        for (Intervenant intervenant : intervenantsInscrits) {
            if (intervenant.getPassword().equals(password) && intervenant.getEmail().equals(email)){
                System.out.println("Résident trouvé");
                inscrits = intervenant;
                break;

            }else {
                System.out.println("Ce résident n'est pas inscrit. Veuillez réesayer");
            }
        }
        return inscrits;
    }

    public void inscriptionResident(Resident resident) {
        residentsInscrits.add(resident);
    }

    public void inscriptionIntervenant(Intervenant intervenant){
        intervenantsInscrits.add(intervenant);
    }
}

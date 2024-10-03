import java.util.List;
import java.util.ArrayList;

public class Repertoire {

    private List<Travaux> requetes;
    private List<Projet> projets;

    public Repertoire() {
        this.requetes = new ArrayList<>();
        this.projets = new ArrayList<>();
    }

    public void ajouterRequete(Travaux requetes) {
        this.requetes.add(requetes);
    }

    public void ajouterProjet(Projet projet){
        this.projets.add(projet);
    }

    public List<Projet> projetCree(Intervenant intervenant) {
        List<Projet> projetsCree = new ArrayList<>();

        for (Projet projet: projets) {
            if (intervenant.equals(projet.getIntervenant())) {
                projetsCree.add(projet);
            }
        }

        return projetsCree;
    }

    public void majProjet(Projet project) {
        for (Projet projet: projets) {
            if (project.getTitre().equals(projet.getTitre())) {
                int idx = projets.indexOf(projet);
                projets.add(idx,project);
                projets.remove(projet);

            }
        }
    }

    public void afficherTravaux() {
        for (Travaux chantier : requetes) {
            System.out.println(chantier);
        }
    }

    public void afficherProjets() {
        for (Projet chantier : projets) {
            System.out.println(chantier);
        }
    }
}

package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Etudiant {

    @Id
    @Column(name = "NUMETU")
    private String numEtu;

    private String prenom;

    private String nom;

    @ManyToMany
    private Set<Groupe> groupes;

    @ManyToMany(mappedBy = "etudiants")
    private Set<Formation> formations;

    public String getNumEtu() {
        return numEtu;
    }

    public void setNumEtu(String numEtu) {
        this.numEtu = numEtu;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Set<Groupe> groupes) {
        this.groupes = groupes;
    }

    public Set<Formation> getFormations() {
        return formations;
    }

    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }
}

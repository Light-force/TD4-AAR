package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Formation {

    @Id
    @Column(name = "IDFORM")
    private String idForm;

    private String intituleForm;

    @ManyToMany
    @JoinTable(name = "INSCRITS", joinColumns = {@JoinColumn(name = "IDFORM")}, inverseJoinColumns = {@JoinColumn(name = "NUMETU")})
    private Set<Etudiant> etudiants;

    @ManyToMany
    private Set<Groupe> groupes;

    @ManyToMany
    private Set<Salle> salles;

    public String getIdForm() {
        return idForm;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public String getIntituleForm() {
        return intituleForm;
    }

    public void setIntituleForm(String intituleForm) {
        this.intituleForm = intituleForm;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Set<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Set<Groupe> groupes) {
        this.groupes = groupes;
    }

    public Set<Salle> getSalles() {
        return salles;
    }

    public void setSalles(Set<Salle> salles) {
        this.salles = salles;
    }
}

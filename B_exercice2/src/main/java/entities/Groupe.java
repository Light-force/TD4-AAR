package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Groupe {

    @Id
    @GeneratedValue
    @Column(name = "IDGROUPE")
    private int idGroupe;

    private String intitule;

    @OneToMany
    private List<Creneau> creneaux;

    @ManyToMany
    @JoinTable(name = "MEMBRES", joinColumns = {@JoinColumn(name = "IDGROUPE")}, inverseJoinColumns = {@JoinColumn(name = "NUMETU")})
    private Set<Etudiant> etudiants;

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public List<Creneau> getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(List<Creneau> creneaux) {
        this.creneaux = creneaux;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}

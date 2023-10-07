package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Groupe {

    @Id
    @GeneratedValue
    private int idGroupe;

    private String intitule;

    @OneToMany
    private List<Creneau> creneaux;

    @ManyToMany
    private Set<Etudiant> etudiants;
}

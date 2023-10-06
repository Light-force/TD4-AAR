package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Formation {

    @Id
    private String idForm;

    private String intituleForm;

    @ManyToMany
    private Set<Etudiant> etudiants;

    @ManyToMany
    private Set<Groupe> groupes;

    @ManyToMany
    private Set<Salle> salles;
}

package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Etudiant {

    @Id
    private String numEtu;

    private String prenom;

    private String nom;

    @ManyToMany
    private Set<Groupe> groupes;

    @ManyToMany
    private Set<Formation> formations;
}

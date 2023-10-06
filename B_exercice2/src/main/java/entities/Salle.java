package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
public class Salle {

    @Id
    private String numSalle;

    private int capacite;

    @OneToMany
    private List<Creneau> creneaux;

    @ManyToMany
    private Set<Formation> formations;
}

package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Groupe {

    @Id
    @GeneratedValue
    private int idGroupe;

    private String intitule;

    @OneToMany
    private List<Creneau> creneaux;
}

package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Batiment {

    @Id
    @GeneratedValue
    private int idBatiment;

    private String nomBatiment;

    @ManyToOne
    private UFR ufr;

    @OneToMany
    private List<Salle> salles;
}

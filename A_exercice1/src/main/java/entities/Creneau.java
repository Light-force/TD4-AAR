package entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Creneau {

    @Id
    @GeneratedValue
    private int Creaneau;

    private LocalDateTime debut;

    private LocalDateTime fin;

    @OneToOne
    private Salle salle;

    @OneToOne
    private Groupe groupe;

    @ManyToMany
    private Set<Etudiant> etudiants;
}

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

    public int getCreaneau() {
        return Creaneau;
    }

    public void setCreaneau(int creaneau) {
        Creaneau = creaneau;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}

package entities;

import javax.persistence.*;
import java.util.List;

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

    public int getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(int idBatiment) {
        this.idBatiment = idBatiment;
    }

    public String getNomBatiment() {
        return nomBatiment;
    }

    public void setNomBatiment(String nomBatiment) {
        this.nomBatiment = nomBatiment;
    }

    public UFR getUfr() {
        return ufr;
    }

    public void setUfr(UFR ufr) {
        this.ufr = ufr;
    }

    public List<Salle> getSalles() {
        return salles;
    }

    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }
}

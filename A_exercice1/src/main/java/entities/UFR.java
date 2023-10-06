package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UFR {

    @Id
    @GeneratedValue
    private int idUFR;

    private String sigleUFR;

    @OneToMany(mappedBy = "ufr")
    private List<Batiment> batiments = new ArrayList<>();
}

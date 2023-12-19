package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Functie")
public class Functie {
    @Id
    @GeneratedValue
    private int FunctieId;

    private String FunctieType;

    @ManyToMany (mappedBy = "WerknemerFunctie")
    private List<Werknemer> werknemers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Afdeling_Id")
    private Afdeling Afdeling;

    public Functie()
    {

    }

    public Functie(int functieId, String functieType) {
        FunctieId = functieId;
        FunctieType = functieType;
    }

    public int getFunctieId() {
        return FunctieId;
    }

    public void setFunctieId(int functieId) {
        FunctieId = functieId;
    }

    public String getFunctieType() {
        return FunctieType;
    }

    public void setFunctieType(String functieType) {
        FunctieType = functieType;
    }

    public Afdeling getAfdeling() {
        return Afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        Afdeling = afdeling;
    }

    public List<Werknemer> getWerknemers() {
        return werknemers;
    }

    public void setWerknemers(Werknemer werknemers) {
        this.werknemers.add(werknemers);
    }
}

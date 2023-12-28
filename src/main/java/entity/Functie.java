package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Functie")
public class Functie {
    @Id
    @GeneratedValue
    @Column
    private int FunctieId;

    @Column
    private String FunctieType;



    @ManyToOne
    @JoinColumn(name = "Afdeling_Id")
    private Afdeling Afdeling;

    @ManyToMany (mappedBy = "functies")
    private Set<Werknemer> werknemers = new HashSet<>();

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

    public Set<Werknemer> getWerknemers() {
        return werknemers;
    }

    public void setWerknemers(Werknemer werknemer) {
        this.werknemers.add(werknemer);
    }


}

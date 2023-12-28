package entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "Afdeling")
public class Afdeling {

    @Id
    @GeneratedValue
    @Column
    private int AfdelingId;

    @Column
    private String AfdelingNaam;


    @OneToMany (mappedBy = "Afdeling")
    private Set<Functie> functies = new HashSet<>();
    public Afdeling()
    {

    }

    public Afdeling(int afdelingId, String afdelingNaam) {
        AfdelingId = afdelingId;
        AfdelingNaam = afdelingNaam;
    }

    public int getAfdelingId() {
        return AfdelingId;
    }

    public void setAfdelingId(int afdelingId) {
        AfdelingId = afdelingId;
    }

    public String getAfdelingNaam() {
        return AfdelingNaam;
    }

    public void setAfdelingNaam(String afdelingNaam) {
        AfdelingNaam = afdelingNaam;
    }

    public Set<Functie> getFuncties() {
        return functies;
    }

    public void setFuncties(Functie functie) {
        this.functies.add(functie);
    }



}

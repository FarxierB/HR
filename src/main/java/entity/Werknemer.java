package entity;

import Observer.WerknemerSubject;
import Observer.WerknemerObserver;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Werknemer")
public class Werknemer {

    @Id
    @Column
    private String IdNummer;

    @Column
    private String VoorNamen;

    @Column
    private String AchterNaam;

    @Column
    private LocalDate GeboorteDatum;

    @Column
    private String GeboortePlaats;



    @ManyToMany
    @JoinTable(name = "Werknemer_Functie", joinColumns = {@JoinColumn(name = "Werknemer_ID", referencedColumnName = "IdNummer")}, inverseJoinColumns = {@JoinColumn(name = "Functie_ID", referencedColumnName = "FunctieId")})
    private Set<Functie> functies = new HashSet<>();





    public Werknemer() {

    }

    public Werknemer(String idNummer, String voorNamen, String achterNaam, LocalDate geboorteDatum, String geboortePlaats) {
        IdNummer = idNummer;
        VoorNamen = voorNamen;
        AchterNaam = achterNaam;
        GeboorteDatum = geboorteDatum;
        GeboortePlaats = geboortePlaats;
    }


    @Transient
    private WerknemerSubject werknemerSubject = new WerknemerSubject();




    public void updateWerknemer() {
        werknemerSubject.notifyObservers(this);
    }

    public void addObserver(WerknemerObserver observer) {
        werknemerSubject.addObserver(observer);
    }

    public void removeObserver(WerknemerObserver observer) {
        werknemerSubject.removeObserver(observer);
    }

    public String getIdNummer() {
        return IdNummer;
    }

    public void setIdNummer(String idNummer) {
        IdNummer = idNummer;
    }

    public String getVoorNamen() {
        return VoorNamen;
    }

    public void setVoorNamen(String voorNamen) {
        VoorNamen = voorNamen;
    }

    public String getAchterNaam() {
        return AchterNaam;
    }

    public void setAchterNaam(String achterNaam) {
        AchterNaam = achterNaam;
    }

    public LocalDate getGeboorteDatum() {
        return GeboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        GeboorteDatum = geboorteDatum;
    }

    public String getGeboortePlaats() {
        return GeboortePlaats;
    }

    public void setGeboortePlaats(String geboortePlaats) {
        GeboortePlaats = geboortePlaats;
    }



    public Set<Functie> getFuncties() {return functies;}


    public void setFuncties(Functie functie) {this.functies.add(functie);
    }
}


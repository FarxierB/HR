package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Werknemer")
public class Werknemer {

    @Id
    private String IdNummer;

    private String VoorNamen;

    private String AchterNaam;

    private LocalDate GeboorteDatum;

    private String GeboortePlaats;



    @ManyToMany
    @JoinTable(name = "Werknemer_Functie", joinColumns = {@JoinColumn(name = "Werknemer_ID")}, inverseJoinColumns = {@JoinColumn(name = "Functie_ID")})
    private List<Functie> WerknemerFunctie = new ArrayList<>();





    public Werknemer() {

    }

    public Werknemer(String idNummer, String voorNamen, String achterNaam, LocalDate geboorteDatum, String geboortePlaats) {
        IdNummer = idNummer;
        VoorNamen = voorNamen;
        AchterNaam = achterNaam;
        GeboorteDatum = geboorteDatum;
        GeboortePlaats = geboortePlaats;
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



    public List<Functie> getWerknemerFunctie() {
        return WerknemerFunctie;
    }

    public void setWerknemerFunctie(Functie werknemerFunctie) {
        this.WerknemerFunctie.add(werknemerFunctie);
    }


}


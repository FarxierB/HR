package Observer;

import entity.Werknemer;

public class ObserverChange implements WerknemerObserver{

    @Override
    public void onWerknemerChange(Werknemer werknemer) {

        //System.out.println("Werknemer was added with ID: " + werknemer.getIdNummer());
        System.out.println("Werknemer was added with:\n" +
                "ID: " + werknemer.getIdNummer() + "\n" +
                "VoorNamen: " + werknemer.getVoorNamen() + "\n" +
                "AchterNaam: " + werknemer.getAchterNaam() + "\n" +
                "GeboorteDatum: " + werknemer.getGeboorteDatum() + "\n" +
                "GeboortePlaats: " + werknemer.getGeboortePlaats());
    }
}

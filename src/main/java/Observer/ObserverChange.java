package Observer;

import entity.Werknemer;

public class ObserverChange implements WerknemerObserver{

    @Override
    public void onWerknemerChange(Werknemer werknemer) {

        System.out.println("Werknemer was added with ID: " + werknemer.getIdNummer());
    }
}

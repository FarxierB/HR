package Observer;

import entity.Werknemer;

import java.util.HashSet;
import java.util.Set;

public class WerknemerSubject {
    private Set<WerknemerObserver> observers = new HashSet<>();

    public void addObserver(WerknemerObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WerknemerObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Werknemer werknemer) {
        for (WerknemerObserver observer : observers) {
            observer.onWerknemerChange(werknemer);
        }
    }
}

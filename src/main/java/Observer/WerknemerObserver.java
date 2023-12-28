package Observer;

import entity.Werknemer;

public interface WerknemerObserver {
    void onWerknemerChange (Werknemer werknemer);
}

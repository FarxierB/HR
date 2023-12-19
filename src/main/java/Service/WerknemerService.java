package Service;

import configuration.JPAConfig;
import entity.Werknemer;
import repository.WerknemerRepo;

import java.util.List;

public class WerknemerService {

    private final WerknemerRepo repository;

    public WerknemerService() {
        this.repository = new WerknemerRepo(JPAConfig.getEntityManager());
    }

    public List<Werknemer> getWerknemers() {
        return repository.getWerknemers();
    }

    public Werknemer getWerknemer(Werknemer werknemer){return repository.getWerknemer(werknemer);}

    public Werknemer createWerknemer(Werknemer werknemer) {
        return repository.createWerknemer(werknemer);
    }

    public Werknemer updateWerknemer(Werknemer werknemer) { return repository.updateWerknemer(werknemer);}

    public Werknemer deleteWerknemer(Werknemer werknemer) { return repository.deleteWerknemer(werknemer);}
}

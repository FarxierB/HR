package Service;

import configuration.JPAConfig;
import entity.Afdeling;
import repository.AfdelingRepo;

public class AfdelingService {

    private final AfdelingRepo repository;

    public AfdelingService() {
        this.repository = new AfdelingRepo(JPAConfig.getEntityManager());
    }

    public Afdeling createAfdeling(Afdeling afdeling) {return repository.createAfdeling(afdeling);}

    public  Afdeling updateAfdeling(Afdeling afdeling) { return repository.updateAfdeling(afdeling);}

    public Afdeling deleteAfdeling(Afdeling afdeling) { return repository.deleteAfdeling(afdeling);}
}

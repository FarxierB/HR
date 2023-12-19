package Service;

import configuration.JPAConfig;
import entity.Functie;
import repository.FunctieRepo;

public class FunctieService {

    private final FunctieRepo repository;

    public FunctieService() {
        this.repository = new FunctieRepo(JPAConfig.getEntityManager());
    }

    public Functie createFunctie(Functie functie) {
        return repository.createFunctie(functie);
    }

    public Functie updateFunctie(Functie functie) { return repository.updateFunctie(functie);}

    public Functie deleteFunctie(Functie functie) { return repository.deleteFunctie(functie);}
}

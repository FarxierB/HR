package repository;

import entity.Functie;
import jakarta.persistence.EntityManager;

public class FunctieRepo {

    private EntityManager em;

    public FunctieRepo(EntityManager entityManager) {
        this.em = entityManager;
    }

    public Functie createFunctie(Functie functie) {
        try {
            em.getTransaction().begin();
            em.persist(functie);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return functie;
    }



    public Functie deleteFunctie(Functie functie){
        try{
            em.getTransaction().begin();
            em.find(Functie.class, functie.getFunctieId());
            if(functie != null)  em.remove(functie);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return functie;
    }


    public Functie updateFunctie(Functie functie){
        try{
            em.getTransaction().begin();
            em.find(Functie.class, functie.getFunctieId());
            em.merge(functie);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return functie;
    }
}

package repository;

import entity.Afdeling;
import entity.Werknemer;
import jakarta.persistence.EntityManager;

public class AfdelingRepo {
    private EntityManager em;

    public AfdelingRepo(EntityManager entityManager) {this.em = entityManager;}

    public Afdeling createAfdeling(Afdeling afdeling) {
        try {
            em.getTransaction().begin();
            em.persist(afdeling);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        return afdeling;
    }

    public Afdeling deleteAfdeling(Afdeling afdeling){
        try{
            em.getTransaction().begin();
            em.find(Afdeling.class, afdeling.getAfdelingId());
            if(afdeling != null)  em.remove(afdeling);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return afdeling;
    }

    public Afdeling updateAfdeling(Afdeling afdeling){
        try{
            em.getTransaction().begin();
            em.find(Afdeling.class, afdeling.getAfdelingId());
            em.merge(afdeling);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return afdeling;
    }
}

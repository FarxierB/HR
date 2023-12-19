package repository;

import entity.WerknemerDetail;
import jakarta.persistence.EntityManager;

public class DetailRepo {
    private EntityManager em;

    public DetailRepo(EntityManager entityManager) {
        this.em = entityManager;
    }

    public WerknemerDetail createWerknemerDetail(WerknemerDetail werknemerDetail) {
        try {
            em.getTransaction().begin();
            em.persist(werknemerDetail);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return werknemerDetail;
    }



    public WerknemerDetail deleteWerknemerDetail(WerknemerDetail werknemerDetail){
        try{
            em.getTransaction().begin();
            em.find(WerknemerDetail.class, werknemerDetail.getDetailId());
            if(werknemerDetail != null)  em.remove(werknemerDetail);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return werknemerDetail;
    }


    public WerknemerDetail updateWerknemerDetail(WerknemerDetail werknemerDetail){
        try{
            em.getTransaction().begin();
            em.find(WerknemerDetail.class, werknemerDetail.getDetailId());
            em.merge(werknemerDetail);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return werknemerDetail;
    }
}

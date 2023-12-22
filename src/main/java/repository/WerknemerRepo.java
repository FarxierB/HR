package repository;

import entity.Afdeling;
import entity.Werknemer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class WerknemerRepo {

    private EntityManager em;


    public WerknemerRepo(EntityManager entityManager) {
        this.em = entityManager;
    }

    public List<Werknemer> getWerknemers() {
        String query = "select g from Werknemer g";
        TypedQuery<Werknemer> typedQuery = em.createQuery(query, Werknemer.class);
        List<Werknemer> dienstList = typedQuery.getResultList();
        return dienstList;
    }


    public Werknemer getWerknemer(Werknemer werknemer){
        String query = "Select w from Werknemer w where w.id = :werknemer_id";
        TypedQuery<Werknemer> typedQuery = em.createQuery(query, Werknemer.class);
        typedQuery.setParameter("werknemer_id", werknemer.getIdNummer());
        System.out.println("Werknemer ID: " + werknemer.getIdNummer() + "\nVoornamen: " + werknemer.getVoorNamen() +"\nAchternaam: " + werknemer.getAchterNaam() + "\nGeboorteDatum: " + werknemer.getGeboorteDatum() + "\nGeboortePlaats: " + werknemer.getGeboortePlaats());
        return typedQuery.getSingleResult();
    }


    public Werknemer getWerknemer(String werknemerId){
        String query = "Select w from Werknemer w where w.id = :werknemer_id";
        TypedQuery<Werknemer> typedQuery = em.createQuery(query, Werknemer.class);
        typedQuery.setParameter("werknemer_id", werknemerId);
        return typedQuery.getSingleResult();
    }



    public Werknemer createWerknemer(Werknemer werknemer){
        try {
            em.getTransaction().begin();
            em.persist(werknemer);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        return werknemer;
    }



    public Werknemer deleteWerknemer(Werknemer werknemer){
        try{
            em.getTransaction().begin();
            em.find(Werknemer.class, werknemer.getIdNummer());
            if(werknemer != null)  em.remove(werknemer);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return werknemer;
    }
    /*public Werknemer deleteWerknemer(String idNummer) {
        Werknemer werknemer = null;
        try {
            em.getTransaction().begin();
            werknemer = em.find(Werknemer.class, idNummer);
            if (werknemer != null) {
                em.remove(werknemer);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return werknemer;
    }*/


    /*public Werknemer updateWerknemer(Werknemer werknemer){
        try{
            em.getTransaction().begin();
            em.find(Werknemer.class, werknemer.getIdNummer());
            em.merge(werknemer);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return werknemer;
    }*/
    public Werknemer updateWerknemer(Werknemer updatedWerknemer) {
        try {
            em.getTransaction().begin();
            Werknemer existingWerknemer = em.find(Werknemer.class, updatedWerknemer.getIdNummer());
            if (existingWerknemer != null) {

                existingWerknemer.setVoorNamen(updatedWerknemer.getVoorNamen());
                existingWerknemer.setAchterNaam(updatedWerknemer.getAchterNaam());
                existingWerknemer.setGeboorteDatum(updatedWerknemer.getGeboorteDatum());
                existingWerknemer.setGeboortePlaats(updatedWerknemer.getGeboortePlaats());


                em.merge(existingWerknemer);
            }
            em.getTransaction().commit();
            return existingWerknemer;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        }
    }

    public long getTotalWerknemersCount() {
        String query = "select count(w) from Werknemer w";
        TypedQuery<Long> typedQuery = em.createQuery(query, Long.class);
        return typedQuery.getSingleResult();
    }

    public long getWerknemersCountByFunctie(String functieName) {
        String query = "select count(w) from Werknemer w join w.WerknemerFunctie f where f.FunctieType = :functieName";
        Query typedQuery = em.createQuery(query);
        typedQuery.setParameter("functieName", functieName);
        return (long) typedQuery.getSingleResult();
    }


}

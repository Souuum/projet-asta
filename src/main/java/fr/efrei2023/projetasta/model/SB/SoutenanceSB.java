package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.SoutenanceEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class SoutenanceSB extends BaseSB<SoutenanceEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public SoutenanceEntity getSoutenanceById(int id) {
        Query query = em.createQuery("SELECT s FROM SoutenanceEntity s WHERE s.idSoutenance = :id");
        query.setParameter("id", id);
        return (SoutenanceEntity) query.getSingleResult();
    }

    @Override
    public List<SoutenanceEntity> getAll() {
        Query query = em.createQuery("SELECT s FROM SoutenanceEntity s");
        return (List<SoutenanceEntity>) query.getResultList();
    }

    @Override
    public SoutenanceEntity getById(int id) {
        Query query = em.createQuery("SELECT s FROM SoutenanceEntity s WHERE s.idSoutenance = :id");
        query.setParameter("id", id);
        return (SoutenanceEntity) query.getSingleResult();
    }

    @Override
    public void add(SoutenanceEntity soutenanceEntity) {

    }

    @Override
    public void update(SoutenanceEntity soutenanceEntity) {

    }

    @Override
    public void delete(SoutenanceEntity soutenanceEntity) {

    }
}

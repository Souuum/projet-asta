package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.SoutenanceEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static fr.efrei2023.projetasta.utils.SoutenanceConstants.*;

@Stateless
public class SoutenanceSB extends BaseSB<SoutenanceEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();
    @Override
    public List<SoutenanceEntity> getAll() {
        Query query = em.createQuery(SELECT_ALL_SOUTENANCES);
        return (List<SoutenanceEntity>) query.getResultList();
    }

    @Override
    public SoutenanceEntity getById(int id) {
        Query query = em.createQuery(SELECT_SOUTENANCE_BY_ID);
        query.setParameter("id", id);
        return (SoutenanceEntity) query.getSingleResult();
    }

    public SoutenanceEntity getByEvaluationEcoleId(int id) {
        Query query = em.createQuery(SELECT_SOUTENANCE_BY_EVALUATION_ECOLE_ID);
        query.setParameter("id", id);
        if(query.getResultList().isEmpty())
            return null;
        return (SoutenanceEntity) query.getSingleResult();
    }

    @Override
    public void add(SoutenanceEntity soutenanceEntity) {
        soutenanceEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        soutenanceEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        em.getTransaction().begin();
        em.persist(soutenanceEntity);
        em.getTransaction().commit();
    }

    @Override
    public void update(SoutenanceEntity soutenanceEntity) {
        SoutenanceEntity s = em.find(SoutenanceEntity.class, soutenanceEntity.getIdSoutenance());
        if(s == null){
            throw new EntityNotFoundException(ENTITY_ERROR_MESSAGE);
        }
        em.getTransaction().begin();
        s.setDateSoutenance(soutenanceEntity.getDateSoutenance());
        s.setEvaluationEcole(soutenanceEntity.getEvaluationEcole());
        Date date = new Date(System.currentTimeMillis());
        Timestamp ts = new Timestamp(date.getTime());
        s.setUpdatedAt(ts);
        em.getTransaction().commit();
    }

    @Override
    public void delete(SoutenanceEntity soutenanceEntity) {
        em.getTransaction().begin();
        em.remove(soutenanceEntity);
        em.getTransaction().commit();
    }
}

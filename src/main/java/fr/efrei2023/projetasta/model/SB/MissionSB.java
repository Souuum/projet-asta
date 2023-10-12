package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.MissionEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class MissionSB extends BaseSB<MissionEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public MissionEntity getMissionById(int id) {
        Query query = em.createQuery("SELECT m FROM MissionEntity m WHERE m.idMission = :id");
        query.setParameter("id", id);
        return (MissionEntity) query.getSingleResult();
    }

    @Override
    public List<MissionEntity> getAll() {
        Query query = em.createQuery("SELECT m FROM MissionEntity m");
        return (List<MissionEntity>) query.getResultList();
    }

    @Override
    public MissionEntity getById(int id) {
        Query query = em.createQuery("SELECT m FROM MissionEntity m WHERE m.idMission = :id");
        query.setParameter("id", id);
        return (MissionEntity) query.getSingleResult();
    }

    @Override
    public void add(MissionEntity missionEntity) {

    }

    @Override
    public void update(MissionEntity missionEntity) {

    }

    @Override
    public void delete(MissionEntity missionEntity) {

    }
}

package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.MaitreApprentissageEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class MaitreApprentissageSB extends BaseSB<MaitreApprentissageEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();


    @Override
    public List<MaitreApprentissageEntity> getAll() {
        Query query = em.createQuery("SELECT m FROM MaitreApprentissageEntity m");
        return (List<MaitreApprentissageEntity>) query.getResultList();
    }

    @Override
    public MaitreApprentissageEntity getById(int id) {
        Query query = em.createQuery("SELECT m FROM MaitreApprentissageEntity m WHERE m.idMaitreApprentissage = :id");
        query.setParameter("id", id);
        return (MaitreApprentissageEntity) query.getSingleResult();
    }

    @Override
    public void add(MaitreApprentissageEntity maitreApprentissageEntity) {

    }

    @Override
    public void update(MaitreApprentissageEntity maitreApprentissageEntity) {

    }

    @Override
    public void delete(MaitreApprentissageEntity maitreApprentissageEntity) {

    }
}

package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.MemoireEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateless

public class MemoireSB extends BaseSB<MemoireEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public MemoireEntity getMemoireById(int id) {
        Query query = em.createQuery("SELECT m FROM MemoireEntity m WHERE m.idMemoire = :id");
        query.setParameter("id", id);
        return (MemoireEntity) query.getSingleResult();
    }

    @Override
    public List<MemoireEntity> getAll() {
        Query query = em.createQuery("SELECT m FROM MemoireEntity m");
        return (List<MemoireEntity>) query.getResultList();
    }

    @Override
    public MemoireEntity getById(int id) {
        Query query = em.createQuery("SELECT m FROM MemoireEntity m WHERE m.idMemoire = :id");
        query.setParameter("id", id);
        return (MemoireEntity) query.getSingleResult();
    }

    @Override
    public void add(MemoireEntity memoireEntity) {

    }

    @Override
    public void update(MemoireEntity memoireEntity) {

    }

    @Override
    public void delete(MemoireEntity memoireEntity) {

    }
}

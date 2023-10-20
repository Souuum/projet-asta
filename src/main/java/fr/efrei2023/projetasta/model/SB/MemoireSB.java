package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.MemoireEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static fr.efrei2023.projetasta.utils.MemoireConstants.*;

@Stateless

public class MemoireSB extends BaseSB<MemoireEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();


    @Override
    public List<MemoireEntity> getAll() {
        Query query = em.createQuery(SELECT_ALL_MEMOIRES);
        return (List<MemoireEntity>) query.getResultList();
    }

    @Override
    public MemoireEntity getById(int id) {
        Query query = em.createQuery(SELECT_MEMOIRE_BY_ID);
        query.setParameter("id", id);
        return (MemoireEntity) query.getSingleResult();
    }

    @Override
    public void add(MemoireEntity memoireEntity) {
        memoireEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        memoireEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        em.getTransaction().begin();
        em.persist(memoireEntity);
        em.getTransaction().commit();
    }

    @Override
    public void update(MemoireEntity memoireEntity) {
        MemoireEntity m = em.find(MemoireEntity.class, memoireEntity.getIdMemoire());
        if(m == null){
            throw new EntityNotFoundException(ENTITY_ERROR_MESSAGE);
        }
        em.getTransaction().begin();
        m.setTheme(memoireEntity.getTheme());
        m.setEvaluationEcole(memoireEntity.getEvaluationEcole());
        Date date = new Date(System.currentTimeMillis());
        Timestamp ts = new Timestamp(date.getTime());
        m.setUpdatedAt(ts);
        em.getTransaction().commit();
    }

    @Override
    public void delete(MemoireEntity memoireEntity) {
        em.getTransaction().begin();
        em.remove(memoireEntity);
        em.getTransaction().commit();
    }
}

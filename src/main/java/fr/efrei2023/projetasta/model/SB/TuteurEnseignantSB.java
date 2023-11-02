package fr.efrei2023.projetasta.model.SB;

import fr.efrei2023.projetasta.model.Entity.TuteurEnseignantEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.*;

@Stateless
public class TuteurEnseignantSB extends BaseSB<TuteurEnseignantEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    public List<TuteurEnseignantEntity> getAll() {
        Query query = em.createQuery(SELECT_ALL_TUTEURS);
        return (List<TuteurEnseignantEntity>) query.getResultList();
    }

    @Override
    public TuteurEnseignantEntity getById(int id) {
        Query query = em.createQuery(SELECT_TUTEUR_BY_ID);
        query.setParameter("id", id);
        return (TuteurEnseignantEntity) query.getSingleResult();
    }

    public TuteurEnseignantEntity getByUserId(int id){
        System.out.println("USER ID: " + id);
        Query query = em.createQuery(FIND_TUTEUR_BY_USER_ID);
        query.setParameter("id", id);
        return (TuteurEnseignantEntity) query.getSingleResult();
    }

    @Override
    public void add(TuteurEnseignantEntity tuteurEnseignantEntity) {
        tuteurEnseignantEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        tuteurEnseignantEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        em.getTransaction().begin();
        em.persist(tuteurEnseignantEntity);
        em.getTransaction().commit();
    }

    @Override
    public void update(TuteurEnseignantEntity tuteurEnseignantEntity) {

    }

    @Override
    public void delete(TuteurEnseignantEntity tuteurEnseignantEntity) {
        em.getTransaction().begin();
        em.remove(tuteurEnseignantEntity);
        em.getTransaction().commit();
    }
}

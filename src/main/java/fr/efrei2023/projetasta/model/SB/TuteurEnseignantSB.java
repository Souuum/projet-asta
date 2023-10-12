package fr.efrei2023.projetasta.model.SB;

import fr.efrei2023.projetasta.model.Entity.TuteurEnseignantEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class TuteurEnseignantSB extends BaseSB<TuteurEnseignantEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public TuteurEnseignantEntity getTuteurById(int id) {
        Query query = em.createQuery("SELECT t FROM TuteurEnseignantEntity t WHERE t.idTuteurEnseignant = :id");
        query.setParameter("id", id);
        return (TuteurEnseignantEntity) query.getSingleResult();
    }

    @Override
    public List<TuteurEnseignantEntity> getAll() {
        Query query = em.createQuery("SELECT t FROM TuteurEnseignantEntity t");
        return (List<TuteurEnseignantEntity>) query.getResultList();
    }

    @Override
    public TuteurEnseignantEntity getById(int id) {
        Query query = em.createQuery("SELECT t FROM TuteurEnseignantEntity t WHERE t.idTuteurEnseignant = :id");
        query.setParameter("id", id);
        return (TuteurEnseignantEntity) query.getSingleResult();
    }

    @Override
    public void add(TuteurEnseignantEntity tuteurEnseignantEntity) {

    }

    @Override
    public void update(TuteurEnseignantEntity tuteurEnseignantEntity) {

    }

    @Override
    public void delete(TuteurEnseignantEntity tuteurEnseignantEntity) {

    }
}

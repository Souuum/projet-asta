package fr.efrei2023.projetasta.model.SB;

import fr.efrei2023.projetasta.model.Entity.TuteurEnseignantEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
@Stateless
public class TuteurEnseignantSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public TuteurEnseignantEntity getTuteurById(int id) {
        Query query = em.createQuery("SELECT t FROM TuteurEnseignantEntity t WHERE t.idTuteurEnseignant = :id");
        query.setParameter("id", id);
        return (TuteurEnseignantEntity) query.getSingleResult();
    }
}

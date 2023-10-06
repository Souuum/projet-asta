package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.EvaluationEcoleEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
@Stateless
public class EvaluationEcoleSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public EvaluationEcoleEntity getEvaluationEcoleById(int id) {
        Query query = em.createQuery("SELECT e FROM EvaluationEcoleEntity e WHERE e.idEvaluationEcole = :id");
        query.setParameter("id", id);
        return (EvaluationEcoleEntity) query.getSingleResult();
    }
}

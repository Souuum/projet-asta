package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.EvaluationEcoleEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class EvaluationEcoleSB extends BaseSB<EvaluationEcoleEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    public List<EvaluationEcoleEntity> getAll() {
        Query query = em.createQuery("SELECT e FROM EvaluationEcoleEntity e");
        return (List<EvaluationEcoleEntity>) query.getResultList();
    }

    @Override
    public EvaluationEcoleEntity getById(int id) {
        Query query = em.createQuery("SELECT e FROM EvaluationEcoleEntity e WHERE e.idEvaluationEcole = :id");
        query.setParameter("id", id);
        return (EvaluationEcoleEntity) query.getSingleResult();
    }

    @Override
    public void add(EvaluationEcoleEntity evaluationEcoleEntity) {

    }

    @Override
    public void update(EvaluationEcoleEntity evaluationEcoleEntity) {

    }

    @Override
    public void delete(EvaluationEcoleEntity evaluationEcoleEntity) {

    }
}

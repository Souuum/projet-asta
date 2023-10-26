package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.EvaluationEcoleEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static fr.efrei2023.projetasta.utils.EvaluationEcoleConstants.*;

@Stateless
public class EvaluationEcoleSB extends BaseSB<EvaluationEcoleEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    public List<EvaluationEcoleEntity> getAll() {
        Query query = em.createQuery(SELECT_ALL_EVALUATIONECOLES);
        return (List<EvaluationEcoleEntity>) query.getResultList();
    }

    @Override
    public EvaluationEcoleEntity getById(int id) {
        Query query = em.createQuery(SELECT_EVALUATIONECOLE_BY_ID);
        query.setParameter("id", id);
        return (EvaluationEcoleEntity) query.getSingleResult();
    }

    @Override
    public void add(EvaluationEcoleEntity evaluationEcoleEntity) {
        evaluationEcoleEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        evaluationEcoleEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        em.getTransaction().begin();
        em.persist(evaluationEcoleEntity);
        em.getTransaction().commit();
    }

    @Override
    public void update(EvaluationEcoleEntity evaluationEcoleEntity) {
        EvaluationEcoleEntity e = em.find(EvaluationEcoleEntity.class, evaluationEcoleEntity.getIdEvaluationEcole());
        if(e == null){
            throw new EntityNotFoundException(ENTITY_ERROR_MESSAGE);
        }
        em.getTransaction().begin();
        e.setCommentaires(evaluationEcoleEntity.getCommentaires());
        e.setNoteFinale(evaluationEcoleEntity.getNoteFinale());
        Date date = new Date(System.currentTimeMillis());
        Timestamp ts = new Timestamp(date.getTime());
        e.setUpdatedAt(ts);
        em.getTransaction().commit();
    }

    @Override
        public void delete(EvaluationEcoleEntity evaluationEcoleEntity) {
        em.getTransaction().begin();
        em.remove(evaluationEcoleEntity);
        em.getTransaction().commit();
    }
}

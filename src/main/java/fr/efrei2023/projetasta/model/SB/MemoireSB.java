package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.MemoireEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
@Stateless

public class MemoireSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public MemoireEntity getMemoireById(int id) {
        Query query = em.createQuery("SELECT m FROM MemoireEntity m WHERE m.idMemoire = :id");
        query.setParameter("id", id);
        return (MemoireEntity) query.getSingleResult();
    }
}

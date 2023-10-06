package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.ApprentiEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
@Stateless
public class ApprentiSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public ApprentiEntity getApprentiById(int id) {
        Query query = em.createQuery("SELECT a FROM ApprentiEntity a WHERE a.numeroEtudiant = :id");
        query.setParameter("id", id);
        return (ApprentiEntity) query.getSingleResult();
    }
}

package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.MaitreApprentissageEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
@Stateless
public class MaitreApprentissageSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public MaitreApprentissageEntity getMaitreApprentissageById(int id) {
        Query query = em.createQuery("SELECT m FROM MaitreApprentissageEntity m WHERE m.idMaitreApprentissage = :id");
        query.setParameter("id", id);
        return (MaitreApprentissageEntity) query.getSingleResult();
    }
}

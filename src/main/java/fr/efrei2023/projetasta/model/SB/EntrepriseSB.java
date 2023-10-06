package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.EntrepriseEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
@Stateless
public class EntrepriseSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public EntrepriseEntity getEntrepriseById(int id) {
        Query query = em.createQuery("SELECT e FROM EntrepriseEntity e WHERE e.idEntreprise = :id");
        query.setParameter("id", id);
        return (EntrepriseEntity) query.getSingleResult();
    }
}

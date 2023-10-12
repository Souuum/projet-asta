package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.EntrepriseEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class EntrepriseSB extends BaseSB<EntrepriseEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    public List<EntrepriseEntity> getAll() {
        Query query = em.createQuery("SELECT e FROM EntrepriseEntity e");
        return (List<EntrepriseEntity>) query.getResultList();
    }

    @Override
    public EntrepriseEntity getById(int id) {
        Query query = em.createQuery("SELECT e FROM EntrepriseEntity e WHERE e.idEntreprise = :id");
        query.setParameter("id", id);
        return (EntrepriseEntity) query.getSingleResult();
    }

    @Override
    public void add(EntrepriseEntity entrepriseEntity) {

    }

    @Override
    public void update(EntrepriseEntity entrepriseEntity) {

    }

    @Override
    public void delete(EntrepriseEntity entrepriseEntity) {

    }
}

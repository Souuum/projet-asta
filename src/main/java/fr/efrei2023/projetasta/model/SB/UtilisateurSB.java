package fr.efrei2023.projetasta.model.SB;

import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Stateless
public class UtilisateurSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public UtilisateurEntity getUtilisateurById(int id) {
        Query query = em.createQuery("SELECT u FROM UtilisateurEntity u WHERE u.idUtilisateur = :id");
        query.setParameter("id", id);
        return (UtilisateurEntity) query.getSingleResult();
    }
}

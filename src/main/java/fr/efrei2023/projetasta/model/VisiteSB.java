package fr.efrei2023.projetasta.model;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Stateless
public class VisiteSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();


    public VisiteEntity getVisiteById(int id) {
        Query query = em.createQuery("SELECT v FROM VisiteEntity v WHERE v.idVisite = :id");
        query.setParameter("id", id);
        return (VisiteEntity) query.getSingleResult();
    }
}

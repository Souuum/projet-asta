package fr.efrei2023.projetasta.model.SB;

import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Stateless
public class UtilisateurSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public UtilisateurEntity getUtilisateurById(int id) {
        Query query = em.createQuery("SELECT u FROM UtilisateurEntity u WHERE u.idUtilisateur = :id");
        query.setParameter("id", id);
        return (UtilisateurEntity) query.getSingleResult();
    }

    @Transactional
    public void createUtilisateur(UtilisateurEntity utilisateur) {
        em.getTransaction().begin();
        em.persist(utilisateur);
        em.getTransaction().commit();
    }

    public void createUtilisateur(String nom, String prenom, String email, String motDePasse, Byte isAdmin){
        UtilisateurEntity utilisateur = new UtilisateurEntity();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setPassword(motDePasse);
        utilisateur.setIsadmin(isAdmin);
        createUtilisateur(utilisateur);
    }

}

package fr.efrei2023.projetasta.model.SB;

import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;

import static fr.efrei2023.projetasta.utils.UtilisateurConstants.ENTITY_ERROR_MESSAGE;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.SELECT_UTILISATEUR_BY_ID;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.SELECT_UTILISATEUR_BY_EMAIL;

@Stateless
public class UtilisateurSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public UtilisateurEntity getUtilisateurById(int id) {
        Query query = em.createQuery(SELECT_UTILISATEUR_BY_ID);
        query.setParameter("id", id);
        return (UtilisateurEntity) query.getSingleResult();
    }

    public UtilisateurEntity getUtilisateurByEmail(String email) {
        Query query = em.createQuery(SELECT_UTILISATEUR_BY_EMAIL);
        query.setParameter("email", email);
        return (UtilisateurEntity) query.getSingleResult();
    }

    @Transactional
    public void createUtilisateur(UtilisateurEntity utilisateur) {
        em.getTransaction().begin();
        em.persist(utilisateur);
        em.getTransaction().commit();
    }

    @Transactional
    public void createUtilisateur(String nom, String prenom, String email, String motDePasse, Byte isAdmin){
        UtilisateurEntity utilisateur = new UtilisateurEntity();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setPassword(motDePasse);
        utilisateur.setIsadmin(isAdmin);
        createUtilisateur(utilisateur);
    }

    @Transactional
    public void updateUtilisateur(int id, UtilisateurEntity utilisateur){
        UtilisateurEntity u = getUtilisateurById(id);

        if(u == null){
            throw new EntityNotFoundException(ENTITY_ERROR_MESSAGE);
        }
        em.getTransaction().begin();
        u.setNom(utilisateur.getNom());
        u.setPrenom(utilisateur.getPrenom());
        u.setEmail(utilisateur.getEmail());
        u.setPassword(utilisateur.getPassword());
        u.setIsadmin(utilisateur.getIsadmin());
        em.getTransaction().commit();
    }

}

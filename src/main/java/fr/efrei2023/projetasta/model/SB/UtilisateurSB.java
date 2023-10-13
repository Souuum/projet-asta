package fr.efrei2023.projetasta.model.SB;

import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;

import java.util.List;

import static fr.efrei2023.projetasta.utils.UtilisateurConstants.ENTITY_ERROR_MESSAGE;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.SELECT_UTILISATEUR_BY_ID;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.SELECT_UTILISATEUR_BY_EMAIL;

@Stateless
public class UtilisateurSB extends BaseSB<UtilisateurEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public UtilisateurEntity getById(int id) {
        Query query = em.createQuery(SELECT_UTILISATEUR_BY_ID);
        query.setParameter("id", id);
        return (UtilisateurEntity) query.getSingleResult();
    }

    public UtilisateurEntity getUtilisateurByEmail(String email) {
        try{
            Query query = em.createQuery(SELECT_UTILISATEUR_BY_EMAIL);
            query.setParameter("email", email);
            return (UtilisateurEntity) query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    public List<UtilisateurEntity> getAll(){
        Query query = em.createQuery("SELECT u FROM UtilisateurEntity u");
        return (List<UtilisateurEntity>) query.getResultList();
    }

    public void delete(UtilisateurEntity utilisateur) {

        em.getTransaction().begin();
        em.remove(utilisateur);
        em.getTransaction().commit();
    }

    @Transactional
    public void add(UtilisateurEntity utilisateur) {
        em.getTransaction().begin();
        em.persist(utilisateur);
        em.getTransaction().commit();
    }

    @Transactional
    public void add(String nom, String prenom, String email, String motDePasse, boolean isAdmin){
        UtilisateurEntity utilisateur = new UtilisateurEntity();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setPassword(motDePasse);
        utilisateur.setIsadmin(isAdmin);
        add(utilisateur);
    }

    @Transactional
    public void update(UtilisateurEntity utilisateur){
        UtilisateurEntity u = em.find(UtilisateurEntity.class, utilisateur.getIdUtilisateur());
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

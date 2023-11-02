package fr.efrei2023.projetasta.model.SB;

import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;

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

    public List<UtilisateurEntity> getAllFromTuteur(int id) {
        Query query = em.createQuery(FIND_ALL_UTILISATEURS_FROM_TUTEUR);
        return (List<UtilisateurEntity>) query.getResultList();
    }

    public void delete(UtilisateurEntity utilisateur) {

        em.getTransaction().begin();
        em.remove(utilisateur);
        em.getTransaction().commit();
    }

    @Transactional
    public void add(UtilisateurEntity utilisateur) {
        Date date = new Date(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(date.getTime());
        utilisateur.setCreatedAt(timestamp);
        utilisateur.setUpdatedAt(timestamp);
        em.getTransaction().begin();
        em.persist(utilisateur);
        em.getTransaction().commit();
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
        u.setTelephone(utilisateur.getTelephone());
        Date date = new Date(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(date.getTime());
        u.setUpdatedAt(timestamp);
        em.getTransaction().commit();
    }

}

package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.ApprentiEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import static fr.efrei2023.projetasta.utils.ApprentiConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.ENTITY_ERROR_MESSAGE;

@Stateless
public class ApprentiSB extends BaseSB<ApprentiEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public ApprentiEntity getApprentiById(String id) {
        Query query = em.createQuery(FIND_APPRENTI_BY_NUMERO_ETUDIANT);
        query.setParameter("id", id);
        return (ApprentiEntity) query.getSingleResult();
    }

    @Transactional


    @Override
    public List<ApprentiEntity> getAll() {
        Query query = em.createQuery("SELECT a FROM ApprentiEntity a");
        return (List<ApprentiEntity>) query.getResultList();
    }

    public List<ApprentiEntity> getAllFromTuteur(int id) {
        Query query = em.createQuery(FIND_ALL_APPRENTIS_FROM_TUTEUR);
        query.setParameter("id", id);
        return (List<ApprentiEntity>) query.getResultList();
    }

    @Override
    public ApprentiEntity getById(int id) {

        return null;
    }
    public ApprentiEntity getById(String id){
        Query query = em.createQuery(FIND_APPRENTI_BY_NUMERO_ETUDIANT);
        query.setParameter("id", id);
        return (ApprentiEntity) query.getSingleResult();
    }

    public ApprentiEntity getByUserId(int id){
        Query query = em.createQuery(FIND_APPRENTI_BY_USER_ID);
        query.setParameter("id", id);
        return (ApprentiEntity) query.getSingleResult();
    }

    @Transactional
    public void add(ApprentiEntity apprenti){
        Date date = new Date(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(date.getTime());
        apprenti.setCreatedAt(timestamp);
        apprenti.setUpdatedAt(timestamp);
        em.getTransaction().begin();
        em.persist(apprenti);
        em.getTransaction().commit();
    }

    @Transactional
    public void update(ApprentiEntity apprenti){
        ApprentiEntity a = em.find(ApprentiEntity.class, apprenti.getNumeroEtudiant());
        if(a == null){
            throw new EntityNotFoundException(ENTITY_ERROR_MESSAGE);
        }
        em.getTransaction().begin();
        a.setProgramme(apprenti.getProgramme());
        a.setAnneeAcademique(apprenti.getAnneeAcademique());
        a.setMajeure(apprenti.getMajeure());
        a.setFeedback(apprenti.getFeedback());
        a.setIdUtilisateur(apprenti.getIdUtilisateur());
        a.setIsArchived(apprenti.getIsArchived());
        Date date = new Date(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(date.getTime());
        a.setUpdatedAt(timestamp);
        em.getTransaction().commit();

    }

    public void delete(ApprentiEntity apprenti){
        em.getTransaction().begin();
        em.remove(apprenti);
        em.getTransaction().commit();
    }


    @Transactional
    public void archiveApprenti(String id) {
        ApprentiEntity a = getApprentiById(id);
        em.getTransaction().begin();
        a.setIsArchived(true);
        em.getTransaction().commit();
    }

    @Transactional
    public void unarchivedApprenti(String id) {
        ApprentiEntity a = getApprentiById(id);
        em.getTransaction().begin();
        a.setIsArchived(false);
        em.getTransaction().commit();
    }

}
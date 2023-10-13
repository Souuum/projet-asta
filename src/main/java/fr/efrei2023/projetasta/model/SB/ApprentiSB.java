package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.ApprentiEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Stateless
public class ApprentiSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    public ApprentiEntity getApprentiById(int id) {
        Query query = em.createQuery("SELECT a FROM ApprentiEntity a WHERE a.numeroEtudiant = :id");
        query.setParameter("id", id);
        return (ApprentiEntity) query.getSingleResult();
    }

    @Transactional

    public void createApprenti(ApprentiEntity apprenti) {
        em.getTransaction().begin();
        em.persist(apprenti);
        em.getTransaction().commit();
    }

    @Transactional
    public void updateApprenti(int id, ApprentiEntity apprenti){
        ApprentiEntity a = getApprentiById(id);

        if(a == null){
            throw new EntityNotFoundException("Apprenti can't be found");
        }
        em.getTransaction().begin();
        a.setNumeroEtudiant(apprenti.getNumeroEtudiant());
        a.setProgramme(apprenti.getProgramme());
        a.setAnneeAcademique(apprenti.getAnneeAcademique());
        a.setMajeure(apprenti.getMajeure());
        a.setFeedback(apprenti.getFeedback());
        a.setIdUtilisateur(apprenti.getIdUtilisateur());
        a.setIsArchived(apprenti.getIsArchived());
        em.getTransaction().commit();
    }

    @Transactional
    public void archiveApprenti(int id) {
        ApprentiEntity a = getApprentiById(id);
        em.getTransaction().begin();
        a.setIsArchived((byte) 1);
        em.getTransaction().commit();
    }

    @Transactional
    public void unarchivedApprenti(int id) {
        ApprentiEntity a = getApprentiById(id);
        em.getTransaction().begin();
        a.setIsArchived((byte) 0);
        em.getTransaction().commit();
    }

}
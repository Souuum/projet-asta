package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.EntrepriseEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static fr.efrei2023.projetasta.utils.EntrepriseConstants.*;

@Stateless
public class EntrepriseSB extends BaseSB<EntrepriseEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    public List<EntrepriseEntity> getAll() {
        Query query = em.createQuery(SELECT_ALL_ENTREPRISES);
        return (List<EntrepriseEntity>) query.getResultList();
    }

    @Override
    public EntrepriseEntity getById(int id) {
        Query query = em.createQuery(SELECT_ENTREPRISE_BY_ID);
        query.setParameter("id", id);
        return (EntrepriseEntity) query.getSingleResult();
    }

    public EntrepriseEntity getByRaisonSociale(String raisonSociale) {
        Query query = em.createQuery(SELECT_ENTREPRISE_BY_RAISON_SOCIALE);
        query.setParameter("raisonSociale", raisonSociale);
        if(query.getResultList().isEmpty()){
            return null;
        }
        return (EntrepriseEntity) query.getSingleResult();
    }

    @Override
    public void add(EntrepriseEntity entrepriseEntity) {
        entrepriseEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        entrepriseEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        em.getTransaction().begin();
        em.persist(entrepriseEntity);
        em.getTransaction().commit();
    }

    @Override
    public void update(EntrepriseEntity entrepriseEntity) {
        EntrepriseEntity e = em.find(EntrepriseEntity.class, entrepriseEntity.getIdEntreprise());
        if(e == null){
            throw new EntityNotFoundException(ENTITY_ERROR_MESSAGE);
        }
        em.getTransaction().begin();
        e.setAdresse(entrepriseEntity.getAdresse());
        e.setInformations(entrepriseEntity.getInformations());
        e.setRaisonSociale(entrepriseEntity.getRaisonSociale());
        Date date = new Date(System.currentTimeMillis());
        Timestamp ts = new Timestamp(date.getTime());
        e.setUpdatedAt(ts);
        em.getTransaction().commit();
    }

    @Override
    public void delete(EntrepriseEntity entrepriseEntity) {
        em.getTransaction().begin();
        em.remove(entrepriseEntity);
        em.getTransaction().commit();
    }


}

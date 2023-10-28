package fr.efrei2023.projetasta.model.SB;

import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import fr.efrei2023.projetasta.model.Entity.VisiteEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static fr.efrei2023.projetasta.utils.VisiteConstants.*;

@Stateless
public class VisiteSB extends BaseSB<VisiteEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();


    @Override
    public List<VisiteEntity> getAll() {
        Query query = em.createQuery(SELECT_ALL_VISITES);
        return (List<VisiteEntity>) query.getResultList();
    }

    @Override
    public VisiteEntity getById(int id) {
        Query query = em.createQuery(SELECT_VISITE_BY_ID);
        query.setParameter("id", id);
        return (VisiteEntity) query.getSingleResult();
    }

    @Override
    public void add(VisiteEntity visiteEntity) {
        visiteEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        visiteEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        em.getTransaction().begin();
        em.persist(visiteEntity);
        em.getTransaction().commit();
    }

    @Override
    public void update(VisiteEntity visite) {
        VisiteEntity v = em.find(VisiteEntity.class, visite.getIdVisite());
        if(v == null){
            throw new EntityNotFoundException(ENTITY_ERROR_MESSAGE);
        }
        em.getTransaction().begin();
        v.setDateVisite(visite.getDateVisite());
        v.setFormat(visite.getFormat());
        v.setCompteRenduExpress(visite.getCompteRenduExpress());
        Date date = new Date(System.currentTimeMillis());
        Timestamp ts = new Timestamp(date.getTime());
        v.setUpdatedAt(ts);
        em.getTransaction().commit();
    }

    @Override
    public void delete(VisiteEntity visiteEntity) {
        em.getTransaction().begin();
        em.remove(visiteEntity);
        em.getTransaction().commit();
    }
}

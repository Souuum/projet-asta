package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.MaitreApprentissageEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static fr.efrei2023.projetasta.utils.MaitreApprentissageConstants.*;

@Stateless
public class MaitreApprentissageSB extends BaseSB<MaitreApprentissageEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();


    @Override
    public List<MaitreApprentissageEntity> getAll() {
        Query query = em.createQuery(SELECT_ALL_MAITREAPPRENTISSAGES);
        return (List<MaitreApprentissageEntity>) query.getResultList();
    }

    @Override
    public MaitreApprentissageEntity getById(int id) {
        Query query = em.createQuery(SELECT_MAITREAPPRENTISSAGE_BY_ID);
        query.setParameter("id", id);
        return (MaitreApprentissageEntity) query.getSingleResult();
    }

    @Override
    public void add(MaitreApprentissageEntity maitreApprentissageEntity) {
        maitreApprentissageEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        maitreApprentissageEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        em.getTransaction().begin();
        em.persist(maitreApprentissageEntity);
        em.getTransaction().commit();
    }

    @Override
    public void update(MaitreApprentissageEntity maitreApprentissageEntity) {
        MaitreApprentissageEntity m = em.find(MaitreApprentissageEntity.class, maitreApprentissageEntity.getIdMaitreApprentissage());
        if(m == null){
            throw new EntityNotFoundException(ENTITY_ERROR_MESSAGE);
        }
        em.getTransaction().begin();
        m.setNom(maitreApprentissageEntity.getNom());
        m.setPrenom(maitreApprentissageEntity.getPrenom());
        m.setAdresseElectronique(maitreApprentissageEntity.getAdresseElectronique());
        m.setEntreprise(maitreApprentissageEntity.getEntreprise());
        m.setTelephone(maitreApprentissageEntity.getTelephone());
        Date date = new Date(System.currentTimeMillis());
        Timestamp ts = new Timestamp(date.getTime());
        m.setUpdatedAt(ts);
        em.getTransaction().commit();
    }

    @Override
    public void delete(MaitreApprentissageEntity maitreApprentissageEntity) {
        em.getTransaction().begin();
        em.remove(maitreApprentissageEntity);
        em.getTransaction().commit();
    }
}

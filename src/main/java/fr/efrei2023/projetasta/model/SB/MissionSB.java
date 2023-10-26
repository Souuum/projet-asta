package fr.efrei2023.projetasta.model.SB;
import fr.efrei2023.projetasta.model.Entity.MissionEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static fr.efrei2023.projetasta.utils.MissionConstants.*;

@Stateless
public class MissionSB extends BaseSB<MissionEntity>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-asta");
    EntityManager em = entityManagerFactory.createEntityManager();


    @Override
    public List<MissionEntity> getAll() {
        Query query = em.createQuery(SELECT_ALL_MISSIONS);
        return (List<MissionEntity>) query.getResultList();
    }

    @Override
    public MissionEntity getById(int id) {
        Query query = em.createQuery(SELECT_MISSION_BY_ID);
        query.setParameter("id", id);
        return (MissionEntity) query.getSingleResult();
    }

    @Override
    public void add(MissionEntity missionEntity) {
        missionEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        missionEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        em.getTransaction().begin();
        em.persist(missionEntity);
        em.getTransaction().commit();
    }

    @Override
    public void update(MissionEntity missionEntity) {
        MissionEntity m = em.find(MissionEntity.class, missionEntity.getIdMission());
        if(m == null){
            throw new EntityNotFoundException(ENTITY_ERROR_MESSAGE);
        }
        em.getTransaction().begin();
        m.setCommentaires(missionEntity.getCommentaires());
        m.setMetierCible(missionEntity.getMetierCible());
        m.setMotsCles(missionEntity.getMotsCles());
        Date date = new Date(System.currentTimeMillis());
        Timestamp ts = new Timestamp(date.getTime());
        m.setUpdatedAt(ts);
        em.getTransaction().commit();
    }

    @Override
    public void delete(MissionEntity missionEntity) {
        em.getTransaction().begin();
        em.remove(missionEntity);
        em.getTransaction().commit();
    }
}

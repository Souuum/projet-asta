package fr.efrei2023.projetasta.model.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "mission", schema = "projet-asta", catalog = "")
public class MissionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_mission", nullable = false)
    private int idMission;
    @Basic
    @Column(name = "mots_cles", nullable = true, length = 50)
    private String motsCles;
    @Basic
    @Column(name = "metier_cible", nullable = true, length = 50)
    private String metierCible;
    @Basic
    @Column(name = "commentaires", nullable = true, length = 50)
    private String commentaires;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    public int getIdMission() {
        return idMission;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public String getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }

    public String getMetierCible() {
        return metierCible;
    }

    public void setMetierCible(String metierCible) {
        this.metierCible = metierCible;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissionEntity that = (MissionEntity) o;

        if (idMission != that.idMission) return false;
        if (motsCles != null ? !motsCles.equals(that.motsCles) : that.motsCles != null) return false;
        if (metierCible != null ? !metierCible.equals(that.metierCible) : that.metierCible != null) return false;
        if (commentaires != null ? !commentaires.equals(that.commentaires) : that.commentaires != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMission;
        result = 31 * result + (motsCles != null ? motsCles.hashCode() : 0);
        result = 31 * result + (metierCible != null ? metierCible.hashCode() : 0);
        result = 31 * result + (commentaires != null ? commentaires.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}

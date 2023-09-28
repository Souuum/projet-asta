package fr.efrei2023.projetasta.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "soutenance", schema = "projet-asta", catalog = "")
public class SoutenanceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_soutenance", nullable = false)
    private int idSoutenance;
    @Basic
    @Column(name = "date_soutenance", nullable = true)
    private Date dateSoutenance;
    @Basic
    @Column(name = "id_evaluation_ecole", nullable = false)
    private int idEvaluationEcole;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    public int getIdSoutenance() {
        return idSoutenance;
    }

    public void setIdSoutenance(int idSoutenance) {
        this.idSoutenance = idSoutenance;
    }

    public Date getDateSoutenance() {
        return dateSoutenance;
    }

    public void setDateSoutenance(Date dateSoutenance) {
        this.dateSoutenance = dateSoutenance;
    }

    public int getIdEvaluationEcole() {
        return idEvaluationEcole;
    }

    public void setIdEvaluationEcole(int idEvaluationEcole) {
        this.idEvaluationEcole = idEvaluationEcole;
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

        SoutenanceEntity that = (SoutenanceEntity) o;

        if (idSoutenance != that.idSoutenance) return false;
        if (idEvaluationEcole != that.idEvaluationEcole) return false;
        if (dateSoutenance != null ? !dateSoutenance.equals(that.dateSoutenance) : that.dateSoutenance != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSoutenance;
        result = 31 * result + (dateSoutenance != null ? dateSoutenance.hashCode() : 0);
        result = 31 * result + idEvaluationEcole;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}

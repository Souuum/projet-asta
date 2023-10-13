package fr.efrei2023.projetasta.model.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "memoire", schema = "`projet-asta`", catalog = "")
public class MemoireEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_memoire", nullable = false)
    private int idMemoire;
    @Basic
    @Column(name = "theme", nullable = true, length = 50)
    private String theme;
    @OneToOne
    @JoinColumn(name = "id_evaluation_ecole", referencedColumnName = "id_evaluation_ecole", nullable = false)
    private EvaluationEcoleEntity evaluationEcole;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    public int getIdMemoire() {
        return idMemoire;
    }

    public void setIdMemoire(int idMemoire) {
        this.idMemoire = idMemoire;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public EvaluationEcoleEntity getEvaluationEcole() {
        return evaluationEcole;
    }
    public void setEvaluationEcole(EvaluationEcoleEntity evaluationEcole) {
        this.evaluationEcole = evaluationEcole;
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

        MemoireEntity that = (MemoireEntity) o;

        if (idMemoire != that.idMemoire) return false;
        if (theme != null ? !theme.equals(that.theme) : that.theme != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMemoire;
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}

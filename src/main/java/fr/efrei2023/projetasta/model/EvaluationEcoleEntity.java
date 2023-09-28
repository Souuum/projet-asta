package fr.efrei2023.projetasta.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "evaluation_ecole", schema = "projet-asta", catalog = "")
public class EvaluationEcoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_evaluation_ecole", nullable = false)
    private int idEvaluationEcole;
    @Basic
    @Column(name = "note_finale", nullable = true, length = 50)
    private String noteFinale;
    @Basic
    @Column(name = "commentaires", nullable = true, length = 50)
    private String commentaires;
    @Basic
    @Column(name = "numero_etudiant", nullable = false, length = 50)
    private String numeroEtudiant;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    public int getIdEvaluationEcole() {
        return idEvaluationEcole;
    }

    public void setIdEvaluationEcole(int idEvaluationEcole) {
        this.idEvaluationEcole = idEvaluationEcole;
    }

    public String getNoteFinale() {
        return noteFinale;
    }

    public void setNoteFinale(String noteFinale) {
        this.noteFinale = noteFinale;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
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

        EvaluationEcoleEntity that = (EvaluationEcoleEntity) o;

        if (idEvaluationEcole != that.idEvaluationEcole) return false;
        if (noteFinale != null ? !noteFinale.equals(that.noteFinale) : that.noteFinale != null) return false;
        if (commentaires != null ? !commentaires.equals(that.commentaires) : that.commentaires != null) return false;
        if (numeroEtudiant != null ? !numeroEtudiant.equals(that.numeroEtudiant) : that.numeroEtudiant != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvaluationEcole;
        result = 31 * result + (noteFinale != null ? noteFinale.hashCode() : 0);
        result = 31 * result + (commentaires != null ? commentaires.hashCode() : 0);
        result = 31 * result + (numeroEtudiant != null ? numeroEtudiant.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}

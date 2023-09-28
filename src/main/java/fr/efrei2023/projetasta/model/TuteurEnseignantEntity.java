package fr.efrei2023.projetasta.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tuteur_enseignant", schema = "projet-asta", catalog = "")
public class TuteurEnseignantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tuteur_enseignant", nullable = false)
    private int idTuteurEnseignant;
    @Basic
    @Column(name = "id_utilisateur", nullable = false)
    private int idUtilisateur;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    public int getIdTuteurEnseignant() {
        return idTuteurEnseignant;
    }

    public void setIdTuteurEnseignant(int idTuteurEnseignant) {
        this.idTuteurEnseignant = idTuteurEnseignant;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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

        TuteurEnseignantEntity that = (TuteurEnseignantEntity) o;

        if (idTuteurEnseignant != that.idTuteurEnseignant) return false;
        if (idUtilisateur != that.idUtilisateur) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTuteurEnseignant;
        result = 31 * result + idUtilisateur;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}

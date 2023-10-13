package fr.efrei2023.projetasta.model.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "apprenti", schema = "`projet-asta`", catalog = "")
public class ApprentiEntity {
    @Id
    @Column(name = "numero_etudiant", nullable = false, length = 50)
    private String numeroEtudiant;
    @Basic
    @Column(name = "programme", nullable = true, length = 50)
    private String programme;
    @Basic
    @Column(name = "annee_academique", nullable = true, length = 50)
    private String anneeAcademique;
    @Basic
    @Column(name = "majeure", nullable = true, length = 50)
    private String majeure;
    @Basic
    @Column(name = "feedback", nullable = true, length = 50)
    private String feedback;
    @Basic
    @Column(name = "id_maitre_apprentissage", nullable = true)
    private int idMaitreApprentissage;
    @Basic
    @Column(name = "id_tuteur_enseignant", nullable = true)
    private int idTuteurEnseignant;
    @Basic
    @Column(name = "id_mission", nullable = true)
    private int idMission;
    @Basic
    @Column(name = "id_utilisateur", nullable = false)
    private int idUtilisateur;
    @Basic
    @Column(name = "is_archived", nullable = true)
    private Byte isArchived;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(String anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public String getMajeure() {
        return majeure;
    }

    public void setMajeure(String majeure) {
        this.majeure = majeure;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getIdMaitreApprentissage() {
        return idMaitreApprentissage;
    }

    public void setIdMaitreApprentissage(int idMaitreApprentissage) {
        this.idMaitreApprentissage = idMaitreApprentissage;
    }

    public int getIdTuteurEnseignant() {
        return idTuteurEnseignant;
    }

    public void setIdTuteurEnseignant(int idTuteurEnseignant) {
        this.idTuteurEnseignant = idTuteurEnseignant;
    }

    public int getIdMission() {
        return idMission;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Byte getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Byte isArchived) {
        this.isArchived = isArchived;
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

        ApprentiEntity that = (ApprentiEntity) o;

        if (idMaitreApprentissage != that.idMaitreApprentissage) return false;
        if (idTuteurEnseignant != that.idTuteurEnseignant) return false;
        if (idMission != that.idMission) return false;
        if (idUtilisateur != that.idUtilisateur) return false;
        if (numeroEtudiant != null ? !numeroEtudiant.equals(that.numeroEtudiant) : that.numeroEtudiant != null)
            return false;
        if (programme != null ? !programme.equals(that.programme) : that.programme != null) return false;
        if (anneeAcademique != null ? !anneeAcademique.equals(that.anneeAcademique) : that.anneeAcademique != null)
            return false;
        if (majeure != null ? !majeure.equals(that.majeure) : that.majeure != null) return false;
        if (feedback != null ? !feedback.equals(that.feedback) : that.feedback != null) return false;
        if (isArchived != null ? !isArchived.equals(that.isArchived) : that.isArchived != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numeroEtudiant != null ? numeroEtudiant.hashCode() : 0;
        result = 31 * result + (programme != null ? programme.hashCode() : 0);
        result = 31 * result + (anneeAcademique != null ? anneeAcademique.hashCode() : 0);
        result = 31 * result + (majeure != null ? majeure.hashCode() : 0);
        result = 31 * result + (feedback != null ? feedback.hashCode() : 0);
        result = 31 * result + idMaitreApprentissage;
        result = 31 * result + idTuteurEnseignant;
        result = 31 * result + idMission;
        result = 31 * result + idUtilisateur;
        result = 31 * result + (isArchived != null ? isArchived.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}

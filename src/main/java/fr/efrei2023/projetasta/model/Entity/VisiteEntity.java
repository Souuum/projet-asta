package fr.efrei2023.projetasta.model.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "visite", schema = "projet-asta", catalog = "")
public class VisiteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_visite", nullable = false)
    private int idVisite;
    @Basic
    @Column(name = "date_visite", nullable = true)
    private Date dateVisite;
    @Basic
    @Column(name = "format", nullable = true, length = 50)
    private String format;
    @Basic
    @Column(name = "compte_rendu_express", nullable = true, length = 50)
    private String compteRenduExpress;
    @Basic
    @Column(name = "numero_etudiant", nullable = false, length = 50)
    private String numeroEtudiant;
    @Basic
    @Column(name = "id_tuteur_enseignant", nullable = false)
    private int idTuteurEnseignant;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    public int getIdVisite() {
        return idVisite;
    }

    public void setIdVisite(int idVisite) {
        this.idVisite = idVisite;
    }

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCompteRenduExpress() {
        return compteRenduExpress;
    }

    public void setCompteRenduExpress(String compteRenduExpress) {
        this.compteRenduExpress = compteRenduExpress;
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    public int getIdTuteurEnseignant() {
        return idTuteurEnseignant;
    }

    public void setIdTuteurEnseignant(int idTuteurEnseignant) {
        this.idTuteurEnseignant = idTuteurEnseignant;
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

        VisiteEntity that = (VisiteEntity) o;

        if (idVisite != that.idVisite) return false;
        if (idTuteurEnseignant != that.idTuteurEnseignant) return false;
        if (dateVisite != null ? !dateVisite.equals(that.dateVisite) : that.dateVisite != null) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;
        if (compteRenduExpress != null ? !compteRenduExpress.equals(that.compteRenduExpress) : that.compteRenduExpress != null)
            return false;
        if (numeroEtudiant != null ? !numeroEtudiant.equals(that.numeroEtudiant) : that.numeroEtudiant != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVisite;
        result = 31 * result + (dateVisite != null ? dateVisite.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (compteRenduExpress != null ? compteRenduExpress.hashCode() : 0);
        result = 31 * result + (numeroEtudiant != null ? numeroEtudiant.hashCode() : 0);
        result = 31 * result + idTuteurEnseignant;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}

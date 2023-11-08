package fr.efrei2023.projetasta.dto;

import fr.efrei2023.projetasta.model.Entity.MissionEntity;

public class ApprentiInfoDTO {

    private String numeroEtudiant;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String majeure;
    private String anneeAcademique;
    private String programme;
    private MissionEntity mission;

    public ApprentiInfoDTO(String numeroEtudiant, String nom, String prenom, String email, String telephone, String majeure, String anneeAcademique, String programme, MissionEntity mission) {
        this.numeroEtudiant = numeroEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.majeure = majeure;
        this.anneeAcademique = anneeAcademique;
        this.programme = programme;
        this.mission = mission;

    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMajeure() {
        return majeure;
    }

    public String getAnneeAcademique() {
        return anneeAcademique;
    }
    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }
    public String getProgramme() {
        return programme;
}

    public MissionEntity getMission() {
        return mission;
    }
}

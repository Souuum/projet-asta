package fr.efrei2023.projetasta.dto;

public class ApprentiInfoDTO {

    private String numeroEtudiant;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String majeure;
    private String anneeAcademique;

    public ApprentiInfoDTO(String numeroEtudiant, String nom, String prenom, String email, String telephone, String majeure, String anneeAcademique) {
        this.numeroEtudiant = numeroEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.majeure = majeure;
        this.anneeAcademique = anneeAcademique;
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
}

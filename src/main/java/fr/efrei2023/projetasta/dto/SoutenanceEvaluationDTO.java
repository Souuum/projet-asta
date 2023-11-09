package fr.efrei2023.projetasta.dto;

import java.sql.Date;

public class SoutenanceEvaluationDTO {

    private String noteFinale;
    private String commentaires;
    private Date dateSoutenance;

    public SoutenanceEvaluationDTO(String noteFinale, String commentaires, Date dateSoutenance) {
        this.noteFinale = noteFinale;
        this.commentaires = commentaires;
        this.dateSoutenance = dateSoutenance;
    }

    public String getNoteFinale() {
        return noteFinale;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public Date getDateSoutenance() {
        return dateSoutenance;
    }
}

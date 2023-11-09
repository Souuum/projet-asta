package fr.efrei2023.projetasta.dto;

public class MemoireEvaluationDTO {
    private String noteFinale;
    private String commentaires;
    private String theme;

    public MemoireEvaluationDTO(String noteFinale, String commentaires, String theme) {
        this.noteFinale = noteFinale;
        this.commentaires = commentaires;
        this.theme = theme;
    }

    public String getNoteFinale() {
        return noteFinale;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public String getTheme() {
        return theme;
    }
}

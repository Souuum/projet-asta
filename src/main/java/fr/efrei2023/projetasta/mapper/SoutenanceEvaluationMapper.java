package fr.efrei2023.projetasta.mapper;
import fr.efrei2023.projetasta.dto.SoutenanceEvaluationDTO;
import fr.efrei2023.projetasta.model.Entity.EvaluationEcoleEntity;
import fr.efrei2023.projetasta.model.Entity.SoutenanceEntity;
public class SoutenanceEvaluationMapper {

    public SoutenanceEvaluationDTO toSoutenanceEvaluationDTO(EvaluationEcoleEntity evaluationEcole, SoutenanceEntity soutenance) {
        return new SoutenanceEvaluationDTO(
            evaluationEcole.getNoteFinale(),
            evaluationEcole.getCommentaires(),
            soutenance.getDateSoutenance()
        );
    }
}

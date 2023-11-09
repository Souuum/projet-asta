package fr.efrei2023.projetasta.mapper;
import fr.efrei2023.projetasta.dto.MemoireEvaluationDTO;
import fr.efrei2023.projetasta.model.Entity.EvaluationEcoleEntity;
import fr.efrei2023.projetasta.model.Entity.MemoireEntity;
public class MemoireEvaluationMapper {

    public MemoireEvaluationDTO toMemoireEvaluationDTO(EvaluationEcoleEntity evaluationEcole, MemoireEntity memoire) {
        return new MemoireEvaluationDTO(
            evaluationEcole.getNoteFinale(),
            evaluationEcole.getCommentaires(),
            memoire.getTheme()
        );
    }
}

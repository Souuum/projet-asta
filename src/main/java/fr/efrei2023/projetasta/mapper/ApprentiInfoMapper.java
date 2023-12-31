package fr.efrei2023.projetasta.mapper;
import fr.efrei2023.projetasta.dto.ApprentiInfoDTO;
import fr.efrei2023.projetasta.model.Entity.ApprentiEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;

import java.util.ArrayList;
import java.util.List;

public class ApprentiInfoMapper {
    public ApprentiInfoDTO toApprentiInfoDTO(ApprentiEntity apprentiEntity, UtilisateurEntity utilisateurEntity) {
        return new ApprentiInfoDTO(
            apprentiEntity.getNumeroEtudiant(),
            utilisateurEntity.getNom(),
            utilisateurEntity.getPrenom(),
            utilisateurEntity.getEmail(),
            utilisateurEntity.getTelephone(),
            apprentiEntity.getMajeure(),
            apprentiEntity.getAnneeAcademique(),
            apprentiEntity.getProgramme(),
            apprentiEntity.getMission()
        );
    }

    public List<ApprentiInfoDTO> toApprentiInfoDTOList(List<ApprentiEntity> apprentiEntityList, List<UtilisateurEntity> utilisateurEntityList) {
        List<ApprentiInfoDTO> apprentiInfoDTOList = new ArrayList<ApprentiInfoDTO>();
        for (ApprentiEntity apprentiEntity : apprentiEntityList) {
            for (UtilisateurEntity utilisateurEntity : utilisateurEntityList) {
                if (apprentiEntity.getIdUtilisateur() == utilisateurEntity.getIdUtilisateur()) {
                    apprentiInfoDTOList.add(toApprentiInfoDTO(apprentiEntity, utilisateurEntity));
                }
            }
        }
        return apprentiInfoDTOList;
    }
}

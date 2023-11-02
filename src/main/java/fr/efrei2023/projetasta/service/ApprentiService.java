package fr.efrei2023.projetasta.service;

import fr.efrei2023.projetasta.model.Entity.ApprentiEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import fr.efrei2023.projetasta.model.SB.ApprentiSB;
import fr.efrei2023.projetasta.model.SB.MissionSB;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.http.HttpServletRequest;

import static fr.efrei2023.projetasta.utils.ApprentiConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;

@Stateless
public class ApprentiService {

    @EJB
    private ApprentiSB apprentiSessionBean;

    @EJB
    private MissionSB missionSessionBean;

    @EJB
    private UserService userService;

    public ApprentiEntity getApprentiByUserId(int id){
        return apprentiSessionBean.getByUserId(id);
    }

    public ApprentiEntity getApprentiFromForm(HttpServletRequest request) {
        ApprentiEntity unApprenti = new ApprentiEntity();
        unApprenti.setNumeroEtudiant(request.getParameter(NUMERO_ETUDIANT));
        unApprenti.setProgramme(request.getParameter(PROGRAMME));
        unApprenti.setAnneeAcademique(request.getParameter(ANNEE_ACADEMIQUE));
        unApprenti.setMajeure(request.getParameter(MAJEURE));
        return unApprenti;
    }

    public void createApprenti(ApprentiEntity unApprenti){
        apprentiSessionBean.add(unApprenti);
    }

    public void updateApprentiByItSelf(HttpServletRequest request){
        String numéroEtudiant = request.getParameter(NUMERO_ETUDIANT);
        ApprentiEntity unApprenti = apprentiSessionBean.getById(numéroEtudiant);
        int idUser = unApprenti.getIdUtilisateur();
        UtilisateurEntity user = userService.getUtilisateurById(idUser);

        user.setEmail(request.getParameter(EMAIL));
        user.setTelephone(request.getParameter(TELEPHONE));
        user.setPassword(request.getParameter(PASSWORD));

        unApprenti.setFeedback(request.getParameter(FEEDBACK));
        unApprenti.setMajeure(request.getParameter(MAJEURE));
        updateApprenti(unApprenti);
    }

    public void updateApprenti(ApprentiEntity unApprenti){
        apprentiSessionBean.update(unApprenti);
    }



}

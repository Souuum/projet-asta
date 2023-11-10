package fr.efrei2023.projetasta.service;

import fr.efrei2023.projetasta.dto.MemoireEvaluationDTO;
import fr.efrei2023.projetasta.dto.SoutenanceEvaluationDTO;
import fr.efrei2023.projetasta.mapper.MemoireEvaluationMapper;
import fr.efrei2023.projetasta.mapper.SoutenanceEvaluationMapper;
import fr.efrei2023.projetasta.model.Entity.*;
import fr.efrei2023.projetasta.model.SB.*;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import static fr.efrei2023.projetasta.service.UserService.hashPassword;
import static fr.efrei2023.projetasta.utils.ApprentiConstants.*;
import static fr.efrei2023.projetasta.utils.EvaluationEcoleConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;

@Stateless
public class ApprentiService {

    @EJB
    private ApprentiSB apprentiSessionBean;

    @EJB
    private MissionSB missionSessionBean;

   @EJB
    private VisiteSB visiteSessionBean;
   @EJB
    private EvaluationEcoleSB evaluationEcoleSessionBean;
   @EJB
   private MemoireSB memoireSessionBean;
   @EJB
   private SoutenanceSB soutenanceSessionBean;

    @EJB
    private UserService userService;

    private MemoireEvaluationMapper memoireEvaluationMapper = new MemoireEvaluationMapper();

    private SoutenanceEvaluationMapper soutenanceEvaluationMapper = new SoutenanceEvaluationMapper();

    public ApprentiEntity getApprentiByUserId(int id){
        return apprentiSessionBean.getByUserId(id);
    }

    public ApprentiEntity getApprentiFromForm(HttpServletRequest request) {
        ApprentiEntity unApprenti = new ApprentiEntity();
        unApprenti.setNumeroEtudiant(request.getParameter(NUMERO_ETUDIANT));
        unApprenti.setProgramme(request.getParameter(PROGRAMME));
        unApprenti.setAnneeAcademique(request.getParameter(ANNEE_ACADEMIQUE));
        unApprenti.setMajeure(request.getParameter(MAJEURE));
        unApprenti.setProgramme(request.getParameter(PROGRAMME));
        return unApprenti;
    }

    public void createApprenti(ApprentiEntity unApprenti){
        apprentiSessionBean.add(unApprenti);
    }

    public void updateApprentiByItSelf(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try{
            String numeroEtudiant = request.getParameter(NUMERO_ETUDIANT);

            ApprentiEntity unApprenti = apprentiSessionBean.getById(numeroEtudiant);
            int idUser = unApprenti.getIdUtilisateur();
            UtilisateurEntity user = userService.getUtilisateurById(idUser);

            user.setEmail(request.getParameter(EMAIL));
            user.setTelephone(request.getParameter(TELEPHONE));


            updateApprenti(unApprenti);
            userService.updateUser(user);
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("apprenti", unApprenti);
            request.setAttribute("message", "Vos informations ont été mises à jour");
            request.setAttribute("color", "green");
            request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("message", "Une erreur est survenue");
            request.setAttribute("color", "red");
            request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);


        }

    }

    public void updateFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String numeroEtudiant = request.getParameter(NUMERO_ETUDIANT);
            ApprentiEntity apprenti = apprentiSessionBean.getById(numeroEtudiant);
            int idUser = apprenti.getIdUtilisateur();
            UtilisateurEntity user = userService.getUtilisateurById(idUser);
            String feedback = request.getParameter(FEEDBACK);
            System.out.println("feedback");
            System.out.println(feedback);
            apprenti.setFeedback(feedback);
            apprentiSessionBean.update(apprenti);
            request.getSession().setAttribute("apprenti", apprenti);
            request.getSession().setAttribute("user", user);
            request.setAttribute("message", "Feedback mis à jour");
            request.setAttribute("color", "green");
            request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("message", "Une erreur est survenue");
            request.setAttribute("color", "red");
            request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);
        }


    }



    public void updateApprenti(ApprentiEntity unApprenti){
        apprentiSessionBean.update(unApprenti);
    }


    public VisiteEntity getVisiteByNumeroEtudiant(String id) {
        return visiteSessionBean.getByNumeroEtudiant(id);
    }

    public EvaluationEcoleEntity getMemoireEvalByNumeroEtudiant(String id) {
        return evaluationEcoleSessionBean.getByNumeroEtudiantAndType(id, MEMOIRE);
    }

    public EvaluationEcoleEntity getSoutenanceEvalByNumeroEtudiant(String id) {
        return evaluationEcoleSessionBean.getByNumeroEtudiantAndType(id, SOUTENANCE);
    }

    public MemoireEvaluationDTO getMemoireEvaluationDTOByNumeroEtudiant(String id){
        EvaluationEcoleEntity memoireEval = getMemoireEvalByNumeroEtudiant(id);
        MemoireEntity memoire;
        if(memoireEval != null){
            memoire = memoireSessionBean.getByEvaluationEcoleId(memoireEval.getIdEvaluationEcole());
        }
        else{
            return null;
        }
        return memoireEvaluationMapper.toMemoireEvaluationDTO(memoireEval, memoire);

    }

    public SoutenanceEvaluationDTO getSoutenanceEvaluationDTOByNumeroEtudiant(String id){
        EvaluationEcoleEntity soutenanceEval = getSoutenanceEvalByNumeroEtudiant(id);
        SoutenanceEntity soutenance;
        if(soutenanceEval != null){
            soutenance = soutenanceSessionBean.getByEvaluationEcoleId(soutenanceEval.getIdEvaluationEcole());
        }
        else{
            return null;
        }
        return soutenanceEvaluationMapper.toSoutenanceEvaluationDTO(soutenanceEval, soutenance);

    }


}

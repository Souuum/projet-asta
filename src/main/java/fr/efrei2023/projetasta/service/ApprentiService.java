package fr.efrei2023.projetasta.service;

import fr.efrei2023.projetasta.model.Entity.ApprentiEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import fr.efrei2023.projetasta.model.Entity.VisiteEntity;
import fr.efrei2023.projetasta.model.SB.ApprentiSB;
import fr.efrei2023.projetasta.model.SB.MissionSB;
import fr.efrei2023.projetasta.model.SB.VisiteSB;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import static fr.efrei2023.projetasta.service.UserService.hashPassword;
import static fr.efrei2023.projetasta.utils.ApprentiConstants.*;
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
        unApprenti.setProgramme(request.getParameter(PROGRAMME));
        return unApprenti;
    }

    public void createApprenti(ApprentiEntity unApprenti){
        apprentiSessionBean.add(unApprenti);
    }

    public void updateApprentiByItSelf(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

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
        request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);
    }

    public void updateFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);

    }



    public void updateApprenti(ApprentiEntity unApprenti){
        apprentiSessionBean.update(unApprenti);
    }


    public VisiteEntity getVisiteByNumeroEtudiant(String id) {
        return visiteSessionBean.getByNumeroEtudiant(id);
    }

}

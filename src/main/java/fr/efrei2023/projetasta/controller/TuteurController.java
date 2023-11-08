package fr.efrei2023.projetasta.controller;

import fr.efrei2023.projetasta.dto.ApprentiInfoDTO;
import fr.efrei2023.projetasta.model.Entity.ApprentiEntity;
import fr.efrei2023.projetasta.model.Entity.EntrepriseEntity;
import fr.efrei2023.projetasta.model.Entity.MaitreApprentissageEntity;
import fr.efrei2023.projetasta.model.SB.TuteurEnseignantSB;
import fr.efrei2023.projetasta.model.SB.UtilisateurSB;
import fr.efrei2023.projetasta.service.TuteurService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import fr.efrei2023.projetasta.service.*;

import static fr.efrei2023.projetasta.utils.ApprentiConstants.APPRENTI_HOME_PAGE;
import static fr.efrei2023.projetasta.utils.ApprentiConstants.APPRENTI_REGISTER_PAGE;
import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.*;

@WebServlet(name = "TuteurController", value = "/tuteur-controller")
public class TuteurController extends HttpServlet {

    @EJB
    private TuteurService tuteurService;
    @EJB
    private UserService userService;

    public void init() {
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        List<MaitreApprentissageEntity> maitreApprentissageList;
        List<EntrepriseEntity> entrepriseList;
        List<ApprentiInfoDTO> apprentiDTOList;

        if (action.equals("SignUp") && request.getSession(false).getAttribute("user") == null) {
            tuteurService.creationProcess(request, response);
        }
        if (request.getSession(false).getAttribute("user") == null) {
            request.getRequestDispatcher(TUTEUR_REGISTER_PAGE).forward(request, response);
        } else {
            switch (action) {
                case "+ Ajouter Apprenti":
                    tuteurService.getListeApprentisNotFromTuteur(request, response);
                    request.getRequestDispatcher(ASSIGNER_APPRENTI_PAGE).forward(request, response);
                    break;
                case "+ Ajouter Maitre Apprentissage":
                    entrepriseList = tuteurService.getListeEntreprises(request, response);
                    request.getSession().setAttribute("entrepriseList", entrepriseList);
                    request.getRequestDispatcher(AJOUTER_MAITRE_APPRENTISSAGE_PAGE).forward(request, response);
                    break;
                case "+ Ajouter Entreprise":
                    request.getRequestDispatcher(AJOUTER_ENTREPRISE_PAGE).forward(request, response);
                    break;
                case "AjouterMaitreApprentissage":
                    tuteurService.addMaitreApprentissage(request, response);
                    maitreApprentissageList = tuteurService.getListeMaitresApprentissage(request, response);
                    request.getSession().setAttribute("maitreApprentissageList", maitreApprentissageList);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;
                case "AjouterEntreprise":
                    tuteurService.addEntreprise(request, response);
                    entrepriseList = tuteurService.getListeEntreprises(request, response);
                    request.getSession().setAttribute("entrepriseList", entrepriseList);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;
                case "AssignerApprenti":
                    tuteurService.assignerApprenti(request, response);
                    tuteurService.getListeApprentiInfoFromTuteur(request, response);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;
                case "ModifierApprentiPage":
                    tuteurService.modifierApprentiPage(request, response);
                    request.getRequestDispatcher(MODIFIER_APPRENTI_PAGE).forward(request, response);
                    break;
                case "ModifierMaitreApprentissagePage":
                    tuteurService.modifierMaitreApprentissagePage(request, response);
                    request.getRequestDispatcher(MODIFIER_MAITRE_APPRENTISSAGE_PAGE).forward(request, response);
                    break;
                case "ModifierEntreprisePage":
                    tuteurService.modifierEntreprisePage(request, response);
                    request.getRequestDispatcher(MODIFIER_ENTREPRISE_PAGE).forward(request, response);
                    break;
                case "ModifierApprenti":
                    tuteurService.modifierApprenti(request, response);
                    tuteurService.getListeApprentiInfoFromTuteur(request, response);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                case "ModifierMaitreApprentissage":
                    tuteurService.modifierMaitreApprentissage(request, response);
                    maitreApprentissageList = tuteurService.getListeMaitresApprentissage(request, response);
                    request.getSession().setAttribute("maitreApprentissageList", maitreApprentissageList);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;

                case "ModifierEntreprise":
                    tuteurService.modifierEntreprise(request, response);
                    entrepriseList = tuteurService.getListeEntreprises(request, response);
                    request.getSession().setAttribute("entrepriseList", entrepriseList);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;
                case "AjouterMission":
                    //TODO
                    break;
                case "ModifierMission":
                    //TODO
                    break;
                case "AjouterVisite":
                    //TODO
                    break;
                case "AjouterSoutenance":
                    //TODO
                    break;
                case "ModifierSoutenance":
                    //TODO
                    break;
                case "AjouterMemoire":
                    //TODO
                    break;
                case "ModifierMemoire":
                    //TODO
                    break;
                default:
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;

            }
        }
        switch(action){

            case "SignIn":
                userService.loginProcess(request, response);
                break;


            default:
                request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                break;

        }
    }
    @Override
    public void destroy() {
        super.destroy();
    }
}

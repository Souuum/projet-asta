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
import jakarta.servlet.http.HttpSession;

import static fr.efrei2023.projetasta.utils.ApprentiConstants.APPRENTI_HOME_PAGE;
import static fr.efrei2023.projetasta.utils.ApprentiConstants.APPRENTI_REGISTER_PAGE;
import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;

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
        String action = request.getParameter(ACTION);
        HttpSession session = request.getSession(false);
        if (action.equals(ACTION_SIGNUP) && request.getSession(false).getAttribute("user") == null) {
            tuteurService.creationProcess(request, response);
        }
        if (session == null || session.getAttribute("user") == null) {
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        } else {
            switch (action) {
                case ACTION_ADD_APPRENTI:
                    tuteurService.getListeApprentisNotFromTuteur(request, response);
                    request.getRequestDispatcher(ASSIGNER_APPRENTI_PAGE).forward(request, response);
                    break;
                case ACTION_ADD_MAITRE_APPRENTISSAGE:
                    tuteurService.getListeEntreprises(request, response);
                    request.getRequestDispatcher(AJOUTER_MAITRE_APPRENTISSAGE_PAGE).forward(request, response);
                    break;
                case ACTION_ADD_ENTREPRISE:
                    request.getRequestDispatcher(AJOUTER_ENTREPRISE_PAGE).forward(request, response);
                    break;
                case ACTION_AJOUTER_MAITRE_APPRENTISSAGE:
                    tuteurService.addMaitreApprentissage(request, response);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;
                case ACTION_AJOUTER_ENTREPRISE:
                    tuteurService.addEntreprise(request, response);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;
                case ACTION_ASSIGNER_APPRENTI:
                    tuteurService.assignerApprenti(request, response);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;
                case ACTION_MODIFIER_APPRENTI_PAGE:
                    tuteurService.modifierApprentiPage(request, response);
                    request.getRequestDispatcher(MODIFIER_APPRENTI_PAGE).forward(request, response);
                    break;
                case ACTION_MODIFIER_MAITRE_APPRENTISSAGE_PAGE:
                    tuteurService.modifierMaitreApprentissagePage(request, response);
                    request.getRequestDispatcher(MODIFIER_MAITRE_APPRENTISSAGE_PAGE).forward(request, response);
                    break;
                case ACTION_MODIFIER_ENTREPRISE_PAGE:
                    tuteurService.modifierEntreprisePage(request, response);
                    request.getRequestDispatcher(MODIFIER_ENTREPRISE_PAGE).forward(request, response);
                    break;
                case ACTION_MODIFIER_APPRENTI:
                    tuteurService.modifierApprenti(request, response);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;
                case ACTION_MODIFIER_MAITRE_APPRENTISSAGE:
                    tuteurService.modifierMaitreApprentissage(request, response);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;
                case ACTION_MODIFIER_ENTREPRISE:
                    tuteurService.modifierEntreprise(request, response);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;

            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

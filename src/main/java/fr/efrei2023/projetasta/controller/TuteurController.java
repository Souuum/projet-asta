package fr.efrei2023.projetasta.controller;

import fr.efrei2023.projetasta.dto.ApprentiInfoDTO;
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

        if (action.equals("SignUp") && request.getSession(false).getAttribute("user") == null) {
            tuteurService.creationProcess(request, response);
        }
        if (request.getSession(false).getAttribute("user") == null) {
            request.getRequestDispatcher(TUTEUR_REGISTER_PAGE).forward(request, response);
        } else {
            tuteurService.getListeEntreprises(request, response);
            tuteurService.getListeMaitresApprentissage(request, response);
            switch (action) {
                case "+ Ajouter":
                    tuteurService.getListeApprentisNotFromTuteur(request, response);
                    request.getRequestDispatcher(ASSIGNER_APPRENTI_PAGE).forward(request, response);
                    break;
                case "AssignerApprenti":
                    tuteurService.assignerApprenti(request, response);
                    tuteurService.getListeApprentiInfoFromTuteur(request, response);
                    request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
                    break;
                case "AssignerMaitreApprentissage":
                    //TODO
                    break;
                case "AjouterEntreprise":
                    //TODO
                    break;
                case "AjouterMaitreApprentissage":
                    //TODO
                    break;
                case "ModifierMaitreApprentissage":
                    //TODO
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

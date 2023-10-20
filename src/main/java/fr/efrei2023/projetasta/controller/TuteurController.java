package fr.efrei2023.projetasta.controller;

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
import fr.efrei2023.projetasta.service.*;

import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.*;

@WebServlet(name = "TuteurController", value = "/tuteur-controller")
public class TuteurController extends HttpServlet {


    @EJB
    private TuteurEnseignantSB tuteurEnseignantSessionBean;
    @EJB
    private UtilisateurSB utilisateurSessionBean;
    private TuteurService tuteurService = new TuteurService();
    private UserService userService = new UserService();

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

        switch(action){
            case "SignUp":
                tuteurService.creationProcess(request, response);
                break;
            case "SignIn":
                userService.loginProcess(request, response);
                break;
            case "ListApprentis":
                //TODO
                break;
            case "ListEntreprises":
                //TODO
                break;
            case "ListeMaitresApprentissage":
                //TODO
                break;
            case "AssignerApprenti":
                //TODO
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
    @Override
    public void destroy() {
        super.destroy();
    }
}

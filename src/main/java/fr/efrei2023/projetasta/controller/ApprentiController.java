package fr.efrei2023.projetasta.controller;

import java.io.*;


import fr.efrei2023.projetasta.model.SB.MissionSB;
import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import fr.efrei2023.projetasta.model.Entity.ApprentiEntity;
import fr.efrei2023.projetasta.model.SB.ApprentiSB;
import fr.efrei2023.projetasta.model.SB.UtilisateurSB;
import fr.efrei2023.projetasta.service.ApprentiService;
import fr.efrei2023.projetasta.service.UserService;
import static fr.efrei2023.projetasta.utils.ApprentiConstants.*;
import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.TUTEUR_ROLE;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;

@WebServlet(name = "ApprentiController", value = "/apprenti-controller")

public class ApprentiController extends HttpServlet {

    @EJB
    private ApprentiService apprentiService;

    @EJB
    private UserService userService;



    public ApprentiEntity getApprentiFromForm(HttpServletRequest request) {
        ApprentiEntity unApprenti = new ApprentiEntity();
        unApprenti.setNumeroEtudiant(request.getParameter(NUMERO_ETUDIANT));
        unApprenti.setProgramme(request.getParameter(PROGRAMME));
        unApprenti.setAnneeAcademique(request.getParameter(ANNEE_ACADEMIQUE));
        unApprenti.setMajeure(request.getParameter(MAJEURE));
        return unApprenti;
    }

    public UtilisateurEntity getUtilisateurFromForm(HttpServletRequest request){
        UtilisateurEntity unUtilisateur = new UtilisateurEntity();
        unUtilisateur.setNom(request.getParameter(NOM));
        unUtilisateur.setPrenom(request.getParameter(PRENOM));
        unUtilisateur.setEmail(request.getParameter(EMAIL));
        unUtilisateur.setPassword(request.getParameter(PASSWORD));
        unUtilisateur.setIsadmin(TUTEUR_ROLE);
        return unUtilisateur;
    }
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

        System.out.println(request.getSession());

        if (action.equals("SignUp") && request.getSession(false).getAttribute("user") == null) {
            creationProcess(request, response);
        }

        if (request.getSession(false).getAttribute("user") == null) {
            request.getRequestDispatcher(APPRENTI_REGISTER_PAGE).forward(request, response);
        } else {
            switch (action) {

                case "modify":
                    break;
                default:
                    request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);
                    break;

                }
        }
    }




    public void creationProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtilisateurEntity unUtilisateur = getUtilisateurFromForm(request);

        if(userService.verifyIfUserExistByEmail(unUtilisateur.getEmail())){
            request.setAttribute("messageErreur",EMAIL_EXIST_ERROR_MESSAGE);
            request.getRequestDispatcher(APPRENTI_REGISTER_PAGE).forward(request, response);
        }else{
            ApprentiEntity unApprenti = getApprentiFromForm(request);
            userService.createUser(unUtilisateur);
            unApprenti.setIdUtilisateur(userService.getIdUtilisateurByEmail(unUtilisateur.getEmail()));
            apprentiService.createApprenti(unApprenti);
            request.getSession().setAttribute("user", unUtilisateur);
            request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

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

                case APPRENTI_EDIT_SELF_DATA:
                    apprentiService.updateApprentiByItSelf(request, response);
                    break;

                case APPRENTI_EDIT_FEEDBACK:
                    apprentiService.updateFeedback(request, response);
                    break;
                default:
                    request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);
                    break;
                }
        }
    }




    public void creationProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtilisateurEntity unUtilisateur = userService.getUtilisateurFromForm(request, APPRENTI_ROLE);

        if(userService.verifyIfUserExistByEmail(unUtilisateur.getEmail())){
            request.setAttribute("messageErreur",EMAIL_EXIST_ERROR_MESSAGE);
            request.getRequestDispatcher(APPRENTI_REGISTER_PAGE).forward(request, response);
        }else{
            ApprentiEntity unApprenti = apprentiService.getApprentiFromForm(request);
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

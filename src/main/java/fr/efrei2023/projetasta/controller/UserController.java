package fr.efrei2023.projetasta.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

import fr.efrei2023.projetasta.service.UserService;

import static fr.efrei2023.projetasta.utils.ApprentiConstants.APPRENTI_HOME_PAGE;
import static fr.efrei2023.projetasta.utils.ApprentiConstants.APPRENTI_REGISTER_PAGE;
import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.TUTEUR_REGISTER_PAGE;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(name = "UserController", value = "/user-controller")

public class UserController extends HttpServlet{

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

        switch(action){
            case "login":
                userService.loginProcess(request, response);
                break;
            case "logout":
                userService.logoutProcess(request, response);
                request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
                break;
            case "registerApprenti":
                request.getRequestDispatcher(APPRENTI_REGISTER_PAGE).forward(request, response);
                break;
            case "registerTuteur":
                request.getRequestDispatcher(TUTEUR_REGISTER_PAGE).forward(request, response);
                break;

            default:
                break;
        }






    }



}

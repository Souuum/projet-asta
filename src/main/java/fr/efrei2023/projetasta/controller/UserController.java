package fr.efrei2023.projetasta.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

import fr.efrei2023.projetasta.service.UserService;
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
                loginProcess(request, response);
                break;
            case "logout":
                logoutProcess(request, response);
                break;
            case "registerApprenti":
                registerProcess(request, response);
                break;
            case "registerTuteur":
                updateProcess(request, response);
                break;
            default:
                break;
        }






    }



}

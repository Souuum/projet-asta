package fr.efrei2023.projetasta.service;

import fr.efrei2023.projetasta.model.Entity.ApprentiEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static fr.efrei2023.projetasta.utils.ApprentiConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.EMAIL_EXIST_ERROR_MESSAGE;

@Stateless
public class AuthService {
    @EJB
    private UserService userService;
    @EJB
    private ApprentiService apprentiService;

    public void creationProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isAdmin", APPRENTI_ROLE);
        UtilisateurEntity unUtilisateur = userService.getUtilisateurFromForm(request);

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
}

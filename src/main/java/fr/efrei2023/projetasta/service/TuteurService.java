package fr.efrei2023.projetasta.service;

import fr.efrei2023.projetasta.model.Entity.TuteurEnseignantEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import fr.efrei2023.projetasta.model.SB.TuteurEnseignantSB;
import fr.efrei2023.projetasta.model.SB.UtilisateurSB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import fr.efrei2023.projetasta.service.UserService.*;

import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;

public class TuteurService {
    @EJB
    private TuteurEnseignantSB tuteurEnseignantSessionBean;

    private UserService userService = new UserService();
    public void creationProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UtilisateurEntity unUtilisateur = userService.getUtilisateurFromForm(request);
        if(userService.verifyIfUserExistByEmail(unUtilisateur.getEmail())){
            request.setAttribute("messageErreur",EMAIL_EXIST_ERROR_MESSAGE);
            request.getRequestDispatcher(TUTEUR_REGISTER_PAGE).forward(request, response);
        }else{
            TuteurEnseignantEntity unTuteur = getTuteurFromForm(request);
            userService.createUser(unUtilisateur);
            unTuteur.setIdUtilisateur(userService.getIdUtilisateurByEmail(unUtilisateur.getEmail()));
            createTuteur(unTuteur);
            request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
        }
    }

    public void loginProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UtilisateurEntity unUtilisateur = userService.getUtilisateur(request);
        //Verify if user doesnt exists
        if(!userService.verifyIfUserExistByEmail(unUtilisateur.getEmail())){
            request.setAttribute("messageErreur",USER_NOT_EXIST_ERROR_MESSAGE);
            request.getRequestDispatcher(TUTEUR_LOGIN_PAGE).forward(request, response);
        }

        //Verify if user is not tuteur
        if(!userService.verifyIfUserIsTuteur(unUtilisateur.getEmail())){
            request.setAttribute("messageErreur",USER_NOT_TUTEUR_ERROR_MESSAGE);
            request.getRequestDispatcher(TUTEUR_LOGIN_PAGE).forward(request, response);
        }

        //Verify if password is not correct
        if(!userService.getUtilisateurPasswordByEmail(unUtilisateur.getEmail()).equals(unUtilisateur.getPassword())){
            request.setAttribute("messageErreur",PASSWORD_ERROR_MESSAGE);
            request.getRequestDispatcher(TUTEUR_LOGIN_PAGE).forward(request, response);
        }

        //Create session
        //TODO
        request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
    }


    public TuteurEnseignantEntity getTuteurFromForm(HttpServletRequest request) {
        TuteurEnseignantEntity unTuteur = new TuteurEnseignantEntity();

        return unTuteur;
    }

    public void createTuteur(TuteurEnseignantEntity unTuteur){
        tuteurEnseignantSessionBean.add(unTuteur);
    }
}

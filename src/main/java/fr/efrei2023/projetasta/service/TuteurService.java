package fr.efrei2023.projetasta.service;

import fr.efrei2023.projetasta.model.Entity.TuteurEnseignantEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import fr.efrei2023.projetasta.model.SB.TuteurEnseignantSB;
import fr.efrei2023.projetasta.model.SB.UtilisateurSB;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import fr.efrei2023.projetasta.service.UserService.*;

import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;

@Stateless
public class TuteurService {
    @EJB
    private TuteurEnseignantSB tuteurEnseignantSessionBean;

    @EJB
    private UtilisateurSB utilisateurSessionBean;
    private UserService userService = new UserService();

    public TuteurEnseignantEntity getTuteurByUserId(int id){
        return tuteurEnseignantSessionBean.getByUserId(id);
    }
    public void creationProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UtilisateurEntity unUtilisateur = userService.getUtilisateurFromForm(request);
        if(userService.verifyIfUserExistByEmail(unUtilisateur.getEmail())){
            request.setAttribute("messageErreur",EMAIL_EXIST_ERROR_MESSAGE);
            request.getRequestDispatcher(TUTEUR_REGISTER_PAGE).forward(request, response);
        }else{
            TuteurEnseignantEntity unTuteur = getTuteurFromForm(request);
            //userService.createUser(unUtilisateur);
            //unTuteur.setIdUtilisateur(userService.getIdUtilisateurByEmail(unUtilisateur.getEmail()));
            createTuteur(unTuteur);
            request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
        }
    }

    public void getListeApprentis(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public TuteurEnseignantEntity getTuteurFromForm(HttpServletRequest request) {
        TuteurEnseignantEntity unTuteur = new TuteurEnseignantEntity();

        return unTuteur;
    }

    public void createTuteur(TuteurEnseignantEntity unTuteur){
        tuteurEnseignantSessionBean.add(unTuteur);
    }
}

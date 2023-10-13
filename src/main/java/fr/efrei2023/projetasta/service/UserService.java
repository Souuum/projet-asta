package fr.efrei2023.projetasta.service;

import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import fr.efrei2023.projetasta.model.SB.UtilisateurSB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.io.IOException;


import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.TUTEUR_ROLE;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.PASSWORD;

public class UserService {
    @EJB
    private UtilisateurSB utilisateurSessionBean;
    public boolean verifyIfUserExistByEmail(String email){
        return utilisateurSessionBean.getUtilisateurByEmail(email) != null;
    }

    public int getIdUtilisateurByEmail(String email){
        return utilisateurSessionBean.getUtilisateurByEmail(email).getIdUtilisateur();
    }

    public String getUtilisateurPasswordByEmail(String email){
        return utilisateurSessionBean.getUtilisateurByEmail(email).getPassword();
    }

    public void createUser(UtilisateurEntity unUtilisateur){
        utilisateurSessionBean.createUtilisateur(unUtilisateur);
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

    public void loginProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UtilisateurEntity unUtilisateur = getUtilisateur(request);
        // Verify if user exist
        if(!verifyIfUserExistByEmail(unUtilisateur.getEmail())) {
            request.setAttribute("messageErreur", EMAIL_NOT_EXIST_ERROR_MESSAGE);
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }

        // Verify if password is correct
        String password = hashPassword(unUtilisateur.getPassword());
        if(!getUtilisateurPasswordByEmail(unUtilisateur.getEmail()).equals(password)) {
            request.setAttribute("messageErreur", PASSWORD_ERROR_MESSAGE);
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }

        //Create session
        //TODO

        // Check role of user
        if(verifyRoleOfUser(unUtilisateur.getEmail()) == TUTEUR_ROLE) {
            request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
        } else {
            request.getRequestDispatcher(ETUDIANT_HOME_PAGE).forward(request, response);
        }

    }

    public UtilisateurEntity getUtilisateur(HttpServletRequest request){
        UtilisateurEntity unUtilisateur = new UtilisateurEntity();
        unUtilisateur.setEmail(request.getParameter(EMAIL));
        unUtilisateur.setPassword(request.getParameter(PASSWORD));
        return unUtilisateur;
    }

    public int verifyRoleOfUser(String email){
        return utilisateurSessionBean.getUtilisateurByEmail(email).getIsadmin();
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedHash).substring(0, 32); // Truncate to 32 characters
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
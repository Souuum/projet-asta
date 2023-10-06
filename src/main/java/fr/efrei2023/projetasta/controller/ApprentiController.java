package fr.efrei2023.projetasta.controller;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import fr.efrei2023.projetasta.model.Entity.ApprentiEntity;
import fr.efrei2023.projetasta.model.SB.ApprentiSB;
import fr.efrei2023.projetasta.model.SB.UtilisateurSB;

import static fr.efrei2023.projetasta.utils.ApprentiConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;

@WebServlet(name = "ApprentiController", value = "/apprenti-controller")

public class ApprentiController extends HttpServlet {

    @EJB
    private ApprentiSB apprentiSessionBean;
    @EJB
    private UtilisateurSB utilisateurSessionBean;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        switch(action){
            case "creation":
                creationProcess(request, response);
                break;
            default:
                request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);
                break;

        }
    }


    public UtilisateurEntity getUtilisateurFromForm(HttpServletRequest request){
        UtilisateurEntity unUtilisateur = new UtilisateurEntity();
        unUtilisateur.setNom(request.getParameter(NOM));
        unUtilisateur.setPrenom(request.getParameter(PRENOM));
        unUtilisateur.setEmail(request.getParameter(EMAIL));
        unUtilisateur.setPassword(request.getParameter(PASSWORD));
        unUtilisateur.setIsadmin(Byte.parseByte(request.getParameter(ISADMIN)));
        return unUtilisateur;
    }

    public ApprentiEntity getApprentiFromForm(HttpServletRequest request) {
        ApprentiEntity unApprenti = new ApprentiEntity();
        unApprenti.setNumeroEtudiant(request.getParameter(NUMERO_ETUDIANT));
        unApprenti.setProgramme(request.getParameter(PROGRAMME));
        unApprenti.setAnneeAcademique(request.getParameter(ANNEE_ACADEMIQUE));
        unApprenti.setMajeure(request.getParameter(MAJEURE));
        return unApprenti;
    }
    public boolean verifyIfUserExistByEmail(String email){

        return utilisateurSessionBean.getUtilisateurByEmail(email) != null;
    }

    public int getIdUtilisateurByEmail(String email){
        return utilisateurSessionBean.getUtilisateurByEmail(email).getIdUtilisateur();
    }

    public void createUser(UtilisateurEntity unUtilisateur){
        utilisateurSessionBean.createUtilisateur(unUtilisateur);
    }


    public void createApprenti(ApprentiEntity unApprenti){
        apprentiSessionBean.createApprenti(unApprenti);
    }

    public void creationProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtilisateurEntity unUtilisateur = getUtilisateurFromForm(request);
        if(verifyIfUserExistByEmail(unUtilisateur.getEmail())){
            request.setAttribute("messageErreur",EMAIL_EXIST_ERROR_MESSAGE);
            request.getRequestDispatcher(APPRENTI_REGISTER_PAGE).forward(request, response);
        }else{
            ApprentiEntity unApprenti = getApprentiFromForm(request);
            createUser(unUtilisateur);
            unApprenti.setIdUtilisateur(getIdUtilisateurByEmail(unUtilisateur.getEmail()));
            createApprenti(unApprenti);
            request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

package fr.efrei2023.projetasta.service;

import fr.efrei2023.projetasta.dto.ApprentiInfoDTO;
import fr.efrei2023.projetasta.model.Entity.ApprentiEntity;
import fr.efrei2023.projetasta.model.Entity.TuteurEnseignantEntity;
import fr.efrei2023.projetasta.model.Entity.UtilisateurEntity;
import fr.efrei2023.projetasta.model.SB.UtilisateurSB;
import fr.efrei2023.projetasta.dto.ApprentiInfoDTO;
import fr.efrei2023.projetasta.mapper.ApprentiInfoMapper;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import java.io.IOException;


import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.TUTEUR_ROLE;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.PASSWORD;
import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.*;
import static fr.efrei2023.projetasta.utils.ApprentiConstants.*;
@Stateless
public class UserService {

    @EJB
    private UtilisateurSB utilisateurSessionBean;

    @EJB
    private ApprentiService apprentiService;

    @EJB
    private TuteurService tuteurService;

    private ApprentiInfoMapper apprentiInfoMapper = new ApprentiInfoMapper();

    public UtilisateurEntity getUtilisateurById(int id){
        return utilisateurSessionBean.getById(id);
    }

    public boolean verifyIfUserExistByEmail(String email){
        return utilisateurSessionBean.getUtilisateurByEmail(email) != null;
    }

    public int getIdUtilisateurByEmail(String email){
        return utilisateurSessionBean.getUtilisateurByEmail(email).getIdUtilisateur();
    }

    public UtilisateurEntity getUtilisateurByEmail(String email){
        return utilisateurSessionBean.getUtilisateurByEmail(email);
    }

    public String getUtilisateurPasswordByEmail(String email){
        return utilisateurSessionBean.getUtilisateurByEmail(email).getPassword();
    }

    public void createUser(UtilisateurEntity unUtilisateur){
        utilisateurSessionBean.add(unUtilisateur);
    }



    public UtilisateurEntity getUtilisateurFromForm(HttpServletRequest request, boolean isAdmin){
        UtilisateurEntity unUtilisateur = new UtilisateurEntity();
        unUtilisateur.setNom(request.getParameter(NOM));
        unUtilisateur.setPrenom(request.getParameter(PRENOM));
        unUtilisateur.setEmail(request.getParameter(EMAIL));
        unUtilisateur.setTelephone(request.getParameter(TELEPHONE));
        String password = hashPassword(request.getParameter(PASSWORD));
        unUtilisateur.setPassword(password);
        unUtilisateur.setIsadmin(isAdmin);
        return unUtilisateur;
    }



    public void loginProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Verify if user exist
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);

        boolean emailValid = verifyIfUserExistByEmail(email);
        if(!emailValid) {
            request.setAttribute("messageErreur", EMAIL_NOT_EXIST_ERROR_MESSAGE);
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }

        // Verify if password is correct
        boolean passwordValid = getUtilisateurPasswordByEmail(email).equals(hashPassword(password));
        if(!passwordValid) {
            request.setAttribute("messageErreur", PASSWORD_ERROR_MESSAGE);
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }

            if(!emailValid || !passwordValid){
                System.out.println("Email or password is not valid");
        }
        else{
            System.out.println("Login success");
            UtilisateurEntity unUtilisateur = getUtilisateurById(getIdUtilisateurByEmail(email));
            request.getSession().setAttribute("user", unUtilisateur);
            // Check role of user
            if(verifyRoleOfUser(unUtilisateur.getEmail()) == TUTEUR_ROLE) {
                TuteurEnseignantEntity tuteur = tuteurService.getTuteurByUserId(unUtilisateur.getIdUtilisateur());
                request.getSession().setAttribute("tuteur", tuteur);

                List<ApprentiEntity> apprentiList = tuteurService.getListeApprentisFromTuteur(tuteur.getIdTuteurEnseignant());
                List<UtilisateurEntity> utilisateurList = tuteurService.getListeUtilisateurFromTuteur(tuteur.getIdTuteurEnseignant());
                List<ApprentiInfoDTO> apprentiListDTO = apprentiInfoMapper.toApprentiInfoDTOList(apprentiList, utilisateurList);
                request.getSession().setAttribute("apprentiListDTO", apprentiListDTO);

                request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
            } else {
                ApprentiEntity apprenti = apprentiService.getApprentiByUserId(unUtilisateur.getIdUtilisateur());
                request.getSession().setAttribute("apprenti", apprenti);
                request.getRequestDispatcher(APPRENTI_HOME_PAGE).forward(request, response);
            }
        }



    }

    public UtilisateurEntity getUtilisateur(HttpServletRequest request){
        UtilisateurEntity unUtilisateur = new UtilisateurEntity();
        unUtilisateur.setEmail(request.getParameter(EMAIL));
        unUtilisateur.setPassword(request.getParameter(PASSWORD));
        return unUtilisateur;
    }

    public boolean verifyRoleOfUser(String email){
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

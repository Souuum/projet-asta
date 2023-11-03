package fr.efrei2023.projetasta.service;

import fr.efrei2023.projetasta.dto.ApprentiInfoDTO;
import fr.efrei2023.projetasta.mapper.ApprentiInfoMapper;
import fr.efrei2023.projetasta.model.Entity.*;
import fr.efrei2023.projetasta.model.SB.*;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import fr.efrei2023.projetasta.service.UserService.*;

import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;

@Stateless
public class TuteurService {
    @EJB
    private TuteurEnseignantSB tuteurEnseignantSessionBean;
    @EJB
    private ApprentiSB apprentiSessionBean;
    @EJB
    private UtilisateurSB utilisateurSessionBean;
    @EJB
    private EntrepriseSB entrepriseSessionBean;
    @EJB
    private MaitreApprentissageSB maitreApprentissageSessionBean;
    @EJB
    private UserService userService;
    private ApprentiInfoMapper apprentiInfoMapper = new ApprentiInfoMapper();

    public TuteurEnseignantEntity getTuteurByUserId(int id){
        return tuteurEnseignantSessionBean.getByUserId(id);
    }
    public void creationProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UtilisateurEntity unUtilisateur = userService.getUtilisateurFromForm(request, TUTEUR_ROLE);

        if(userService.verifyIfUserExistByEmail(unUtilisateur.getEmail())){
            request.setAttribute("messageErreur",EMAIL_EXIST_ERROR_MESSAGE);
            request.getRequestDispatcher(TUTEUR_REGISTER_PAGE).forward(request, response);
        }else{
            TuteurEnseignantEntity unTuteur = getTuteurFromForm(request);

            userService.createUser(unUtilisateur);
            unTuteur.setUtilisateur(userService.getUtilisateurByEmail(unUtilisateur.getEmail()));
            createTuteur(unTuteur);
            request.getSession().setAttribute("user", unUtilisateur);
            request.getRequestDispatcher(TUTEUR_HOME_PAGE).forward(request, response);
        }
    }

    public void getListeApprentisNotFromTuteur(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ApprentiEntity> apprentiList = getListeApprentisNotAssignedToTuteur();
        List<UtilisateurEntity> utilisateurList = getListeUtilisateursNotAssignedToTuteur();
        List<ApprentiInfoDTO> apprentiInfoDTOList = apprentiInfoMapper.toApprentiInfoDTOList(apprentiList, utilisateurList);
        request.setAttribute("listeApprentis", apprentiInfoDTOList);
    }

    public void assignerApprenti(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String apprentiId = request.getParameter("numeroEtudiant");
        String tuteurId = request.getParameter("tuteurId");
        int numeroEtudiant = Integer.parseInt(apprentiId);
        int idTuteur = Integer.parseInt(tuteurId);
        ApprentiEntity apprenti = apprentiSessionBean.getById(numeroEtudiant);
        TuteurEnseignantEntity tuteur = tuteurEnseignantSessionBean.getById(idTuteur);
        apprenti.setTuteurEnseignant(tuteur);
        apprentiSessionBean.update(apprenti);
    }

    public List<ApprentiEntity> getListeApprentisFromTuteur(int id) {
        List<ApprentiEntity> listeApprentis = apprentiSessionBean.getAllFromTuteur(id);
        return listeApprentis;
    }
    public List<UtilisateurEntity> getListeUtilisateurFromTuteur(int id) {
        List<UtilisateurEntity> listeUtilisateurs = utilisateurSessionBean.getAll();
        return listeUtilisateurs;
    }

    public List<ApprentiEntity> getListeApprentisNotAssignedToTuteur() {
        List<ApprentiEntity> listeApprentis = apprentiSessionBean.getAllNotAssignedToTuteur();
        return listeApprentis;
    }

    public List<UtilisateurEntity> getListeUtilisateursNotAssignedToTuteur() {
        List<UtilisateurEntity> listeUtilisateurs = utilisateurSessionBean.getAll();
        return listeUtilisateurs;
    }

    public void getListeApprentis(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ApprentiEntity> listeApprentis = apprentiSessionBean.getAll();
        request.setAttribute("listeApprentis",listeApprentis);
    }

    public void getListeEntreprises(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<EntrepriseEntity> listeEntreprises = entrepriseSessionBean.getAll();
        request.setAttribute("listeEntreprises",listeEntreprises);
    }

    public void getListeMaitresApprentissage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<MaitreApprentissageEntity> listeMaitresApprentissage = maitreApprentissageSessionBean.getAll();
        request.setAttribute("listeMaitresApprentissage",listeMaitresApprentissage);
    }

    //TODO
    public ApprentiEntity assignApprentiToCurrentTuteur(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ApprentiEntity unApprenti = new ApprentiEntity();
        return unApprenti;
    }

    public TuteurEnseignantEntity getTuteurFromForm(HttpServletRequest request) {
        TuteurEnseignantEntity unTuteur = new TuteurEnseignantEntity();

        return unTuteur;
    }

    public void createTuteur(TuteurEnseignantEntity unTuteur){
        tuteurEnseignantSessionBean.add(unTuteur);
    }
}

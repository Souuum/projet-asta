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
import java.nio.file.FileSystemNotFoundException;
import java.sql.Date;
import java.util.List;

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
    @EJB
    private VisiteSB visiteSessionBean;
    @EJB
    private MemoireSB memoireSessionBean;
    @EJB
    private SoutenanceSB soutenanceSessionBean;
    @EJB
    private MissionSB missionSessionBean;
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

    public void modifierApprenti(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String numeroEtudiant = request.getParameter("currentApprentiNumeroEtudiant");

        // Apprenti info, mission info and maitre apprentissage info
        String programme = request.getParameter("programme");
        String majeure = request.getParameter("majeure");
        String anneeAcademique = request.getParameter("anneeAcademique");
        String metierCible = request.getParameter("metierCible");
        String motsCles = request.getParameter("motsCles");
        String commentaires_mission = request.getParameter("commentaires_mission");
        String currentMaitreApprentissageId = request.getParameter("currentMaitreApprentissageId");

        ApprentiEntity apprenti = apprentiSessionBean.getByNumeroEtudiant(numeroEtudiant);
        apprenti.setProgramme(programme);
        apprenti.setMajeure(majeure);
        apprenti.setAnneeAcademique(anneeAcademique);

        // Mission
        MissionEntity mission = apprenti.getMission();
        if (mission == null) {
            mission = new MissionEntity();
            mission.setMotsCles(motsCles);
            mission.setMetierCible(metierCible);
            mission.setCommentaires(commentaires_mission);
            missionSessionBean.add(mission);
        }
        else {
            mission.setMotsCles(motsCles);
            mission.setMetierCible(metierCible);
            mission.setCommentaires(commentaires_mission);
            missionSessionBean.update(mission);
        }
        apprenti.setMission(mission);

        // Maitre apprentissage
        MaitreApprentissageEntity maitreApprentissage = maitreApprentissageSessionBean.getById(Integer.parseInt(currentMaitreApprentissageId));
        apprenti.setMaitreApprentissage(maitreApprentissage);

        apprentiSessionBean.update(apprenti);


        // Visite
        String dateVisite = request.getParameter("dateVisite");
        String format = request.getParameter("format");
        String compteRenduExpress = request.getParameter("compteRenduExpress");

        VisiteEntity visite = visiteSessionBean.getByNumeroEtudiant(numeroEtudiant);
        if(visite == null){
            visite = new VisiteEntity();
            visite.setDateVisite(Date.valueOf(dateVisite));
            visite.setFormat(format);
            visite.setCompteRenduExpress(compteRenduExpress);
            visite.setNumeroEtudiant(numeroEtudiant);
            visite.setTuteurEnseignant(apprenti.getTuteurEnseignant());
            visiteSessionBean.add(visite);
        }else{
            visite.setDateVisite(Date.valueOf(dateVisite));
            visite.setFormat(format);
            visite.setCompteRenduExpress(compteRenduExpress);
            visite.setTuteurEnseignant(apprenti.getTuteurEnseignant());
            visiteSessionBean.update(visite);
        }

        // Memoire
        //TODO

        // Soutenance
        //TODO
    }

    public void getListeApprentiInfoFromTuteur(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TuteurEnseignantEntity currentTuteur = getTuteurByUserId(((UtilisateurEntity) request.getSession().getAttribute("user")).getIdUtilisateur());
        List<ApprentiEntity> apprentiList = getListeApprentisFromTuteur(currentTuteur.getIdTuteurEnseignant());
        List<UtilisateurEntity> utilisateurList = getListeUtilisateurFromTuteur(currentTuteur.getIdTuteurEnseignant());
        List<ApprentiInfoDTO> apprentiInfoDTOList = apprentiInfoMapper.toApprentiInfoDTOList(apprentiList, utilisateurList);
        request.getSession().setAttribute("apprentiListDTO", apprentiInfoDTOList);
    }

    public void getListeApprentisNotFromTuteur(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ApprentiEntity> apprentiList = getListeApprentisNotAssignedToTuteur();
        List<UtilisateurEntity> utilisateurList = getListeUtilisateursNotAssignedToTuteur();
        List<ApprentiInfoDTO> apprentiInfoDTOList = apprentiInfoMapper.toApprentiInfoDTOList(apprentiList, utilisateurList);
        request.getSession().setAttribute("listeApprentis", apprentiInfoDTOList);
    }

    public void assignerApprenti(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String numeroEtudiant = request.getParameter("numeroEtudiant");
        String utilisateurId = request.getParameter("idUtilisateur");
        TuteurEnseignantEntity currentTuteur = getTuteurByUserId(Integer.parseInt(utilisateurId));
        ApprentiEntity apprenti = apprentiSessionBean.getById(numeroEtudiant);
        apprenti.setTuteurEnseignant(currentTuteur);
        apprentiSessionBean.update(apprenti);
    }
    //TODO
    public void modifierApprentiPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String numeroEtudiant = request.getParameter("currentApprentiNumeroEtudiant." + request.getParameter("itemIndex"));
        ApprentiEntity apprenti = apprentiSessionBean.getByNumeroEtudiant(numeroEtudiant);
        UtilisateurEntity utilisateur = utilisateurSessionBean.getById(apprenti.getIdUtilisateur());
        ApprentiInfoDTO apprentiInfoDTO = apprentiInfoMapper.toApprentiInfoDTO(apprenti, utilisateur);
        MissionEntity mission = apprentiInfoDTO.getMission();
        request.getSession().setAttribute("mission", mission);
        request.getSession().setAttribute("apprenti", apprentiInfoDTO);
        VisiteEntity visite = visiteSessionBean.getByNumeroEtudiant(numeroEtudiant);
        request.getSession().setAttribute("visite", visite);
        //MemoireEntity memoire = memoireSessionBean.getByNumeroEtudiant(numeroEtudiant);
        //request.getSession().setAttribute("memoire", memoire);
        //SoutenanceEntity soutenance = soutenanceSessionBean.getByNumeroEtudiant(numeroEtudiant);
        //request.getSession().setAttribute("soutenance", soutenance);
    }
    public void modifierMaitreApprentissagePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String IdMaitreApprentissage = request.getParameter("currentMaitreApprentissageId." + request.getParameter("itemIndex"));
        MaitreApprentissageEntity maitreApprentissage = maitreApprentissageSessionBean.getById(Integer.parseInt(IdMaitreApprentissage));
        request.getSession().setAttribute("maitreApprentissage", maitreApprentissage);
        List<EntrepriseEntity> entrepriseList = getListeEntreprises(request, response);
        request.getSession().setAttribute("entrepriseList", entrepriseList);

    }
    public void modifierMaitreApprentissage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String IdMaitreApprentissage = request.getParameter("currentMaitreApprentissageId");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String entrepriseId = request.getParameter("currentEntrepriseId");

        System.out.println("ENTREPRISEID" + entrepriseId);
        MaitreApprentissageEntity maitreApprentissage = new MaitreApprentissageEntity();
        maitreApprentissage.setIdMaitreApprentissage(Integer.parseInt(IdMaitreApprentissage));
        maitreApprentissage.setNom(nom);
        maitreApprentissage.setPrenom(prenom);
        maitreApprentissage.setemail(email);
        maitreApprentissage.setTelephone(telephone);
        maitreApprentissage.setEntreprise(entrepriseSessionBean.getById(Integer.parseInt(entrepriseId)));
        maitreApprentissageSessionBean.update(maitreApprentissage);
    }
    public void modifierEntreprisePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String IdEntreprise = request.getParameter("currentEntrepriseId." + request.getParameter("itemIndex"));
        EntrepriseEntity entreprise = entrepriseSessionBean.getById(Integer.parseInt(IdEntreprise));
        request.setAttribute("entreprise", entreprise);
    }

    public void modifierEntreprise(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String IdEntreprise = request.getParameter("currentEntrepriseId");
        String raisonSociale = request.getParameter("raisonSociale");
        String adresse = request.getParameter("adresse");
        String informations = request.getParameter("informations");

        System.out.println("IDENTREPRISE" + IdEntreprise);
        System.out.println("RAISONSOCIALE" + raisonSociale);
        System.out.println("ADRESSE" + adresse);
        System.out.println("INFORMATIONS" + informations);

        EntrepriseEntity entreprise = new EntrepriseEntity();
        entreprise.setIdEntreprise(Integer.parseInt(IdEntreprise));
        entreprise.setRaisonSociale(raisonSociale);
        entreprise.setAdresse(adresse);
        entreprise.setInformations(informations);
        entrepriseSessionBean.update(entreprise);
    }

    public void addMaitreApprentissage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String entrepriseId = request.getParameter("currentEntrepriseId");

        //TODO Check if same email already exist

        MaitreApprentissageEntity maitreApprentissage = new MaitreApprentissageEntity();
        maitreApprentissage.setNom(nom);
        maitreApprentissage.setPrenom(prenom);
        maitreApprentissage.setemail(email);
        maitreApprentissage.setTelephone(telephone);
        maitreApprentissage.setEntreprise(entrepriseSessionBean.getById(Integer.parseInt(entrepriseId)));
        maitreApprentissageSessionBean.add(maitreApprentissage);
    }
    public void addEntreprise(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String raisonSociale = request.getParameter("raisonSociale");
        String adresse = request.getParameter("adresse");
        String informations = request.getParameter("informations");

        //TODO Check if same raison Sociale already exist

        EntrepriseEntity entreprise = new EntrepriseEntity();
        entreprise.setRaisonSociale(raisonSociale);
        entreprise.setAdresse(adresse);
        entreprise.setInformations(informations);
        entrepriseSessionBean.add(entreprise);
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

    public List<EntrepriseEntity> getListeEntreprises(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<EntrepriseEntity> listeEntreprises = entrepriseSessionBean.getAll();
        return listeEntreprises;
    }

    public List<MaitreApprentissageEntity> getListeMaitresApprentissage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<MaitreApprentissageEntity> listeMaitresApprentissage = maitreApprentissageSessionBean.getAll();
        return listeMaitresApprentissage;
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

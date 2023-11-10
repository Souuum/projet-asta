package fr.efrei2023.projetasta.service;

import fr.efrei2023.projetasta.dto.ApprentiInfoDTO;
import fr.efrei2023.projetasta.dto.MemoireEvaluationDTO;
import fr.efrei2023.projetasta.dto.SoutenanceEvaluationDTO;
import fr.efrei2023.projetasta.mapper.ApprentiInfoMapper;
import fr.efrei2023.projetasta.model.Entity.*;
import fr.efrei2023.projetasta.model.SB.*;
import fr.efrei2023.projetasta.mapper.MemoireEvaluationMapper;
import fr.efrei2023.projetasta.mapper.SoutenanceEvaluationMapper;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.sql.Date;
import java.util.List;

import static fr.efrei2023.projetasta.utils.EntrepriseConstants.*;
import static fr.efrei2023.projetasta.utils.TuteurEnseignantConstants.*;
import static fr.efrei2023.projetasta.utils.UtilisateurConstants.*;
import static fr.efrei2023.projetasta.utils.EvaluationEcoleConstants.*;

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
    @EJB
    private EvaluationEcoleSB evaluationEcoleEntitySessionBean;
    private ApprentiInfoMapper apprentiInfoMapper = new ApprentiInfoMapper();
    private MemoireEvaluationMapper memoireEvaluationMapper = new MemoireEvaluationMapper();
    private SoutenanceEvaluationMapper soutenanceEvaluationMapper = new SoutenanceEvaluationMapper();

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

    public void assignerApprenti(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String numeroEtudiant = request.getParameter("numeroEtudiant");
        String utilisateurId = request.getParameter("idUtilisateur");
        TuteurEnseignantEntity currentTuteur = getTuteurByUserId(Integer.parseInt(utilisateurId));
        ApprentiEntity apprenti = apprentiSessionBean.getById(numeroEtudiant);
        apprenti.setTuteurEnseignant(currentTuteur);
        apprentiSessionBean.update(apprenti);

        getListeApprentiInfoFromTuteur(request, response);
    }
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

        EvaluationEcoleEntity memoireEval = evaluationEcoleEntitySessionBean.getByNumeroEtudiantAndType(numeroEtudiant, MEMOIRE);
        if(memoireEval == null){
            request.getSession().setAttribute("memoire", null);
        }
        else{
            MemoireEntity memoire = memoireSessionBean.getByEvaluationEcoleId(memoireEval.getIdEvaluationEcole());
            MemoireEvaluationDTO memoireEvaluationDTO = memoireEvaluationMapper.toMemoireEvaluationDTO(memoireEval, memoire);
            request.getSession().setAttribute("memoire", memoireEvaluationDTO);
        }
        EvaluationEcoleEntity soutenanceEval = evaluationEcoleEntitySessionBean.getByNumeroEtudiantAndType(numeroEtudiant, SOUTENANCE);
        if(soutenanceEval == null){
            request.getSession().setAttribute("soutenance", null);
        }
        else{
            SoutenanceEntity soutenance = soutenanceSessionBean.getByEvaluationEcoleId(soutenanceEval.getIdEvaluationEcole());
            SoutenanceEvaluationDTO soutenanceEvaluationDTO = soutenanceEvaluationMapper.toSoutenanceEvaluationDTO(soutenanceEval, soutenance);
            request.getSession().setAttribute("soutenance", soutenanceEvaluationDTO);
        }
    }
    public void modifierApprenti(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            String numeroEtudiant = request.getParameter("currentApprentiNumeroEtudiant");
            ApprentiEntity apprenti = apprentiSessionBean.getByNumeroEtudiant(numeroEtudiant);
            // Apprenti info, mission info and maitre apprentissage info
            modifyApprentiInfo(request, response, apprenti);
            // Mission
            createOrModifyMission(request, response, apprenti);
            // Maitre apprentissage
            assignMaitreApprentissageToApprenti(request, response, apprenti);
            // Visite
            createOrModifyVisite(request, response, numeroEtudiant, apprenti);
            // Memoire
            createOrModifyMemoire(request, response, numeroEtudiant);
            // Soutenance
            createOrModifySoutenance(request, response, numeroEtudiant);
            request.setAttribute("message", "Apprenti modifié avec succès");
            request.setAttribute("color", "green");
            getListeApprentiInfoFromTuteur(request, response);
        }
        catch (Exception e){
            request.setAttribute("message", "Une erreur est survenue");
            request.setAttribute("color", "red");
            request.getRequestDispatcher(MODIFIER_APPRENTI_PAGE).forward(request, response);
        }



    }

    // MAITRE APPRENTISSAGE PART

    public void addMaitreApprentissage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String entrepriseId = request.getParameter("currentEntrepriseId");

        if(maitreApprentissageSessionBean.getByEmail(email) != null){
            request.setAttribute("messageErreur", EMAIL_EXIST_ERROR_MESSAGE);
            request.getRequestDispatcher(AJOUTER_MAITRE_APPRENTISSAGE_PAGE).forward(request, response);
        }

        MaitreApprentissageEntity maitreApprentissage = new MaitreApprentissageEntity();
        maitreApprentissage.setNom(nom);
        maitreApprentissage.setPrenom(prenom);
        maitreApprentissage.setemail(email);
        maitreApprentissage.setTelephone(telephone);
        maitreApprentissage.setEntreprise(entrepriseSessionBean.getById(Integer.parseInt(entrepriseId)));
        maitreApprentissageSessionBean.add(maitreApprentissage);

        List<MaitreApprentissageEntity> maitreApprentissageList = getListeMaitresApprentissage(request, response);
        request.getSession().setAttribute("maitreApprentissageList", maitreApprentissageList);
    }
    public void modifierMaitreApprentissagePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String IdMaitreApprentissage = request.getParameter("currentMaitreApprentissageId." + request.getParameter("itemIndex"));
        MaitreApprentissageEntity maitreApprentissage = maitreApprentissageSessionBean.getById(Integer.parseInt(IdMaitreApprentissage));
        request.getSession().setAttribute("maitreApprentissage", maitreApprentissage);
        getListeEntreprises(request, response);
    }

    public void modifierMaitreApprentissage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
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

            List<MaitreApprentissageEntity> maitreApprentissageList = getListeMaitresApprentissage(request, response);
            request.setAttribute("message", "Maitre apprentissage modifié avec succès");
            request.setAttribute("color", "green");
            request.getSession().setAttribute("maitreApprentissageList", maitreApprentissageList);

        } catch (Exception e){
            request.setAttribute("message", "Une erreur est survenue");
            request.setAttribute("color", "red");
            request.getRequestDispatcher(MODIFIER_MAITRE_APPRENTISSAGE_PAGE).forward(request, response);
        }


    }

    // ENTREPRISE PART

    public void addEntreprise(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String raisonSociale = request.getParameter("raisonSociale");
        String adresse = request.getParameter("adresse");
        String informations = request.getParameter("informations");

        if(entrepriseSessionBean.getByRaisonSociale(raisonSociale) != null){
            request.setAttribute("messageErreur", RAISON_SOCIALE_EXIST_ERROR_MESSAGE);
            request.getRequestDispatcher(AJOUTER_ENTREPRISE_PAGE).forward(request, response);
        }

        EntrepriseEntity entreprise = new EntrepriseEntity();
        entreprise.setRaisonSociale(raisonSociale);
        entreprise.setAdresse(adresse);
        entreprise.setInformations(informations);
        entrepriseSessionBean.add(entreprise);

        getListeEntreprises(request, response);
    }
    public void modifierEntreprisePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String IdEntreprise = request.getParameter("currentEntrepriseId." + request.getParameter("itemIndex"));
        EntrepriseEntity entreprise = entrepriseSessionBean.getById(Integer.parseInt(IdEntreprise));
        request.setAttribute("entreprise", entreprise);
    }

    public void modifierEntreprise(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
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

            request.setAttribute("message", "Entreprise modifiée avec succès");
            request.setAttribute("color", "green");
            getListeEntreprises(request, response);
        } catch (Exception e){
            request.setAttribute("message", "Une erreur est survenue");
            request.setAttribute("color", "red");
            request.getRequestDispatcher(MODIFIER_ENTREPRISE_PAGE).forward(request, response);
        }


    }

    //CREATE or MODIFY METHODS
    public void createTuteur(TuteurEnseignantEntity unTuteur){
        tuteurEnseignantSessionBean.add(unTuteur);
    }
    public void modifyApprentiInfo(HttpServletRequest request, HttpServletResponse response, ApprentiEntity apprenti) throws IOException, ServletException {
        String programme = request.getParameter("programme");
        String majeure = request.getParameter("majeure");
        String anneeAcademique = request.getParameter("anneeAcademique");

        apprenti.setProgramme(programme);
        apprenti.setMajeure(majeure);
        apprenti.setAnneeAcademique(anneeAcademique);

        apprentiSessionBean.update(apprenti);
    }
    public void createOrModifyMission(HttpServletRequest request, HttpServletResponse response, ApprentiEntity apprenti) throws IOException, ServletException{
        String metierCible = request.getParameter("metierCible");
        String motsCles = request.getParameter("motsCles");
        String commentaires_mission = request.getParameter("commentaires_mission");

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
    }
    public void assignMaitreApprentissageToApprenti(HttpServletRequest request, HttpServletResponse response, ApprentiEntity apprenti)throws  IOException, ServletException{
        String currentMaitreApprentissageId = request.getParameter("currentMaitreApprentissageId");
        MaitreApprentissageEntity maitreApprentissage = maitreApprentissageSessionBean.getById(Integer.parseInt(currentMaitreApprentissageId));
        apprenti.setMaitreApprentissage(maitreApprentissage);

        apprentiSessionBean.update(apprenti);
    }
    public void createOrModifyVisite(HttpServletRequest request, HttpServletResponse response, String numeroEtudiant, ApprentiEntity apprenti) throws  IOException, ServletException{
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
    }
    public void createOrModifyMemoire(HttpServletRequest request, HttpServletResponse response, String numeroEtudiant) throws IOException, ServletException{
        String theme = request.getParameter("theme");
        String noteFinaleMemoire = request.getParameter("note_finale_memoire");
        String commentairesMemoire = request.getParameter("commentaires_memoire");

        EvaluationEcoleEntity memoireEval = evaluationEcoleEntitySessionBean.getByNumeroEtudiantAndType(numeroEtudiant, MEMOIRE);
        if(memoireEval == null){
            memoireEval = new EvaluationEcoleEntity();
            memoireEval.setType(MEMOIRE);
            memoireEval.setNumeroEtudiant(numeroEtudiant);
            memoireEval.setNoteFinale(noteFinaleMemoire);
            memoireEval.setCommentaires(commentairesMemoire);
            evaluationEcoleEntitySessionBean.add(memoireEval);
            MemoireEntity memoire = new MemoireEntity();
            memoire.setTheme(theme);
            memoire.setEvaluationEcole(memoireEval);
            memoireSessionBean.add(memoire);
        }
        else {
            memoireEval.setNoteFinale(noteFinaleMemoire);
            memoireEval.setCommentaires(commentairesMemoire);
            evaluationEcoleEntitySessionBean.update(memoireEval);
            MemoireEntity memoire = memoireSessionBean.getByEvaluationEcoleId(memoireEval.getIdEvaluationEcole());
            memoire.setTheme(theme);
            memoireSessionBean.update(memoire);
        }
    }
    public void createOrModifySoutenance(HttpServletRequest request, HttpServletResponse response, String numeroEtudiant) throws IOException, ServletException {
        String dateSoutenance = request.getParameter("dateSoutenance");
        String noteFinaleSoutenance = request.getParameter("note_finale_soutenance");
        String commentairesSoutenance = request.getParameter("commentaires_soutenance");

        EvaluationEcoleEntity soutenanceEvaluation = evaluationEcoleEntitySessionBean.getByNumeroEtudiantAndType(numeroEtudiant, SOUTENANCE);

        if(soutenanceEvaluation == null){
            soutenanceEvaluation = new EvaluationEcoleEntity();
            soutenanceEvaluation.setType(SOUTENANCE);
            soutenanceEvaluation.setNumeroEtudiant(numeroEtudiant);
            soutenanceEvaluation.setNoteFinale(noteFinaleSoutenance);
            soutenanceEvaluation.setCommentaires(commentairesSoutenance);
            evaluationEcoleEntitySessionBean.add(soutenanceEvaluation);
            SoutenanceEntity soutenance = new SoutenanceEntity();
            soutenance.setDateSoutenance(Date.valueOf(dateSoutenance));
            soutenance.setEvaluationEcole(soutenanceEvaluation);
            soutenanceSessionBean.add(soutenance);
        }
        else{
            soutenanceEvaluation.setNoteFinale(noteFinaleSoutenance);
            soutenanceEvaluation.setCommentaires(commentairesSoutenance);
            evaluationEcoleEntitySessionBean.update(soutenanceEvaluation);
            SoutenanceEntity soutenance = soutenanceSessionBean.getByEvaluationEcoleId(soutenanceEvaluation.getIdEvaluationEcole());
            soutenance.setDateSoutenance(Date.valueOf(dateSoutenance));
            soutenanceSessionBean.update(soutenance);
        }
    }


    //GET METHODS
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
        request.getSession().setAttribute("entrepriseList", listeEntreprises);
    }
    public List<MaitreApprentissageEntity> getListeMaitresApprentissage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<MaitreApprentissageEntity> listeMaitresApprentissage = maitreApprentissageSessionBean.getAll();
        return listeMaitresApprentissage;
    }
    public TuteurEnseignantEntity getTuteurFromForm(HttpServletRequest request) {
        TuteurEnseignantEntity unTuteur = new TuteurEnseignantEntity();

        return unTuteur;
    }

}

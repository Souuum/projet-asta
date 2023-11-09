package fr.efrei2023.projetasta.utils;

public class TuteurEnseignantConstants {
    // GENERIC FIELD NAMES
    public static final boolean TUTEUR_ROLE = true;

    // Action Names
    public static final String ACTION = "action";
    public static final String ACTION_SIGNUP = "SignUp";
    public static final String ACTION_ADD_APPRENTI = "+ Ajouter Apprenti";
    public static final String ACTION_ADD_MAITRE_APPRENTISSAGE = "+ Ajouter Maitre Apprentissage";
    public static final String ACTION_ADD_ENTREPRISE = "+ Ajouter Entreprise";
    public static final String ACTION_AJOUTER_MAITRE_APPRENTISSAGE = "AjouterMaitreApprentissage";
    public static final String ACTION_AJOUTER_ENTREPRISE = "AjouterEntreprise";
    public static final String ACTION_ASSIGNER_APPRENTI = "AssignerApprenti";
    public static final String ACTION_MODIFIER_APPRENTI = "ModifierApprenti";
    public static final String ACTION_MODIFIER_MAITRE_APPRENTISSAGE = "ModifierMaitreApprentissage";
    public static final String ACTION_MODIFIER_ENTREPRISE = "ModifierEntreprise";
    public static final String ACTION_MODIFIER_APPRENTI_PAGE = "ModifierApprentiPage";
    public static final String ACTION_MODIFIER_MAITRE_APPRENTISSAGE_PAGE = "ModifierMaitreApprentissagePage";
    public static final String ACTION_MODIFIER_ENTREPRISE_PAGE = "ModifierEntreprisePage";



    // JSP PAGES
    public static final String TUTEUR_REGISTER_PAGE = "/WEB-INF/tuteur_page/tuteur-register.jsp";
    public static final String TUTEUR_LIST_PAGE = "/WEB-INF/tuteur_page/tuteur-list.jsp";
    public static final String TUTEUR_HOME_PAGE = "/WEB-INF/tuteur_page/tuteur-home.jsp";
    public static final String ASSIGNER_APPRENTI_PAGE = "/WEB-INF/tuteur_page/ajouter-etudiant-page.jsp";
    public static final String AJOUTER_MAITRE_APPRENTISSAGE_PAGE = "/WEB-INF/tuteur_page/ajouter-maitre-app.jsp";
    public static final String AJOUTER_ENTREPRISE_PAGE = "/WEB-INF/tuteur_page/ajouter-entreprise.jsp";
    public static final String MODIFIER_APPRENTI_PAGE = "/WEB-INF/tuteur_page/edit-apprenti.jsp";
    public static final String MODIFIER_MAITRE_APPRENTISSAGE_PAGE = "/WEB-INF/tuteur_page/edit-maitre-apprenti.jsp";
    public static final String MODIFIER_ENTREPRISE_PAGE = "/WEB-INF/tuteur_page/edit-entreprise.jsp";


    // ERROR MESSAGES
    public static final String ENTITY_ERROR_MESSAGE = "Tuteur non trouvé";

    // SQL REQUESTS
    public static final String SELECT_ALL_TUTEURS = "SELECT t FROM TuteurEnseignantEntity t";
    public static final String SELECT_TUTEUR_BY_ID = "SELECT t FROM TuteurEnseignantEntity t WHERE t.idTuteurEnseignant = :id";

    public static final String FIND_TUTEUR_BY_USER_ID = "SELECT t FROM TuteurEnseignantEntity t WHERE t.utilisateur.idUtilisateur = :id";
}

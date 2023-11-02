package fr.efrei2023.projetasta.utils;

public class UtilisateurConstants {


    // GENERIC FIELD NAMES
    public static final String ID_UTILISATEUR = "idUtilisateur";
    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String TELEPHONE = "telephone";
    public static final String ISADMIN = "isAdmin";
    public static final String UPDATED_AT = "updatedAt";
    public static final String CREATED_AT = "createdAt";

    // ERROR MESSAGES
    public static final String ENTITY_ERROR_MESSAGE = "Utilisateur non trouvé";
    public static final String EMAIL_EXIST_ERROR_MESSAGE = "Cette email est déjà utilisée";

    public static final String EMAIL_NOT_EXIST_ERROR_MESSAGE = "Cette email n'existe pas";

    public static final String PASSWORD_ERROR_MESSAGE = "Mot de passe incorrect";


    // SQL REQUESTS

    public static final String SELECT_ALL_UTILISATEURS = "SELECT u FROM UtilisateurEntity u";
    public static final String SELECT_UTILISATEUR_BY_ID = "SELECT u FROM UtilisateurEntity u WHERE u.idUtilisateur = :id";
    public static final String SELECT_UTILISATEUR_BY_EMAIL = "SELECT u FROM UtilisateurEntity u WHERE u.email = :email";
    public static final String FIND_ALL_UTILISATEURS_FROM_TUTEUR = "SELECT u FROM UtilisateurEntity u WHERE u.tuteurEnseignant.idTuteurEnseignant = :id";


    // JSP

    public static final String LOGIN_PAGE = "/WEB-INF/login.jsp";

}

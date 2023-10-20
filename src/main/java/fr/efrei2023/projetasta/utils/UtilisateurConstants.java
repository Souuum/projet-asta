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


    // SQL REQUESTS

    public static final String SELECT_ALL_UTILISATEURS = "SELECT u FROM UtilisateurEntity u";
    public static final String SELECT_UTILISATEUR_BY_ID = "SELECT u FROM UtilisateurEntity u WHERE u.idUtilisateur = :id";
    public static final String SELECT_UTILISATEUR_BY_EMAIL = "SELECT u FROM UtilisateurEntity u WHERE u.email = :email";


    // JSP

    public static final String LOGIN_PAGE = "login.jsp";

}

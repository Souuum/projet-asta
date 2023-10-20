package fr.efrei2023.projetasta.utils;

public class ApprentiConstants {

    // QUERIES

    public static final String FIND_ALL_APPRENTIS = "SELECT a FROM ApprentiEntity a";

    public static final String FIND_APPRENTI_BY_ID = "SELECT a FROM ApprentiEntity a WHERE a.idApprenti = :idApprenti";
    public static final String FIND_APPRENTI_BY_NUMERO_ETUDIANT = "SELECT a FROM ApprentiEntity a WHERE a.numeroEtudiant = :numeroEtudiant";

    // GENERIC FIELD NAMES

    public static final String ID_APPRENTI = "idApprenti";
    public static final String NUMERO_ETUDIANT = "numeroEtudiant";
    public static final String PROGRAMME = "programme";
    public static final String ANNEE_ACADEMIQUE = "anneeAcademique";
    public static final String MAJEURE = "majeure";
    public static final boolean APPRENTI_ROLE = false;
    public static final boolean IS_NOT_ARCHIVED = false;
    public static final String FEEDBACK = "feedback";

    // JSP PAGES

    public static final String APPRENTI_REGISTER_PAGE = "/WEB-INF/apprenti_register.jsp";
    public static final String APPRENTI_LIST_PAGE = "/WEB-INF/apprenti_list.jsp";
    public static final String APPRENTI_HOME_PAGE = "/WEB-INF/apprenti_home.jsp";


}

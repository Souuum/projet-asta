package fr.efrei2023.projetasta.utils;

public class MemoireConstants {

    //ERROR MESSAGES
    public static final String ENTITY_ERROR_MESSAGE = "Memoire non trouvée";

    //SQL REQUESTS
    public static final String SELECT_ALL_MEMOIRES = "SELECT m FROM MemoireEntity m";
    public static final String SELECT_MEMOIRE_BY_ID = "SELECT m FROM MemoireEntity m WHERE m.idMemoire = :id";
    public static final String SELECT_MEMOIRE_BY_NUMERO_ETUDIANT = "SELECT m FROM MemoireEntity m WHERE m.numeroEtudiant = :numeroEtudiant";

}

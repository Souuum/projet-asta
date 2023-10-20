package fr.efrei2023.projetasta.utils;

public class MaitreApprentissageConstants {

    //ERRORS MESSAGES
    public static final String ENTITY_ERROR_MESSAGE = "MaitreApprentissage non trouvé";

    //SQL REQUESTS
    public static final String SELECT_ALL_MAITREAPPRENTISSAGES = "SELECT m FROM MaitreApprentissageEntity m";
    public static final String SELECT_MAITREAPPRENTISSAGE_BY_ID = "SELECT m FROM MaitreApprentissageEntity m WHERE m.idMaitreApprentissage = :id";
}

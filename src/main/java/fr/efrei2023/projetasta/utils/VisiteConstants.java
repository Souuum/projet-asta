package fr.efrei2023.projetasta.utils;

public class VisiteConstants {

    // ERROR MESSAGES
    public static final String ENTITY_ERROR_MESSAGE = "Visite non trouvée";

    //SQL REQUESTS
    public static final String SELECT_ALL_VISITES = "SELECT v FROM VisiteEntity v";
    public static final String SELECT_VISITE_BY_ID = "SELECT v FROM VisiteEntity v WHERE v.idVisite = :id";
}

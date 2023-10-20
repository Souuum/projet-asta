package fr.efrei2023.projetasta.utils;

public class EntrepriseConstants {

    //ERRORS MESSAGES
    public static final String ENTITY_ERROR_MESSAGE = "Entreprise non trouvée";

    //SQL REQUESTS
    public static final String SELECT_ALL_ENTREPRISES = "SELECT e FROM EntrepriseEntity e";
    public static final String SELECT_ENTREPRISE_BY_ID = "SELECT e FROM EntrepriseEntity e WHERE e.idEntreprise = :id";
}

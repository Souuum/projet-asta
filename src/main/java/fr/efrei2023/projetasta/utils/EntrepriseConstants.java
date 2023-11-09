package fr.efrei2023.projetasta.utils;

public class EntrepriseConstants {

    //ERRORS MESSAGES
    public static final String ENTITY_ERROR_MESSAGE = "Entreprise non trouvée";
    public static final String RAISON_SOCIALE_EXIST_ERROR_MESSAGE = "Entreprise existe déjà";

    //SQL REQUESTS
    public static final String SELECT_ALL_ENTREPRISES = "SELECT e FROM EntrepriseEntity e";
    public static final String SELECT_ENTREPRISE_BY_ID = "SELECT e FROM EntrepriseEntity e WHERE e.idEntreprise = :id";
    public static final String SELECT_ENTREPRISE_BY_RAISON_SOCIALE = "SELECT e FROM EntrepriseEntity e WHERE e.raisonSociale = :raisonSociale";
}

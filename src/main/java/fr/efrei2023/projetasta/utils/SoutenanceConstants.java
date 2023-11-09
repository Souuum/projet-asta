package fr.efrei2023.projetasta.utils;

public class SoutenanceConstants {

    //ERROR MESSAGES
    public static final String ENTITY_ERROR_MESSAGE = "Soutenance non trouvée";

    //SQL REQUESTS
    public static final String SELECT_ALL_SOUTENANCES = "SELECT s FROM SoutenanceEntity s";
    public static final String SELECT_SOUTENANCE_BY_ID = "SELECT s FROM SoutenanceEntity s WHERE s.idSoutenance = :id";
    public static final String SELECT_SOUTENANCE_BY_EVALUATION_ECOLE_ID = "SELECT s FROM SoutenanceEntity s WHERE s.evaluationEcole.idEvaluationEcole = :id";
}

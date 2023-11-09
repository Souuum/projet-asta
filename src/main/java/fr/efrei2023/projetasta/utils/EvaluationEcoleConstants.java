package fr.efrei2023.projetasta.utils;

public class EvaluationEcoleConstants {

    //ERRORS MESSAGES
    public static final String ENTITY_ERROR_MESSAGE = "EvaluationEcole non trouvé";

    //SQL REQUESTS
    public static final String SELECT_ALL_EVALUATIONECOLES = "SELECT e FROM EvaluationEcoleEntity e";
    public static final String SELECT_EVALUATIONECOLE_BY_ID = "SELECT e FROM EvaluationEcoleEntity e WHERE e.idEvaluationEcole = :id";
    public static final String SELECT_EVALUATIONECOLE_BY_NUMERO_ETUDIANT_AND_TYPE = "SELECT e FROM EvaluationEcoleEntity e WHERE e.numeroEtudiant = :numeroEtudiant AND e.type = :type";

    public static final String MEMOIRE = "memoire";
    public static final String SOUTENANCE = "soutenance";
}

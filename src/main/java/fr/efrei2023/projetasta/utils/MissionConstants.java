package fr.efrei2023.projetasta.utils;

public class MissionConstants {

    //ERROR MESSAGES
    public static final String ENTITY_ERROR_MESSAGE = "Mission non trouvée";

    //SQL REQUESTS
    public static final String SELECT_ALL_MISSIONS = "SELECT m FROM MissionEntity m";
    public static final String SELECT_MISSION_BY_ID = "SELECT m FROM MissionEntity m WHERE m.idMission = :id";
}

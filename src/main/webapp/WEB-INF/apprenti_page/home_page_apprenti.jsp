<%--
  Created by IntelliJ IDEA.
  User: soum
  Date: 06/10/2023
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Apprenti</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        .hover_button:hover {
            background-color: #b497de;
        }

        .hover_button {
            background-color: #9166CC;
        }
    </style>
</head>
<body class="bg-dark text-light">

<header style="background-color: #2A2E35" class="d-flex flex-row justify-content-around">
    <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

    </div>
    <div style="border-radius: 5px" class="p-2 my-auto hover_button">
        <form method="POST" action="user-controller" name="LogoutForm">

            <button title="logout" type="submit" name="action" value="logout" class="bg-transparent border-0">
                <i class="bi bi-box-arrow-left"></i>
            </button>
        </form>

    </div>
</header>

<div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center overflow-hidden">

    <div class="d-flex flex-column justify-content-center align-items-center">

        <div class="w-100 m-2 d-flex">
            <h2 style="margin-right: auto">Bonjour <span style="color: #9166CC">${user.prenom} ${user.nom}</span></h2>
        </div>

        <c:if test="${not empty message}">
            <p style="color: ${color}">${message}</p>
        </c:if>

        <div style="height: 75%; border-radius: 20px; background-color: #2A2E35"
             class="w-100 p-4 justify-content-center align-items-center overflow-auto">

            <div class="m-3">
                <h3 style="margin-right: auto">Apprenti</h3>

                <div style="border-radius: 20px; background-color: #454E56"
                     class="p-2 flex-row d-flex justify-content-center align-items-center">
                    <form method="POST" action="apprenti-controller" name="editApprentiForm">

                        <label for="numeroEtudiant"></label>
                        <input type="text" id="numEtudiant" name="numeroEtudiant" value="${apprenti.numeroEtudiant}" hidden>
                        <p>Numero Etudiant: ${apprenti.numeroEtudiant}</p>

                        <div class="m-3 d-flex flex-column">
                            <div>
                                ${user.prenom} ${user.nom}
                            </div>
                            <div>
                                <input class="rounded-pill input-group" style="border-color: #9166CC" type="text" id="email" name="email" value="${user.email}">
                            </div>
                        </div>
                        <div class="m-3 d-flex flex-column">
                            <div style="color: #9166CC">Numero de telephone</div>
                            <div>
                                <input class="rounded-pill input-group" style="border-color: #9166CC" type="text" id="telephone" name="telephone" value="${user.telephone}">
                            </div>
                        </div>
                        <div class="m-3">
                            <button style="color: #9166CC" class="border-0 bg-transparent btn-link" type="submit" name="action" value="editSelfData">Editer
                            </button>
                        </div>
                        <div class="m-3 d-flex flex-column">
                            <div style="color: #9166CC">Majeure</div>
                            <div>${apprenti.majeure}</div>
                        </div>
                        <div class="m-3 d-flex flex-column">
                            <div style="color: #9166CC">Année</div>
                            <div>${apprenti.anneeAcademique}</div>
                        </div>

                    </form>
                </div>
            </div>


            <div style="border-radius: 20px; background-color: #2A2E35"
                 class="flex-row d-flex justify-content-between align-items-center m-3">
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Entreprise</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <c:choose>
                            <c:when test="${apprenti.maitreApprentissage.entreprise!=null}">
                                <div><span style="color: #9166CC">Raison Sociale:</span> ${apprenti.maitreApprentissage.entreprise.raisonSociale}</div>
                                <div><span style="color: #9166CC">Addresse:</span> ${apprenti.maitreApprentissage.entreprise.adresse}</div>
                                <div><span style="color: #9166CC">Informations utiles pour les locaux:</span> ${apprenti.maitreApprentissage.entreprise.informations}</div>
                            </c:when>
                            <c:otherwise>
                                pas d'entreprise
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Missions</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <c:choose>
                            <c:when test="${apprenti.mission!=null}">
                                <div>
                                    <span style="color: #9166CC">Mots-clés:</span> ${apprenti.mission.motsCles}
                                </div>
                                <div>
                                    <span style="color: #9166CC">Métier cible:</span> ${apprenti.mission.metierCible}
                                </div>
                                <div>
                                    <span style="color: #9166CC">Commentaires:</span> ${apprenti.mission.commentaires}
                                </div>
                            </c:when>
                            <c:otherwise>
                                pas de mission
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>

            <div class="m-3">
                <h3 style="margin-right: auto">Maitre d'apprentissage</h3>
                <div style="border-radius: 20px; background-color: #454E56"
                     class="p-2 flex-row d-flex justify-content-center align-items-center">
                    <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

                    </div>

                    <div class="d-flex flex-column">
                        <div class="d-flex flex-row">
                            <c:choose>
                                <c:when test="${apprenti.maitreApprentissage!=null}">
                                    <div class="m-3 d-flex flex-column">
                                        <div>
                                                ${apprenti.maitreApprentissage.prenom} ${apprenti.maitreApprentissage.nom}
                                        </div>
                                        <div>
                                                ${apprenti.maitreApprentissage.email}
                                        </div>
                                    </div>
                                    <div class="m-3 d-flex flex-column">
                                        <div style="color: #9166CC">Numero de telephone</div>
                                        <div>${apprenti.maitreApprentissage.telephone}</div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    pas de maitre d'apprentissage
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </div>
                </div>

            </div>


            <div style="border-radius: 20px; background-color: #2A2E35"
                 class="flex-row d-flex justify-content-between align-items-center m-3">
                <div class="align-self-stretch flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Remarques</h3><br>
                    <div style="height: 100%; border-radius: 20px; background-color: #454E56" class=" p-2 flex-column d-flex">
                        <form method="POST" action="apprenti-controller" name="editFeedbackForm">
                            <label for="numeroEtudiant"></label>
                            <input type="text" id="numeroEtudiant" name="numeroEtudiant" value="${apprenti.numeroEtudiant}" hidden>
                            <c:choose>
                                <c:when test="${apprenti.feedback!=null}">
                                    <div>
                                        <span style="color: #9166CC">Remarques:</span>
                                        <input class="rounded-pill input-group" style="border-color: #9166CC" type="text" id="feedback" name="feedback" value="${apprenti.feedback}">

                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div>
                                        <input type="text" id="feedbacks" name="feedback" value="${apprenti.feedback}">
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            <br>
                            <button type="submit" name="action" style="border: none; color: white; background-color: #9166CC" value="editFeedback" class="btn-link btn btn-primary">Editer</button>
                        </form>
                    </div>

                </div>
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Visite</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <c:choose>
                            <c:when test="${visite!=null}">
                                <div>
                                    <span style="color: #9166CC">Date:</span> ${visite.dateVisite}
                                </div>
                                <div>
                                    <span style="color: #9166CC">Format:</span> ${visite.format}
                                </div>
                                <div>
                                    <span style="color: #9166CC">Compte-Rendu Express:</span> ${visite.compteRenduExpress}
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div>
                                    pas de visite
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>


            <div style="border-radius: 20px; background-color: #2A2E35"
                 class="flex-row d-flex justify-content-between align-items-center m-3">
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Mémoire/Rapport</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <c:choose>
                            <c:when test="${memoire!=null}">
                                <div>
                                    <span style="color: #9166CC">Theme:</span> ${memoire.theme}
                                </div>
                                <div>
                                    <span style="color: #9166CC">Note:</span> ${memoire.noteFinale}/20
                                </div>
                                <div>
                                    <span style="color: #9166CC">Commentaires:</span> ${memoire.commentaires}
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div>
                                    Non rendu
                                </div>

                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Soutenance</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <c:choose>
                            <c:when test="${soutenance!=null}">
                                <div>
                                    <span style="color: #9166CC">Date:</span> ${soutenance.dateSoutenance}
                                </div>
                                <div>
                                    <span style="color: #9166CC">Note finale:</span> ${soutenance.noteFinale}/20
                                </div>
                                <div>
                                    <span style="color: #9166CC">Commentaires:</span> ${soutenance.commentaires}
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div>
                                    Non actée
                                </div>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

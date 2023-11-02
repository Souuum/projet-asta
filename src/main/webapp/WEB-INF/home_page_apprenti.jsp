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
    <title>Login Apprenti</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .hover_color{
            background-color: #9166CC;
        }
        .hover_color:hover{
            background-color: #bd93f3;
        }
    </style>
</head>
<body class="bg-dark text-light overflow-hidden">

<header class="d-flex flex-row justify-content-around position-relative" style="background-color: #2A2E35">
    <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

    </div>
    <div style="border-radius: 5px" class="hover_color my-auto">
        <button class="p-2 border-0 bg-transparent">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                 class="bi bi-box-arrow-left" viewBox="0 0 16 16">
                <path fill-rule="evenodd"
                      d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"></path>
                <path fill-rule="evenodd"
                      d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"></path>
            </svg>
        </button>
    </div>
</header>

<div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">

    <div class="d-flex flex-column justify-content-center align-items-center">

        <div class="w-100 m-2 d-flex">
            <h2 style="margin-right: auto">Bonjour <span style="color: #9166CC">${user.prenom} ${user.nom}</span></h2>
        </div>


        <div style="height: 75%; border-radius: 20px; background-color: #2A2E35"
             class="w-100 p-4 justify-content-center align-items-center overflow-auto">

            <div class="m-3">
                <h3 style="margin-right: auto">Apprenti</h3>

                <div style="border-radius: 20px; background-color: #454E56"
                     class="p-2 flex-row d-flex justify-content-center align-items-center">
                    <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

                    </div>
                    <div class="m-3 d-flex flex-column">
                        <div>
                            ${user.prenom} ${user.nom}
                        </div>
                        <div>
                            ${user.email}
                        </div>
                    </div>
                    <div class="m-3 d-flex flex-column">
                        <div style="color: #9166CC">Numero de telephone</div>
                        <div>${user.telephone}</div>
                    </div>
                    <div class="m-3 d-flex flex-column">
                        <div style="color: #9166CC">Majeure</div>
                        <div>${apprenti.majeure}</div>
                    </div>
                    <div class="m-3 d-flex flex-column">
                        <div style="color: #9166CC">Année</div>
                        <div>${apprenti.anneeAcademique}</div>
                    </div>
                    <div class="m-3">
                        <button style="color: #9166CC" class="border-0 bg-transparent btn-link" type="button">Editer
                        </button>
                    </div>

                </div>
            </div>


            <div style="border-radius: 20px; background-color: #2A2E35"
                 class="flex-row d-flex justify-content-between align-items-center m-3">
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Entreprise</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <c:choose>
                            <c:when test="${apprenti.maitreApprentissage.entreprise!=null}">
                                <div><span
                                        style="color: #9166CC">Raison Sociale:</span> ${apprenti.maitreApprentissage.entreprise.raisonSociale}
                                </div>
                                <div><span
                                        style="color: #9166CC">Addresse:</span> ${apprenti.maitreApprentissage.entreprise.adresse}
                                </div>
                                <div><span
                                        style="color: #9166CC">Informations utiles pour les locaux:</span> ${apprenti.maitreApprentissage.entreprise.informations}
                                </div>
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
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Remarque</div>
                            <div>pas de remarque</div>
                        </div>
                    </div>
                </div>

            </div>


            <div style="border-radius: 20px; background-color: #2A2E35"
                 class="flex-row d-flex justify-content-between align-items-center m-3">
                <div class="align-self-stretch flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Remarques</h3>
                    <div style="height: 100%; border-radius: 20px; background-color: #454E56"
                         class=" p-2 flex-column d-flex">
                        <c:choose>
                            <c:when test="${apprenti.remarques!=null}">
                                <div>
                                    <span style="color: #9166CC">Date:</span> ${apprenti.remarques.date}
                                </div>
                                <div>
                                    <span style="color: #9166CC">Remarques:</span> ${apprenti.remarques.remarques}
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div>
                                    pas de remarques
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Visite</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <c:choose>
                            <c:when test="${visites!=null}">
                                <c:forEach items="${visites}" var="visite">
                                    <div>
                                        <span style="color: #9166CC">Date:</span> ${visites.date}
                                    </div>
                                    <div>
                                        <span style="color: #9166CC">Format:</span> ${visites.format}
                                    </div>
                                    <div>
                                        <span style="color: #9166CC">Compte-Rendu Express:</span> ${visites.compteRenduExpress}
                                    </div>
                                </c:forEach>
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
                            <c:when test="${apprenti.memoire!=null}">
                                <div>
                                    <span style="color: #9166CC">Date:</span> ${apprenti.memoire.date}
                                </div>
                                <div>
                                    <span style="color: #9166CC">Note:</span> ${apprenti.memoire.note}/20
                                </div>
                                <div>
                                    <span style="color: #9166CC">Commentaires:</span> ${apprenti.memoire.commentaires}
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
                            <c:when test="${apprenti.soutenance!=null}">
                                <div>
                                    <span style="color: #9166CC">Date:</span> ${apprenti.soutenance.date}
                                </div>
                                <div>
                                    <span style="color: #9166CC">Note finale:</span> ${apprenti.soutenance.noteFinale}/20
                                </div>
                                <div>
                                    <span style="color: #9166CC">Commentaires:</span> ${apprenti.soutenance.commentaires}
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

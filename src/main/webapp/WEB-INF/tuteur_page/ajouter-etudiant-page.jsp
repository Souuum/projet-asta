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
    <title>Ajouter Apprenti</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .hover_button:hover {
            background-color: #b497de;
        }

        .hover_button {
            background-color: #9166CC;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

</head>
<body class="bg-dark text-light ">

<header style="background-color: #2A2E35" class="d-flex flex-row justify-content-around">
    <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

    </div>
    <form action ="user-controller" method="post" name="LogoutForm" class="my-auto">
        <div style="border-radius: 5px" class="p-2 my-auto hover_button">
            <button title="logout" class="bg-transparent border-0" name="action" type="submit" value="logout">
                <i class="bi bi-box-arrow-left"></i>
            </button>
        </div>
    </form>
</header>


<div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">

    <div class="d-flex flex-column justify-content-center align-items-center">

        <form id="AddApprentiForm" action="tuteur-controller" method="post">
            <div class="w-100 m-2 d-flex justify-content-start">
                <h2 style="margin-right: auto">Bonjour <span style="color: #9166CC">${user.prenom} ${user.nom}</span></h2>
            </div>


            <div style="border-radius: 20px; background-color: #2A2E35"
                 class="w-100 p-4 flex-column d-flex justify-content-center align-items-center">

                <c:forEach items="${listeApprentis}" var="apprenti">
                    <div style="border-radius: 20px; background-color: #454E56"
                         class="p-2 m-3 flex-row d-flex justify-content-center align-items-center">
                        <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

                        </div>
                        <div class="m-3 d-flex flex-column">
                            <div>
                                    ${apprenti.prenom} ${apprenti.nom}
                            </div>
                            <div>
                                    ${apprenti.email}
                            </div>
                        </div>
                        <div class="m-3 d-flex flex-column">
                            <div style="color: #9166CC">Numero de telephone</div>
                            <div>${apprenti.telephone}</div>
                        </div>
                        <div class="m-3 d-flex flex-column">
                            <div style="color: #9166CC">Majeure</div>
                            <div>${apprenti.majeure}</div>
                        </div>
                        <div class="m-3 d-flex flex-column">
                            <div style="color: #9166CC">Programme</div>
                            <div class="_myprogramme"><span>${apprenti.programme}</span></div>
                        </div>
                        <div class="m-3 d-flex flex-column">
                            <div style="color: #9166CC">Année</div>
                            <div>${apprenti.anneeAcademique}</div>
                        </div>
                        <input type="hidden" name="numeroEtudiant" value="${apprenti.numeroEtudiant}"/>
                        <input type="hidden" name="idUtilisateur" value="${user.idUtilisateur}"/>
                        <div class="m-3">
                            <button class="btn border-0 btn-primary" style="background-color: #9166CC; margin-left: auto" type="submit"
                                    name="action" value="AssignerApprenti">+ Ajouter</button>
                        </div>

                    </div>
                </c:forEach>
                <div style="border-radius: 20px; background-color: #454E56"
                     class="p-2 m-3 flex-row d-flex justify-content-center align-items-center">
                    <div style="background-color: #9166CC" class="p-3 rounded-circle m-3">
                    </div>
                    <div class="d-flex flex-column m-3">
                        <div>
                            Gilbert Ziade
                        </div>
                        <div>
                            gilbert_z2001@hotmail.com
                        </div>
                    </div>
                    <div class="d-flex flex-column m-3">
                        <div style="color: #9166CC">Numero de telephone</div>
                        <div>+33 7 85 76 41 77</div>
                    </div>
                    <div class="d-flex flex-column m-3">
                        <div style="color: #9166CC">Majeure</div>
                        <div>LSI</div>
                    </div>
                    <div class="d-flex flex-column m-3">
                        <div style="color: #9166CC">Année</div>
                        <div>2022-2025</div>
                    </div>
                    <div class="m-3">
                        <button style="color: #9166CC" class="border-0 bg-transparent btn-link" type="button">Editer
                        </button>
                    </div>

                </div>

            </div>
        </form>

    </div>
</div>

</body>
</html>

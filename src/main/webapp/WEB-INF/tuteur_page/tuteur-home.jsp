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
        .hover_button:hover {
            background-color: #b497de;
        }

        .hover_button {
            background-color: #9166CC;
        }
    </style>
</head>
<body class="bg-dark text-light overflow-hidden">

<header style="background-color: #2A2E35" class="d-flex flex-row justify-content-around">
    <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

    </div>
    <div style="border-radius: 5px" class="p-2 my-auto hover_button">
        <button title="logout" class="bg-transparent border-0">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"></path>
                <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"></path>
            </svg>
        </button>
    </div>
</header>


<div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">

    <div class="d-flex flex-column justify-content-center align-items-center">

        <div class="w-100 m-2 d-flex justify-content-between">
            <h2 style="margin-right: auto">Bonjour <span style="color: #9166CC">${user.prenom} ${user.nom}</span></h2>
            <input class="btn border-0 btn-primary" style="background-color: #9166CC; margin-left: auto" type="button"
                   value="+ Ajouter">
        </div>


        <div style="border-radius: 20px; background-color: #2A2E35"
             class="w-100 p-4 flex-column d-flex justify-content-center align-items-center">

            <c:forEach items="${apprentiListDTO}" var="apprenti">
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
                        <div style="color: #9166CC">Année</div>
                        <div>${apprenti.anneeAcademique}</div>
                    </div>
                    <div class="m-3">
                        <button style="color: #9166CC" class="border-0 bg-transparent btn-link" type="button">Editer
                        </button>
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
    </div>
</div>

</body>
</html>

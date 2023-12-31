<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/4/2023
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Entreprise</title>
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
<body class="bg-dark text-light">

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
<!--overlay Entreprise-->
<div class="overlay" id="Eoverlay">

    <div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">
        <div class="h2">Modification de <span style="color: #9166CC">${entreprise.raisonSociale}</span></div>
        <br>
        <c:if test="${not empty message}">
            <p style="color: ${color}">${message}</p>
        </c:if>
        <form class="flex-column d-flex justify-content-center align-content-center"
              style="width: 50%" action="tuteur-controller" method="post">

            <div style="width: 40%; margin: auto">
                <input type="hidden" name="currentEntrepriseId" value="${entreprise.idEntreprise}">
                <div class="form-group">
                    <label for="Enom">RAISON SOCIALE</label>
                    <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="Enom"
                           name="raisonSociale" required pattern=".*" value="${entreprise.raisonSociale}">
                </div>

                <div class="form-group">
                    <label for="Eemail">ADRESSE</label>
                    <input style="border-color: #9166CC" type="text" class="rounded-pill form-control"
                           id="Eemail"
                           name="adresse" value="${entreprise.adresse}">
                </div>

                <div class="form-group">
                    <label for="Einformation">INFORMATIONS</label>
                    <textarea placeholder="Ecrire des informations supplementaire..." class="form-control"
                              style="resize: none ;border-radius: 20px; border-color: #9166CC" type="text"
                              id="Einformation" name="informations">${entreprise.informations}</textarea>
                </div>
            </div>

            <button type="submit" style="width: 30%; background-color: #9166CC" name="action" value="ModifierEntreprise"
                    class="text-light mx-auto rounded-pill align-content-center btn border-0">Modifier
            </button>
        </form>
    </div>

</div>
</body>
</html>

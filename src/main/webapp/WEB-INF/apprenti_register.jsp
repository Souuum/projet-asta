<%--
  Created by IntelliJ IDEA.
  User: soum
  Date: 06/10/2023
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Apprenti</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-dark text-light">

<div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">
    <div class="h2">Créee votre compte en tant qu'<span style="color: #9166CC">apprenti</span></div>
    <br>
    <form class="flex-column d-flex justify-content-center align-content-center" id="registrationForm" style="width: 50%" action="apprenti-controller" method="post">
        <div class="d-flex flex-row">

            <div class="d-flex flex-column" style="width: 40%; margin: 5%">

                <div class="form-group">
                    <label for="numeroEtudiant">NUMERO ETUDIANT</label>
                    <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="numeroEtudiant" name="numeroEtudiant"
                           required pattern=".*">
                    <div class="invalid-feedback">Inserrer un numero d'etudiant valable.</div>

                </div>
                <div class="form-group">
                    <label for="nom">NOM</label>
                    <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="nom" name="nom" required pattern=".*">
                    <div class="invalid-feedback">Inserrer un nom valide.</div>
                </div>
                <div class="form-group">
                    <label for="prenom">PRENOM</label>
                    <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="prenom" name="prenom" required
                           pattern=".*">
                    <div class="invalid-feedback">Inserrer un prenom valide.</div>
                </div>
                <div class="form-group">
                    <label for="telephone">TELEPHONE</label>
                    <input style="border-color: #9166CC" type="tel" class="rounded-pill form-control" id="telephone" name="telephone" required
                           pattern="^\d{10}$">
                    <div class="invalid-feedback">Inserrer un numero de telephone de 10 chiffre.</div>
                </div>

            </div>
            <div class="d-flex flex-column" style="width: 40%; margin: 5%">

                <div class="form-group">
                    <label for="email">EMAIL</label>
                    <input style="border-color: #9166CC" type="email" class="rounded-pill form-control" id="email" name="email" required>
                    <div class="invalid-feedback">Inserrer un Email valide.</div>
                </div>
                <div class="form-group">
                    <label for="password">MOT DE PASSE</label>
                    <input style="border-color: #9166CC" type="password" class="rounded-pill form-control" id="password" name="password" required
                           <%--pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"> --%>
                    <div class="invalid-feedback">Inserrer un mot de pass valide.</div>
                </div>
                <div class="form-group">
                    <label for="anneeAcademique">ANNEE ACADEMIQUE</label>
                    <input style="border-color: #9166CC" type="number" class="rounded-pill form-control" id="anneeAcademique" name="year" min="2000"
                           max="2050" step="1" required>
                    <div class="invalid-feedback">Inserrer une annee academique entre 2000 et 2050.</div>
                </div>
                <div class="form-group">
                    <label for="majeure">MAJEURE</label><br>
                    <select style="width: 100%; border-color: #9166CC" id="majeure" name="majeure" class="rounded-pill form-select form-select-lg mb-3">
                        <option value="majeur_1" selected> Majeur 1</option>
                        <option value="majeur_2"> Majeur 2</option>
                        <option value="majeur_3"> Majeur 3</option>
                    </select>
                </div>

            </div>
        </div>

        <button id="btnn" type="submit" style="width: 30%; background-color: #9166CC" name="action" value="SignUp" class="text-light mx-auto rounded-pill align-content-center btn border-0">S'inscrire</button>
    </form>
</div>

<script>
    document.getElementById('btnn').addEventListener('click', function (event) {
        var inputs = document.getElementsByTagName('input');
        for (var i = 0; i < inputs.length; i++) {
            var pattern = new RegExp(inputs[i].getAttribute('pattern'))
            if (!inputs[i].value || !pattern.test(inputs[i].value)) {
                inputs[i].classList.add('is-invalid');
            } else {
                inputs[i].classList.remove('is-invalid');
            }

        }
    });
</script>
</body>
</html>

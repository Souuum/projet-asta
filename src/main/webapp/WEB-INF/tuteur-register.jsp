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
</head>
<body style="background-color: #dedede">

<div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">
    <div class="h2">Créee votre compte en tant que tutor</div>
    <br>
    <form id="registrationForm" style="width: 25%" action ="apprenti-controller">
        <div class="form-group">
            <label for="IdTuteur">ID TUTEUR</label>
            <input type="text" class="border-primary form-control" id="IdTuteur" name="IdTuteur" required pattern=".*">
            <div class="invalid-feedback">Inserrer un ID de Tuteur valable.</div>
        </div>
        <div class="form-group">
            <label for="nom">NOM</label>
            <input type="text" class="border-primary form-control" id="nom" name="nom" required pattern=".*">
            <div class="invalid-feedback">Inserrer un nom valide.</div>
        </div>
        <div class="form-group">
            <label for="prenom">PRENOM</label>
            <input type="text" class="border-primary form-control" id="prenom" name="prenom" required pattern=".*">
            <div class="invalid-feedback">Inserrer un prenom valide.</div>
        </div>
        <div class="form-group">
            <label for="telephone">TELEPHONE</label>
            <input type="tel" class="border-primary form-control" id="telephone" name="telephone" required pattern="^\d{10}$">
            <div class="invalid-feedback">Inserrer un numero de telephone de 10 chiffres.</div>
        </div>
        <div class="form-group">
            <label for="email">EMAIL</label>
            <input type="email" class="border-primary form-control" id="email" name="email" required pattern=".*">
            <div class="invalid-feedback">Inserrer un Email valide.</div>
        </div>
        <div class="form-group">
            <label for="password">MOT DE PASSE</label>
            <input type="password" class="border-primary form-control" id="password" name="password" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$">
            <div class="invalid-feedback">au minimum 8 characters: une majuscule, une minuscule et un chiffre.</div>
        </div>
        <button id="btnn" type="submit" name="action" value="SignUp" class="btn btn-primary">S'inscrire</button>
    </form>
</div>

<script>
    document.getElementById('btnn').addEventListener('click', function(event) {
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

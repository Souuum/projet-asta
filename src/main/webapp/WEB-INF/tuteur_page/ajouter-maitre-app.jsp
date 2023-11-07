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
    <title>cree maitre d'apprentie</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-dark text-light">

<div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">
    <div class="h2">Créee votre compte en tant que <span style="color: #9166CC">tuteur</span></div>
    <br>
    <form class="flex-column d-flex justify-content-center align-content-center" id="registrationForm" style="width: 25%" action ="tuteur-controller">
        <div class="form-group">

        </div>
        <div class="form-group">
            <label for="nom">NOM</label>
            <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="nom" name="nom" required pattern=".*">
            <div class="invalid-feedback">Inserrer un nom valide.</div>
        </div>
        <div class="form-group">
            <label for="prenom">PRENOM</label>
            <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="prenom" name="prenom" required pattern=".*">
            <div class="invalid-feedback">Inserrer un prenom valide.</div>
        </div>
        <div class="form-group">
            <label for="telephone">TELEPHONE</label>
            <input style="border-color: #9166CC" type="tel" class="rounded-pill form-control" id="telephone" name="telephone" required pattern="^\d{10}$">
            <div class="invalid-feedback">Inserrer un numero de telephone de 10 chiffres.</div>
        </div>
        <div class="form-group">
            <label for="email">EMAIL</label>
            <input style="border-color: #9166CC" type="email" class="rounded-pill form-control" id="email" name="email" required pattern=".*">
            <div class="invalid-feedback">Inserrer un Email valide.</div>
        </div>
        <div class="form-group">
            <label for="entreprise">ENTREPRISE</label><br>
            <select style="width: 100%; border-color: #9166CC" id="entreprise" name="entreprise"
                    class="rounded-pill form-select form-select-lg mb-3">
                <option value="entreprise_1" selected> entreprise 1</option>
                <option value="entreprise_3"> entreprise 3</option>
                <option value="entreprise_2"> entreprise 2</option>
            </select>
        </div>
        <button id="btn" type="submit" style="width: 35%; background-color: #9166CC" name="action" value="SignUp" class="text-light mx-auto rounded-pill btn border-0">S'inscrire</button>
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

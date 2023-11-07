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
    <title>cree entreprise</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-dark text-light">

<div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">
    <div class="h2">Créee une <span style="color: #9166CC">entreprise</span></div>
    <br>
    <form class="flex-column d-flex justify-content-center align-content-center" id="registrationForm" style="width: 25%" action ="tuteur-controller">
        <div class="form-group">

        </div>
        <div class="form-group">
            <label for="raisonSociale">raisonSociale</label>
            <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="raisonSociale" name="raisonSociale" required pattern=".*">
            <div class="invalid-feedback">Inserrer une raisonSociale valide.</div>
        </div>
        <div class="form-group">
            <label for="adresse">adresse</label>
            <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="adresse" name="adresse" required pattern=".*">
            <div class="invalid-feedback">Inserrer une addresse valide.</div>
        </div>
        <div class="form-group">
            <label for="info">informations</label>
            <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="info" name="info" required pattern=".*">
            <div class="invalid-feedback">inserrer des information valide.</div>
        </div>
        <button id="btn" type="submit" style="width: 35%; background-color: #9166CC" name="action" value="add" class="text-light mx-auto rounded-pill btn border-0">Ajouter</button>
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

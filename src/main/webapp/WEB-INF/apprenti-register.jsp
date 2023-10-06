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
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<div class="container">
    <div class="row col-md-6 col-md-offset-0 custyle">

    <form action ="apprenti-controller">
        <div class="form-group">
            <label for="numeroEtudiant">NUMERO ETUDIANT</label>
            <input type="text" class="form-control" id="numeroEtudiant" name="numeroEtudiant" required>
        </div>
        <div class="form-group">
            <label for="nom">NOM</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        <div class="form-group">
            <label for="prenom">PRENOM</label>
            <input type="text" class="form-control" id="prenom" name="prenom" required>
        </div>
        <div class="form-group">
            <label for="telephone">TEL DOMICILE</label>
            <input type="tel" class="form-control" id="telephone" name="telephone" required>
        </div>
        <div class="form-group">
            <label for="email">EMAIL</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="anneeAcademique">ANNEE ACADEMIQUE</label>
            <input type="text" class="form-control" id="anneeAcademique" name="anneeAcademique" required>
        </div>
        <div class="form-group">
            <label for="majeure">MAJEURE</label>
            <input type="text" class="form-control" id="majeure" name="majeure" required>
        </div>
        <button type="submit" name="action" value="SignUp" class="btn btn-primary">S'inscrire</button>
    </form>
    </div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Thomas SONG
  Date: 28/09/2023
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
<div class="bg-dark vh-100">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <form class="mt-5" id="loginForm" action="user-controller" method="post">
                    <h2 class="mb-4 text-white">Se connecter</h2>
                    <div class="mb-3">
                        <label for="email" class="form-label text-white">Email</label>
                        <input type="text" class="form-control" id="email" name="email" placeholder="Entrer votre email">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label text-white">Mot de passe</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Entrer votre mot de passe">
                    </div>
                    <button type="submit" class="btn btn-primary" name="action" value="login">Login</button>
                    <button type="button" class="btn btn-primary" id="createAccountBtn">Create Account</button>
                </form>
                <form class="mt-5" id="registerFrm" style="display: none">
                    <h2 class="mb-4 text-white">Créer un compte</h2>
                    <button type="button" class="btn btn-primary" name="action" value="createApprenti">Compte Étudiant</button>
                    <button type="button" class="btn btn-primary" name="action" value="createTuteur">Compte Professeur</button>
                    <button type="button" class="btn btn-secondary" id="returnBtn">Retour</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        $("#createAccountBtn").click(function() {
            $("#loginFrm").toggle();
            $("#registerFrm").toggle();
        });
        $("#returnBtn").click(function() {
            $("#registerFrm").toggle();
            $("#loginFrm").toggle();
        });
    });
</script>
</body>
</html>
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
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://github.com/twbs/bootstrap/blob/344e912d04b5b6a04482113eff20ab416ff01048/site/assets/scss/_buttons.scss">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
<div class="bg-dark vh-100 d-flex justify-content-center align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4 rounded" style="background-color: #2A2E35;">
                <form class="mt-5" id="loginForm" action="user-controller" method="post">
                    <div class="mb-4 text-center">
                        <h2 class="mb-0 text-white">Bienvenue !</h2>
                        <p class="text-secondary">Se connecter pour continuer</p>
                    </div>

                    <c:if test="${not empty messageErreur}">
                        <p style="color: red">${messageErreur}</p>
                    </c:if>

                    <div class="mb-3">
                        <label for="email" class="form-label text-white">Adresse mail</label>
                        <input type="text" class="form-control" id="email" name="email" placeholder="Entrer votre mail">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label text-white">Mot de passe</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Entrer votre mot de passe">
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-info" name="action" value="login"
                                style="background-color: #8a2be2; border-color: #8a2be2;"
                                onmouseover="this.style.backgroundColor='#9166CC'; this.style.borderColor='#9166CC';"
                                onmouseout="this.style.backgroundColor='#8a2be2'; this.style.borderColor='#8a2be2';">
                            Se connecter
                        </button>
                        <div class="d-flex align-items-center">
                            <p class="m-0 small text-secondary ml-4">Vous n'avez pas de compte ?</p>
                            <button type="button" class="btn btn-link" id="createAccountBtn" style="color: #8a2be2;">Créer un compte.</button>
                        </div>
                    </div>
                </form>
                <form class="mt-3 mb-4" id="registerForm" style="display: none" action="user-controller" method="post">
                    <button type="button" class="mb-3 btn btn-secondary" id="returnBtn">
                        <i class="bi bi-arrow-left" style="font-size: 18px;"></i>
                    </button>
                    <h1 class="mb-4 text-white">Créer un compte</h1>
                    <h6 class="mb-4 text-white">Qui êtes vous ?</h6>
                    <div class="mb-3 text-center">
                            <button type="submit" class="btn btn-secondary" style="background-color: #8a2be2; border-color: #8a2be2;" name="action" value="registerApprenti"
                                    onmouseover="this.style.backgroundColor='#9166CC'; this.style.borderColor='#9166CC';"
                                    onmouseout="this.style.backgroundColor='#8a2be2'; this.style.borderColor='#8a2be2';">
                                Je suis étudiant<br>
                                <i class="bi bi-backpack4" style="font-size: 64px;"></i>
                            </button>
                            <button type="submit" class="btn btn-secondary" style="background-color: #8a2be2; border-color: #8a2be2;" name="action" value="registerTuteur"
                                    onmouseover="this.style.backgroundColor='#9166CC'; this.style.borderColor='#9166CC';"
                                    onmouseout="this.style.backgroundColor='#8a2be2'; this.style.borderColor='#8a2be2';">
                                Je suis professeur<br>
                                <i class="bi bi-easel2" style="font-size: 64px;"></i>
                            </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        $("#createAccountBtn").click(function() {
            $("#loginForm").toggle();
            $("#registerForm").toggle();
        });
        $("#returnBtn").click(function() {
            $("#registerForm").toggle();
            $("#loginForm").toggle();
        });
    });
</script>
</body>
</html>
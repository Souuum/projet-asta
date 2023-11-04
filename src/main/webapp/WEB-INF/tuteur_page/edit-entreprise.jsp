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
    <title>Title</title>
</head>
<body>
<!--overlay Entreprise-->
<div class="overlay" id="Eoverlay">

    <div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">
        <div class="h2">Modification de <span style="color: #9166CC">NOM PRENOM</span></div>
        <br>
        <form class="flex-column d-flex justify-content-center align-content-center"
              style="width: 50%" action="apprenti-controller" method="post">

            <div style="width: 40%; margin: auto">

                <div class="form-group">
                    <label for="Enom">RAISON SOCIALE</label>
                    <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="Enom"
                           name="nom" required pattern=".*" disabled>
                </div>
                <div class="form-group">
                    <label for="Etelephone">TELEPHONE</label>
                    <input style="border-color: #9166CC" type="tel" class="rounded-pill form-control"
                           id="Etelephone"
                           name="telephone" disabled>
                </div>

                <div class="form-group">
                    <label for="Eemail">EMAIL</label>
                    <input style="border-color: #9166CC" type="email" class="rounded-pill form-control"
                           id="Eemail"
                           name="email" disabled>
                </div>

                <div class="form-group">
                    <label for="Einformation">INFORMATION</label>
                    <textarea placeholder="Ecrire des information supplementaire..." class="form-control"
                              style="resize: none ;border-radius: 20px; border-color: #9166CC" type="text"
                              id="Einformation"></textarea>
                </div>
            </div>

            <button type="submit" style="width: 30%; background-color: #9166CC" name="action"
                    class="text-light mx-auto rounded-pill align-content-center btn border-0">Modifier
            </button>
        </form>
    </div>

</div>
</body>
</html>

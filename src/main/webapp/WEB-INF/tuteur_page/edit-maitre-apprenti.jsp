<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/4/2023
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Maitre Apprenti</title>
</head>
<body>
<!--overlay maitre d'apprenti-->
<div class="overlay" id="MAoverlay">

    <div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">
        <div class="h2">Modification de <span style="color: #9166CC">NOM PRENOM</span></div>
        <br>
        <form class="flex-column d-flex justify-content-center align-content-center"
              style="width: 50%" action="apprenti-controller" method="post">
            <div style="width: 40%; margin: auto">

                <div class="form-group">
                    <label for="MAnom">NOM</label>
                    <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="MAnom"
                           name="nom" required pattern=".*" disabled>
                </div>
                <div class="form-group">
                    <label for="MAprenom">PRENOM</label>
                    <input style="border-color: #9166CC" type="text" class="rounded-pill form-control"
                           id="MAprenom"
                           name="prenom" disabled>
                </div>
                <div class="form-group">
                    <label for="MAtelephone">TELEPHONE</label>
                    <input style="border-color: #9166CC" type="tel" class="rounded-pill form-control"
                           id="MAtelephone"
                           name="telephone" disabled>
                </div>

                <div class="form-group">
                    <label for="MAemail">EMAIL</label>
                    <input style="border-color: #9166CC" type="email" class="rounded-pill form-control"
                           id="MAemail"
                           name="email" disabled>
                </div>

                <div class="form-group">
                    <label for="MAentreprise">Entreprise</label><br>
                    <select style="width: 100%; border-color: #9166CC" id="MAentreprise" name="entreprise"
                            class="rounded-pill form-select form-select-lg mb-3">
                        <option value="entreprise_1" selected> entreprise 1</option>
                        <option value="entreprise_2"> entreprise 2</option>
                        <option value="entreprise_3"> entreprise 3</option>
                    </select>
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

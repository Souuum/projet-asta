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
    <title>Edit Apprenti</title>
</head>
<body>
<!--overlay apprenti-->
<div class="overlay" id="APoverlay">

    <div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">
        <div class="h2">Modification de <span style="color: #9166CC">NOM PRENOM</span></div>
        <br>
        <form class="flex-column d-flex justify-content-center align-content-center"
              style="width: 50%" action="apprenti-controller" method="post">
            <div class="d-flex flex-row">

                <div class="d-flex flex-column" style="width: 40%; margin: 5%">

                    <div class="form-group">
                        <label for="numeroEtudiant">NUMERO ETUDIANT</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control"
                               id="numeroEtudiant" name="numeroEtudiant" disabled>

                    </div>
                    <div class="form-group">
                        <label for="nom">NOM</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="nom"
                               name="nom" required pattern=".*" disabled>
                    </div>
                    <div class="form-group">
                        <label for="prenom">PRENOM</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control"
                               id="prenom"
                               name="prenom" disabled>
                    </div>
                    <div class="form-group">
                        <label for="telephone">TELEPHONE</label>
                        <input style="border-color: #9166CC" type="tel" class="rounded-pill form-control"
                               id="telephone"
                               name="telephone" disabled>
                    </div>

                    <div class="form-group">
                        <label for="entreprise">Entreprise</label><br>
                        <select style="width: 100%; border-color: #9166CC" id="entreprise" name="entreprise"
                                class="rounded-pill form-select form-select-lg mb-3">
                            <option value="entreprise_1" selected> entreprise 1</option>
                            <option value="entreprise_2"> entreprise 2</option>
                            <option value="entreprise_3"> entreprise 3</option>
                        </select>
                    </div>
                </div>
                <div class="d-flex flex-column" style="width: 40%; margin: 5%">

                    <div class="form-group">
                        <label for="email">EMAIL</label>
                        <input style="border-color: #9166CC" type="email" class="rounded-pill form-control"
                               id="email"
                               name="email" disabled>
                    </div>
                    <div class="form-group">
                        <label for="anneeAcademique">ANNEE ACADEMIQUE</label>
                        <input style="border-color: #9166CC" type="number" class="rounded-pill form-control"
                               id="anneeAcademique" name="year" min="2000"
                               max="2050" step="1" disabled required>
                    </div>
                    <div class="form-group">
                        <label for="majeure">MAJEURE</label><br>
                        <input type="text" class="rounded-pill form-control"
                               style="width: 100%; border-color: #9166CC" id="majeure" name="majeure" disabled>
                    </div>

                    <div class="form-group">
                        <label for="maitre_apprenti">Maitre d'apprentissage</label><br>
                        <select style="width: 100%; border-color: #9166CC" id="maitre_apprenti"
                                name="maitre_apprenti"
                                class="rounded-pill form-select form-select-lg mb-3">
                            <option value="maitre_1" selected> Maitre 1</option>
                            <option value="maitre_2"> Maitre 2</option>
                            <option value="maitre_3"> Maitre 3</option>
                        </select>
                    </div>
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

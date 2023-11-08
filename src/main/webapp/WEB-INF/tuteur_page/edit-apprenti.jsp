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

        <form class="flex-column d-flex justify-content-center align-content-center"
              style="width: 50%" action="tuteur-controller">
            <div class="h2">Modification de <span style="color: #9166CC">${apprenti.nom} ${apprenti.prenom}</span></div>
            <br>
            <div class="d-flex flex-row">
                <!-- APPRENTI INFOS -->
                <input hidden name="currentApprentiNumeroEtudiant" value="${apprenti.numeroEtudiant}">
                <div class="d-flex flex-column" style="width: 40%; margin: 5%">

                    <div class="form-group">
                        <label>APPRENTI INFO</label><br>
                    </div>
                    <div class="form-group">
                        <label for="programme">PROGRAMME</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control"
                               id="programme" name="programme" value="${apprenti.programme}">

                    </div>
                    <div class="form-group">
                        <label for="majeure">MAJEURE</label><br>
                        <input type="text" class="rounded-pill form-control"
                               style="width: 100%; border-color: #9166CC" id="majeure" name="majeure" value="${apprenti.majeure}">
                    </div>

                    <div class="form-group">
                        <label for="anneeAcademique">ANNEE ACADEMIQUE</label>
                        <input style="border-color: #9166CC" type="number" class="rounded-pill form-control"
                               id="anneeAcademique" name="anneeAcademique" min="2000"
                               max="2050" step="1"  value="${apprenti.anneeAcademique}">
                    </div>
                </div>
                <!-- MISSION -->
                <div class="d-flex flex-column" style="width: 40%; margin: 5%">
                    <div class="form-group">
                        <label>MISSION</label><br>
                    </div>
                    <div class="form-group">
                        <label for="metierCible">METIER CIBLE</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="metierCible"
                               name="metierCible" required pattern=".*" value="${mission.metierCible}">
                    </div>
                    <div class="form-group">
                        <label for="motsCles">MOTS CLES</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="motsCles"
                               name="motsCles" required pattern=".*" value="${mission.motsCles}">
                    </div>
                    <div class="form-group">
                        <label for="commentaires_mission">COMMENTAIRES</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="commentaires_mission"
                               name="commentaires_mission" required pattern=".*" value="${mission.commentaires}">
                    </div>
                </div>
                <!-- MAITRE APPRENTISSAGE -->
                <div class="d-flex flex-column" style="width: 40%; margin: 5%">


                    <div class="form-group">
                        <label for="maitre_apprenti">MAITRE D'APPRENTISSAGE</label><br>
                        <select style="width: 100%; border-color: #9166CC" id="maitre_apprenti"
                                name="currentMaitreApprentissageId"
                                class="rounded-pill form-select form-select-lg mb-3" value="${apprenti.maitreApprentissage.idMaitreApprentissage}">
                            <c:forEach items="${maitreApprentissageList}" var="maitreApprentissage">
                                <option value="${maitreApprentissage.idMaitreApprentissage}">${maitreApprentissage.prenom} ${maitreApprentissage.nom}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <!-- VISITE -->
                <div class="d-flex flex-column" style="width: 40%; margin: 5%">


                    <div class="form-group">
                        <label>VISITE</label><br>
                    </div>
                    <div class="form-group">
                        <label for="dateVisite">DATE</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="dateVisite"
                               name="dateVisite" required pattern=".*" value="${visite.dateVisite}">
                    </div>
                    <div class="form-group">
                        <label for="format">FORMAT</label>
                        <select style="width: 100%; border-color: #9166CC" id="format"
                                name="format"
                                class="rounded-pill form-select form-select-lg mb-3" value="${visite.format}">
                            <option value="Visio"> Visio </option>
                            <option value="Presentielle"> Presentielle </option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="compteRenduExpress">COMPTE RENDU EXPRESS</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="compteRenduExpress"
                               name="compteRenduExpress" required pattern=".*" value="${visite.compteRenduExpress}">
                    </div>
                </div>

                <!-- MEMOIRE -->
                <div class="d-flex flex-column" style="width: 40%; margin: 5%">


                    <div class="form-group">
                        <label>MEMOIRE</label><br>
                    </div>
                    <div class="form-group">
                        <label for="theme">THEME</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="theme"
                               name="theme" required pattern=".*" value="${memoire.theme}">
                    </div>
                    <div class="form-group">
                        <label for="note_finale_memoire">NOTE FINALE</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="note_finale_memoire"
                               name="note_finale_memoire" required pattern=".*" value="${memoire.evaluationEcole.noteFinale}">
                    </div>
                    <div class="form-group">
                        <label for="commentaires_memoire">COMMENTAIRES</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="commentaires_memoire"
                               name="commentaires_memoire" required pattern=".*" value="${memoire.evaluationEcole.commentaires}">
                    </div>
                </div>

                <!-- SOUTENANCE -->
                <div class="d-flex flex-column" style="width: 40%; margin: 5%">


                    <div class="form-group">
                        <label>SOUTENANCE</label><br>
                    </div>
                    <div class="form-group">
                        <label for="dateSoutenance">DATE</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="dateSoutenance"
                               name="dateSoutenance" required pattern=".*" value="${soutenance.dateSoutenance}">
                    </div>
                    <div class="form-group">
                        <label for="note_finale_soutenance">NOTE FINALE</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="note_finale_soutenance"
                               name="note_finale_soutenance" required pattern=".*" value="${soutenance.evaluationEcole.noteFinale}">
                    </div>
                    <div class="form-group">
                        <label for="commentaires_soutenance">COMMENTAIRES</label>
                        <input style="border-color: #9166CC" type="text" class="rounded-pill form-control" id="commentaires_soutenance"
                               name="commentaires_soutenance" required pattern=".*" value="${soutenance.evaluationEcole.commentaires}">
                    </div>
                </div>

            </div>

            <button type="submit" style="width: 30%; background-color: #9166CC" name="action" value="ModifierApprenti"
                    class="text-light mx-auto rounded-pill align-content-center btn border-0">Modifier
            </button>
        </form>
    </div>

</div>
</body>
</html>

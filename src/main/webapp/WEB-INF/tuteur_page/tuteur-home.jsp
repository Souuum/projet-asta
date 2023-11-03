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
    <title>Tuteur Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .hover_button:hover {
            background-color: #b497de;
        }

        .hover_button {
            background-color: #9166CC;
        }


        /**/

        .overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.8);
            color: #fff;
            text-align: center;
            z-index: 999;
        }

        .close-button {
            position: absolute;
            top: 10px;
            right: 10px;
            background: none;
            border: none;
            font-size: 20px;
            color: #fff;
            cursor: pointer;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body class="bg-dark text-light overflow-hidden">

<header style="background-color: #2A2E35" class="d-flex flex-row justify-content-around">
    <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

    </div>
    <div style="border-radius: 5px" class="p-2 my-auto hover_button">
        <button title="logout" class="bg-transparent border-0">
            <i class="bi bi-box-arrow-left"></i>
        </button>
    </div>
</header>


<div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">

    <div class="d-flex flex-column justify-content-center align-items-center">
        <form id="AddApprentiForm" action="tuteur-controller">
            <div class="w-100 m-2 d-flex justify-content-between">
                <h2 style="margin-right: auto">Bonjour <span style="color: #9166CC">${user.prenom} ${user.nom}</span>
                </h2>
                <input name="action" class="hover_button btn border-0 btn-primary"
                       style="background-color: #9166CC; margin-left: auto" type="submit"
                       value="+ Ajouter">
            </div>


            <div style="border-radius: 20px; background-color: #2A2E35"
                 class="w-100 p-4 flex-column d-flex justify-content-center align-items-center">

                <div style="width: 100%" class="d-flex flex-row">
                    <input style="background-color: #454E56" type="text" id="nomPrenomfilterInput"
                           class="flex-fill text-light mx-auto" onkeyup="filterName()"
                           placeholder="Search for Nom et Prenom..">
                    <input style="background-color: #454E56" type="text" id="emailfilterInput"
                           class="flex-fill text-light mx-auto" onkeyup="filterEmails()"
                           placeholder="Search for emails..">
                    <input style="background-color: #454E56" type="text" id="majeurfilterInput"
                           class="flex-fill text-light mx-auto" onkeyup="filterMajor()"
                           placeholder="Search for majeur..">
                </div>


                <c:forEach items="${apprentiListDTO}" var="apprenti">
                    <div style="display: flex; border-radius: 20px; background-color: #454E56"
                         class="_myperson p-2 m-3 flex-row justify-content-center align-items-center">
                        <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

                        </div>
                        <div style="width:250px" class="m-3 d-flex flex-column">
                            <div class="_myfullname">
                                <span>${apprenti.prenom} ${apprenti.nom}</span>
                            </div>
                            <div class="_myemail">
                                <span>${apprenti.email}</span>
                            </div>
                        </div>
                        <div class="m-3 d-flex flex-column">
                            <div style="color: #9166CC">Numero de telephone</div>
                            <div>${apprenti.telephone}</div>
                        </div>
                        <div class="m-3 d-flex flex-column">
                            <div style="color: #9166CC">Majeure</div>
                            <div class="_mymajor"><span>${apprenti.majeure}</span></div>
                        </div>
                        <div class="m-3 d-flex flex-column">
                            <div style="color: #9166CC">Année</div>
                            <div>${apprenti.anneeAcademique}</div>
                        </div>
                        <div class="m-3">
                            <button onclick="toggleOverlay()" style="color: #9166CC"
                                    class="border-0 bg-transparent btn-link" type="button">Editer
                            </button>
                        </div>

                    </div>
                </c:forEach>
                <div id="List">

                    <div style="display: flex; border-radius: 20px; background-color: #454E56"
                         class="_myperson p-2 m-3 flex-row justify-content-center align-items-center" id="gilbert">
                        <div style="background-color: #9166CC" class="p-3 rounded-circle m-3">
                        </div>
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div class="_myfullname">
                                <span>Gilbert Ziade</span>
                            </div>
                            <div class="_myemail">
                                <span>gilbert_z2001@hotmail.com</span>
                            </div>
                        </div>
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Numero de telephone</div>
                            <div>+33 7 85 76 41 77</div>
                        </div>
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Majeure</div>
                            <div class="_mymajor"><span>LSI</span></div>
                        </div>
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Année</div>
                            <div>2022-2025</div>
                        </div>
                        <div class="m-3">
                            <button onclick="toggleOverlay()" style="color: #9166CC"
                                    class="border-0 bg-transparent btn-link" type="button">Editer
                            </button>
                        </div>

                    </div>
                    <div style="display: flex; border-radius: 20px; background-color: #454E56"
                         class="_myperson p-2 m-3 flex-row justify-content-center align-items-center" id="margo">
                        <div style="background-color: #9166CC" class="p-3 rounded-circle m-3">
                        </div>
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div title="margo" class="_myfullname">
                                <span>margo</span>
                            </div>
                            <div title="margo" class="_myemail">
                                <span>margo@hotmail.com</span>
                            </div>
                        </div>
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Numero de telephone</div>
                            <div>+33 7 85 76 41 77</div>
                        </div>
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Majeure</div>
                            <div title="margo" class="_mymajor"><span>OBI</span></div>
                        </div>
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Année</div>
                            <div>2022-2025</div>
                        </div>
                        <div class="m-3">
                            <button onclick="toggleOverlay()" style="color: #9166CC"
                                    class="border-0 bg-transparent btn-link" type="button">Editer
                            </button>
                        </div>

                    </div>
                </div>
            </div>

        </form>


    </div>


    <!--overlay part-->
    <div class="overlay">
        <button class="close-button" onclick="closeOverlay()">X</button>


        <div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center">
            <div class="h2">Modification de <span style="color: #9166CC">NOM PRENOM</span></div>
            <br>
            <form class="flex-column d-flex justify-content-center align-content-center" id="registrationForm"
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

                <button id="btnn" type="submit" style="width: 30%; background-color: #9166CC" name="action"
                        value="SignUp"
                        class="text-light mx-auto rounded-pill align-content-center btn border-0">Modifier
                </button>
            </form>
        </div>

    </div>

</div>

</body>

<script>
    //overlay
    function toggleOverlay() {
        const overlay = document.querySelector('.overlay');
        overlay.style.display = 'block';
    }

    function closeOverlay() {
        const overlay = document.querySelector('.overlay');
        overlay.style.display = 'none';
    }


    // filter

    function filterEmails() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('emailfilterInput');
        document.getElementById('nomPrenomfilterInput').value = "";
        document.getElementById('majeurfilterInput').value = "";
        filter = input.value.toUpperCase();
        ul = document.getElementById('List');
        li = ul.getElementsByClassName('_myemail');

        var li_person = ul.getElementsByClassName('_myperson');


        for (i = 0; i < li.length; i++) {
            a = li[i].getElementsByTagName('span')[0];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li_person[i].style.display = 'flex';
            } else {
                li_person[i].style.display = 'none';
            }
        }
    }

    function filterName() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('nomPrenomfilterInput');

        document.getElementById('emailfilterInput').value = "";
        document.getElementById('majeurfilterInput').value = "";

        filter = input.value.toUpperCase();
        ul = document.getElementById('List');
        li = ul.getElementsByClassName('_myfullname');
        var li_person = ul.getElementsByClassName('_myperson');

        for (i = 0; i < li.length; i++) {
            a = li[i].getElementsByTagName('span')[0];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li_person[i].style.display = 'flex';
            } else {
                li_person[i].style.display = 'none';
            }
        }
    }

    function filterMajor() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('majeurfilterInput');

        document.getElementById('nomPrenomfilterInput').value = "";
        document.getElementById('emailfilterInput').value = "";
        filter = input.value.toUpperCase();
        ul = document.getElementById('List');
        li = ul.getElementsByClassName('_mymajor');

        var li_person = ul.getElementsByClassName('_myperson');


        for (i = 0; i < li.length; i++) {
            a = li[i].getElementsByTagName('span')[0];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li_person[i].style.display = 'flex';
            } else {
                li_person[i].style.display = 'none';
            }
        }
    }

</script>
</html>
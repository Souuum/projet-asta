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

    <div style="width: 500px" class="text-light d-flex flex-row justify-content-around">
        <div id="headerApprentissages" class="p-2"
             style="cursor: pointer;background-color: #9166CC; border: #2A2E35 solid 4px; border-radius: 5px"
             onclick="changeColor(this)">
            Apprentissages
        </div>
        <div id="headerMaitreApprentissage" class="p-2"
             style="cursor:pointer; border: #2A2E35 solid 4px; border-radius: 5px" onclick="changeColor(this)">
            Maitre d'apprentissage
        </div>
        <div id="headerEntreprise" class="p-2" style="cursor: pointer ;border: #2A2E35 solid 4px; border-radius: 5px"
             onclick="changeColor(this)">
            Entreprise
        </div>
    </div>

    <div class="d-flex flex-column justify-content-center align-items-center">
        <form id="AddApprentiForm" action="tuteur-controller">
            <div class="w-100 m-2 d-flex justify-content-between">
                <h2 style="margin-right: auto">Bonjour <span style="color: #9166CC">${user.prenom} ${user.nom}</span>
                </h2>
                <input name="action" class="hover_button btn border-0 btn-primary"
                       style="background-color: #9166CC; margin-left: auto" type="submit"
                       value="+ Ajouter">
            </div>

            <!--apprentissage-->
            <div id="apprentissage_field" style="display: flex ;border-radius: 20px; background-color: #2A2E35"
                 class="w-100 p-4 flex-column justify-content-center align-items-center">

                <div style="width: 100%" class="d-flex flex-row">
                    <input style="background-color: #454E56" type="text" id="AnomPrenomfilterInput"
                           class="flex-fill text-light mx-auto" onkeyup="AfilterName()"
                           placeholder="Search for Nom et Prenom..">
                    <input style="background-color: #454E56" type="text" id="AemailfilterInput"
                           class="flex-fill text-light mx-auto" onkeyup="AfilterEmails()"
                           placeholder="Search for emails..">
                    <input style="background-color: #454E56" type="text" id="AmajeurfilterInput"
                           class="flex-fill text-light mx-auto" onkeyup="AfilterMajor()"
                           placeholder="Search for majeur..">
                </div>
                <div id="ApprentiList">

                    <c:forEach items="${apprentiListDTO}" var="apprenti">
                        <div style="display: flex; border-radius: 20px; background-color: #454E56"
                             class="_myapprenti p-2 m-3 flex-row justify-content-center align-items-center">
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
                                <button onclick="APtoggleOverlay()" style="color: #9166CC"
                                        class="border-0 bg-transparent btn-link" type="button">Editer
                                </button>
                            </div>

                        </div>
                    </c:forEach>

                    <div style="display: flex; border-radius: 20px; background-color: #454E56"
                         class="_myapprenti p-2 m-3 flex-row justify-content-center align-items-center">
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
                            <button onclick="APtoggleOverlay()" style="color: #9166CC"
                                    class="border-0 bg-transparent btn-link" type="button">Editer
                            </button>
                        </div>

                    </div>
                    <div style="display: flex; border-radius: 20px; background-color: #454E56"
                         class="_myapprenti p-2 m-3 flex-row justify-content-center align-items-center">
                        <div style="background-color: #9166CC" class="p-3 rounded-circle m-3">
                        </div>
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div class="_myfullname">
                                <span>margo</span>
                            </div>
                            <div class="_myemail">
                                <span>margo@hotmail.com</span>
                            </div>
                        </div>
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Numero de telephone</div>
                            <div>+33 7 85 76 41 77</div>
                        </div>
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Majeure</div>
                            <div class="_mymajor"><span>OBI</span></div>
                        </div>
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Année</div>
                            <div>2022-2025</div>
                        </div>
                        <div class="m-3">
                            <button onclick="APtoggleOverlay()" style="color: #9166CC"
                                    class="border-0 bg-transparent btn-link" type="button">Editer
                            </button>
                        </div>

                    </div>
                </div>
            </div>


            <!--Maitre d'apprentissage-->

            <div id="maitre_apprenti_field" style="display: none ;border-radius: 20px; background-color: #2A2E35"
                 class="w-100 p-4 flex-column justify-content-center align-items-center">

                <div style="width: 100%" class="d-flex flex-row">
                    <input style="background-color: #454E56" type="text" id="MAnomPrenomfilterInput"
                           class="flex-fill text-light mx-auto" onkeyup="MAfilterName()"
                           placeholder="Search for Nom et Prenom..">
                    <input style="background-color: #454E56" type="text" id="MAemailfilterInput"
                           class="flex-fill text-light mx-auto" onkeyup="MAfilterEmails()"
                           placeholder="Search for emails..">
                    <input style="background-color: #454E56" type="text" id="MAentreprisefilterInput"
                           class="flex-fill text-light mx-auto" onkeyup="MAfilterEntreprise()"
                           placeholder="Search for entreprise..">
                </div>
                <div id="MaitreAppList">

                    <c:forEach items="${apprentiListDTO}" var="apprenti">
                        <div style="display: flex; border-radius: 20px; background-color: #454E56"
                             class="_mymaitreapprenti p-2 m-3 flex-row justify-content-center align-items-center">
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
                            <div style="width:250px " class="d-flex flex-column m-3">
                                <div style="color: #9166CC">Entreprise</div>
                                <div class="_myentreprise"><span>XXX</span></div>
                            </div>

                            <div class="m-3">
                                <button onclick="MAtoggleOverlay()" style="color: #9166CC"
                                        class="border-0 bg-transparent btn-link" type="button">Editer
                                </button>
                            </div>
                        </div>
                    </c:forEach>

                    <div style="display: flex; border-radius: 20px; background-color: #454E56"
                         class="_mymaitreapprenti p-2 m-3 flex-row justify-content-center align-items-center">
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
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Entreprise</div>
                            <div class="_myentreprise"><span>XXX</span></div>
                        </div>
                        <div class="m-3">
                            <button onclick="MAtoggleOverlay()" style="color: #9166CC"
                                    class="border-0 bg-transparent btn-link" type="button">Editer
                            </button>
                        </div>

                    </div>
                    <div style="display: flex; border-radius: 20px; background-color: #454E56"
                         class="_mymaitreapprenti p-2 m-3 flex-row justify-content-center align-items-center">
                        <div style="background-color: #9166CC" class="p-3 rounded-circle m-3">
                        </div>
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div class="_myfullname">
                                <span>margo</span>
                            </div>
                            <div class="_myemail">
                                <span>margo@hotmail.com</span>
                            </div>
                        </div>
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Numero de telephone</div>
                            <div>+33 7 85 76 41 77</div>
                        </div>
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Entreprise</div>
                            <div class="_myentreprise"><span>YYY</span></div>
                        </div>
                        <div class="m-3">
                            <button onclick="MAtoggleOverlay()" style="color: #9166CC"
                                    class="border-0 bg-transparent btn-link" type="button">Editer
                            </button>
                        </div>

                    </div>
                </div>
            </div>


            <!--Entreprise-->

            <div id="entrperise_field" style="display: none ;border-radius: 20px; background-color: #2A2E35"
                 class="w-100 p-4 flex-column justify-content-center align-items-center">

                <div style="width: 100%" class="d-flex flex-row">
                    <input style="background-color: #454E56" type="text" id="ENomfilterInput"
                           class="flex-fill text-light mx-auto" onkeyup="EfilterName()"
                           placeholder="Search for Name..">
                    <input style="background-color: #454E56" type="text" id="EAddressfilterInput"
                           class="flex-fill text-light mx-auto" onkeyup="EfilterAddress()"
                           placeholder="Search for address..">
                </div>

                <div id="EntrepriseList">

                    <c:forEach items="${apprentiListDTO}" var="apprenti">
                        <div style="display: flex; border-radius: 20px; background-color: #454E56"
                             class="_myentreprise p-2 m-3 flex-row justify-content-center align-items-center">
                            <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

                            </div>
                            <div style="width:250px " class="d-flex flex-column m-3">
                                <div class="_myfullname">
                                    <div style="color: #9166CC">Entreprise</div>
                                    <span>${apprenti.prenom} ${apprenti.nom}</span>
                                </div>
                            </div>
                            <div style="width:250px " class="d-flex flex-column m-3">
                                <div class="_myaddress">
                                    <div style="color: #9166CC">Addresse</div>
                                    <span>${apprenti.addresse}</span>
                                </div>
                            </div>

                            <div style="width:250px " class="d-flex flex-column m-3">
                                <div style="color: #9166CC">Information</div>
                                <div>${apprenti.telephone}</div>
                            </div>

                            <div class="m-3">
                                <button onclick="MAtoggleOverlay()" style="color: #9166CC"
                                        class="border-0 bg-transparent btn-link" type="button">Editer
                                </button>
                            </div>

                        </div>
                    </c:forEach>

                    <div style="display: flex; border-radius: 20px; background-color: #454E56"
                         class="_myentreprise p-2 m-3 flex-row justify-content-center align-items-center">
                        <div style="background-color: #9166CC" class="p-3 rounded-circle m-3">
                        </div>
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div class="_myfullname">
                                <div style="color: #9166CC">Entreprise</div>
                                <span>Muvraline</span>
                            </div>
                        </div>
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div class="_myaddress">
                                <div style="color: #9166CC">Addresse</div>
                                <span>Villejuif</span>
                            </div>
                        </div>
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Information</div>
                            <div>Pas d'info</div>
                        </div>
                        <div class="m-3">
                            <button onclick="EtoggleOverlay()" style="color: #9166CC"
                                    class="border-0 bg-transparent btn-link" type="button">Editer
                            </button>
                        </div>
                    </div>
                    <div style="display: flex; border-radius: 20px; background-color: #454E56"
                         class="_myentreprise p-2 m-3 flex-row justify-content-center align-items-center">
                        <div style="background-color: #9166CC" class="p-3 rounded-circle m-3">
                        </div>
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div class="_myfullname">
                                <div style="color: #9166CC">Entreprise</div>
                                <span>Google</span>
                            </div>
                        </div>
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div class="_myaddress">
                                <div style="color: #9166CC">Addresse</div>
                                <span>palaiseau</span>
                            </div>
                        </div>
                        <div style="width:250px " class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Information</div>
                            <div>Pas d'information</div>
                        </div>
                        <div class="m-3">
                            <button onclick="EtoggleOverlay()" style="color: #9166CC"
                                    class="border-0 bg-transparent btn-link" type="button">Editer
                            </button>
                        </div>

                    </div>
                </div>
            </div>


        </form>


    </div>


    <!--overlay apprenti-->
    <div class="overlay" id="APoverlay">
        <button class="close-button" onclick="APcloseOverlay()">X</button>


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

    <!--overlay maitre d'apprenti-->
    <div class="overlay" id="MAoverlay">
        <button class="close-button" onclick="MAcloseOverlay()">X</button>


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

    <!--overlay Entreprise-->
    <div class="overlay" id="Eoverlay">
        <button class="close-button" onclick="EcloseOverlay()">X</button>


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
                        <textarea placeholder="Ecrire des information supplementaire..." class="form-control" style="resize: none ;border-radius: 20px; border-color: #9166CC" type="text" id="Einformation"></textarea>
                    </div>
                </div>

                <button type="submit" style="width: 30%; background-color: #9166CC" name="action"
                        class="text-light mx-auto rounded-pill align-content-center btn border-0">Modifier
                </button>
            </form>
        </div>

    </div>

</div>

</body>

<script>
    //APPRENTI Overlay
    function APtoggleOverlay() {
        const overlay = document.getElementById('APoverlay');
        overlay.style.display = 'block';
    }

    function APcloseOverlay() {
        const overlay = document.getElementById('APoverlay');
        overlay.style.display = 'none';
    }

    //Maitre d'apprenti Overlay
    function MAtoggleOverlay() {
        const overlay = document.getElementById('MAoverlay');
        overlay.style.display = 'block';
    }

    function MAcloseOverlay() {
        const overlay = document.getElementById('MAoverlay');
        overlay.style.display = 'none';
    }

    //Entreprise Overlay
    function EtoggleOverlay() {
        const overlay = document.getElementById('Eoverlay');
        overlay.style.display = 'block';
    }

    function EcloseOverlay() {
        const overlay = document.getElementById('Eoverlay');
        overlay.style.display = 'none';
    }


    // filter apprenti

    function AfilterEmails() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('AemailfilterInput');
        document.getElementById('AnomPrenomfilterInput').value = "";
        document.getElementById('AmajeurfilterInput').value = "";
        filter = input.value.toUpperCase();
        ul = document.getElementById('ApprentiList');
        li = ul.getElementsByClassName('_myemail');

        var li_person = ul.getElementsByClassName('_myapprenti');


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

    function AfilterName() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('AnomPrenomfilterInput');

        document.getElementById('AemailfilterInput').value = "";
        document.getElementById('AmajeurfilterInput').value = "";

        filter = input.value.toUpperCase();
        ul = document.getElementById('ApprentiList');
        li = ul.getElementsByClassName('_myfullname');
        var li_person = ul.getElementsByClassName('_myapprenti');

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

    function AfilterMajor() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('AmajeurfilterInput');

        document.getElementById('AnomPrenomfilterInput').value = "";
        document.getElementById('AemailfilterInput').value = "";
        filter = input.value.toUpperCase();
        ul = document.getElementById('ApprentiList');
        li = ul.getElementsByClassName('_mymajor');

        var li_person = ul.getElementsByClassName('_myapprenti');


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

    // filter maitre apprenti

    function MAfilterEmails() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('MAemailfilterInput');
        document.getElementById('MAnomPrenomfilterInput').value = "";
        document.getElementById('MAentreprisefilterInput').value = "";
        filter = input.value.toUpperCase();
        ul = document.getElementById('MaitreAppList');
        li = ul.getElementsByClassName('_myemail');

        var li_person = ul.getElementsByClassName('_mymaitreapprenti');
        console.log(li_person)

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

    function MAfilterName() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('MAnomPrenomfilterInput');

        document.getElementById('MAemailfilterInput').value = "";
        document.getElementById('MAentreprisefilterInput').value = "";

        filter = input.value.toUpperCase();
        ul = document.getElementById('MaitreAppList');
        li = ul.getElementsByClassName('_myfullname');
        var li_person = ul.getElementsByClassName('_mymaitreapprenti');

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

    function MAfilterEntreprise() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('MAentreprisefilterInput');

        document.getElementById('MAnomPrenomfilterInput').value = "";
        document.getElementById('MAemailfilterInput').value = "";
        filter = input.value.toUpperCase();
        ul = document.getElementById('MaitreAppList');
        li = ul.getElementsByClassName('_myentreprise');

        var li_person = ul.getElementsByClassName('_mymaitreapprenti');


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


    // filter Entreprise

    function EfilterAddress() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('EAddressfilterInput');
        document.getElementById('ENomfilterInput').value = "";
        filter = input.value.toUpperCase();
        ul = document.getElementById('EntrepriseList');
        li = ul.getElementsByClassName('_myaddress');

        var li_person = ul.getElementsByClassName('_myentreprise');
        console.log(li_person)

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

    function EfilterName() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('ENomfilterInput');

        document.getElementById('EAddressfilterInput').value = "";

        filter = input.value.toUpperCase();
        ul = document.getElementById('EntrepriseList');
        li = ul.getElementsByClassName('_myfullname');
        var li_person = ul.getElementsByClassName('_myentreprise');

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


    // change the header
    function changeColor(square) {
        var header_list = [
            document.getElementById("headerApprentissages"),
            document.getElementById("headerMaitreApprentissage"),
            document.getElementById("headerEntreprise"),
        ]


        for (var i = 0; i < header_list.length; i++) {
            if (square === header_list[i]) {
                header_list[i].style.backgroundColor = "#9166CC";
                if (i === 0) {
                    document.getElementById("apprentissage_field").style.display = 'flex'
                    document.getElementById("maitre_apprenti_field").style.display = 'none'
                    document.getElementById("entrperise_field").style.display = 'none'
                } else if (i === 1) {
                    document.getElementById("apprentissage_field").style.display = 'none'
                    document.getElementById("maitre_apprenti_field").style.display = 'flex'
                    document.getElementById("entrperise_field").style.display = 'none'
                } else {
                    document.getElementById("apprentissage_field").style.display = 'none'
                    document.getElementById("maitre_apprenti_field").style.display = 'none'
                    document.getElementById("entrperise_field").style.display = 'flex'
                }
            } else {
                header_list[i].style.backgroundColor = "rgba(255, 255, 255, 0)";
            }
        }

    }
</script>
</html>
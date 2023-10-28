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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-dark text-light">

<div class="d-flex flex-column w-100 vh-100 justify-content-center align-items-center overflow-hidden">

    <div class="d-flex flex-column justify-content-center align-items-center">

        <div class="w-100 m-2 d-flex">
            <h2 style="margin-right: auto">Bonjour <span style="color: #9166CC">NOM PRENOM</span></h2>
        </div>


        <div style="height: 75%; border-radius: 20px; background-color: #2A2E35"
             class="w-100 p-4 justify-content-center align-items-center overflow-auto">

            <div class="m-3">
                <h3 style="margin-right: auto">Apprenti</h3>

                <div style="border-radius: 20px; background-color: #454E56"
                     class="p-2 flex-row d-flex justify-content-center align-items-center">
                    <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

                    </div>
                    <div class="m-3 d-flex flex-column">
                        <div>
                            Gilbert Ziade
                        </div>
                        <div>
                            gilbert_z2001@hotmail.com
                        </div>
                    </div>
                    <div class="m-3 d-flex flex-column">
                        <div style="color: #9166CC">Numero de telephone</div>
                        <div>+33 7 85 76 41 77</div>
                    </div>
                    <div class="m-3 d-flex flex-column">
                        <div style="color: #9166CC">Majeure</div>
                        <div>LSI</div>
                    </div>
                    <div class="m-3 d-flex flex-column">
                        <div style="color: #9166CC">Année</div>
                        <div>2022-2025</div>
                    </div>
                    <div class="m-3">
                        <button style="color: #9166CC" class="border-0 bg-transparent btn-link" type="button">Editer
                        </button>
                    </div>

                </div>
            </div>


            <div style="border-radius: 20px; background-color: #2A2E35"
                 class="flex-row d-flex justify-content-between align-items-center m-3">
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Entreprise</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <div><span style="color: #9166CC">Raison Sociale:</span> RATP</div>
                        <div><span style="color: #9166CC">Addresse:</span> 54 Quai de la Rapée</div>
                        <div><span style="color: #9166CC">Informations utiles pour les locaux:</span> Badge</div>

                    </div>
                </div>
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Missions</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <div>
                            <span style="color: #9166CC">Mots-clés:</span> Programmation; développement; code; java
                        </div>
                        <div>
                            <span style="color: #9166CC">Métier cible:</span> Développeur Java
                        </div>
                        <div>
                            <span style="color: #9166CC">Commentaires:</span> pas de commentaires
                        </div>
                    </div>
                </div>
            </div>

            <div class="m-3">
                <h3 style="margin-right: auto">Maitre d'apprentissage</h3>
                <div style="border-radius: 20px; background-color: #454E56"
                     class="p-2 flex-row d-flex justify-content-center align-items-center">
                    <div style="background-color: #9166CC" class="p-3 m-3 rounded-circle">

                    </div>

                    <div class="d-flex flex-column">
                        <div class="d-flex flex-row">
                            <div class="m-3 d-flex flex-column">
                                <div>
                                    Gilbert Ziade
                                </div>
                                <div>
                                    gilbert_z2001@hotmail.com
                                </div>
                            </div>
                            <div class="m-3 d-flex flex-column">
                                <div style="color: #9166CC">Numero de telephone</div>
                                <div>+33 7 85 76 41 77</div>
                            </div>
                            <div class="m-3 d-flex flex-column">
                                <div style="color: #9166CC">Poste</div>
                                <div>professeur de Programmation JAVA</div>
                            </div>
                        </div>
                        <div class="d-flex flex-column m-3">
                            <div style="color: #9166CC">Remarque</div>
                            <div>pas de remarque</div>
                        </div>
                    </div>
                </div>

            </div>


            <div style="border-radius: 20px; background-color: #2A2E35"
                 class="flex-row d-flex justify-content-between align-items-center m-3">
                <div class="align-self-stretch flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Remarques</h3>
                    <div style="height: 100%; border-radius: 20px; background-color: #454E56" class=" p-2 flex-column d-flex">
                        <div><span style="color: #9166CC">Feedback de l'apprenti:</span> pas de feedback</div>
                    </div>
                </div>
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Visite</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <div>
                            <span style="color: #9166CC">Date:</span> 10/10/2023
                        </div>
                        <div>
                            <span style="color: #9166CC">Format:</span> Visioconférence
                        </div>
                        <div>
                            <span style="color: #9166CC">Compte-Rendu Express:</span> Très bein
                        </div>
                    </div>
                </div>
            </div>


            <div style="border-radius: 20px; background-color: #2A2E35"
                 class="flex-row d-flex justify-content-between align-items-center m-3">
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Mémoire/Rapport</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <div><span style="color: #9166CC">Thème:</span> Information Voyageur</div>
                        <div><span style="color: #9166CC">Note finale:</span> 17/20</div>
                        <div><span style="color: #9166CC">Commentaire:</span> Pas de commentaire</div>

                    </div>
                </div>
                <div class="flex-fill d-flex flex-column m-2">
                    <h3 style="margin-right: auto">Soutenance</h3>
                    <div style="border-radius: 20px; background-color: #454E56" class="p-2 flex-column d-flex">
                        <div>
                            <span style="color: #9166CC">Date:</span> 10/10/2024
                        </div>
                        <div>
                            <span style="color: #9166CC">Note finale:</span> 16/20
                        </div>
                        <div>
                            <span style="color: #9166CC">Commentaires:</span> pas de commentaires
                        </div>
                    </div>
                </div>
            </div>






        </div>
    </div>
</div>

</body>
</html>

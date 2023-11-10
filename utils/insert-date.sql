INSERT INTO entreprise(id_entreprise,raison_sociale,adresse,informations,updated_at,created_at) VALUES ('1', 'SNCF','Rue sncf','information sncf',now(),now());
INSERT INTO entreprise (id_entreprise,raison_sociale, adresse, informations)VALUES ('10','AnotherCompany', '456 Oak Avenue', 'Some information about another company');


INSERT INTO utilisateur(id_utilisateur,nom,prenom,email,password,telephone,isadmin,updated_at,created_at) VALUES ('1','za','mohamed','tuteur1@hotmail.com','19513fdc9da4fb72a4a05eb66917548d','0785764171',1,now(),now());
INSERT INTO utilisateur(id_utilisateur,nom,prenom,email,password,telephone,isadmin,updated_at,created_at) VALUES ('6','Zoro','Gille','tuteur2@hotmail.com','19513fdc9da4fb72a4a05eb66917548d','0785764181',1,now(),now());

INSERT INTO utilisateur(id_utilisateur,nom,prenom,email,password,telephone,isadmin,updated_at,created_at) VALUES ('2','Ziade','Gilbert','app1@hotmail.com','19513fdc9da4fb72a4a05eb66917548d','0785764171',0,now(),now());
INSERT INTO utilisateur(id_utilisateur,nom,prenom,email,password,telephone,isadmin,updated_at,created_at) VALUES ('3','Chatti','gille','app2@hotmail.com','19513fdc9da4fb72a4a05eb66917548d','0785764171',0,now(),now());
INSERT INTO utilisateur(id_utilisateur,nom,prenom,email,password,telephone,isadmin,updated_at,created_at) VALUES ('4','Soum','Hugo','app3@hotmail.com','19513fdc9da4fb72a4a05eb66917548d','0785764171',0,now(),now());
INSERT INTO utilisateur(id_utilisateur,nom,prenom,email,password,telephone,isadmin,updated_at,created_at) VALUES ('5','song','Valerie','ap3@hotmail.com','19513fdc9da4fb72a4a05eb66917548d','0785764171',0,now(),now());




INSERT INTO maitre_apprentissage(id_maitre_apprentissage,nom,prenom,email,telephone,id_entreprise,updated_at,created_at) VALUES ('1','john', 'doe', 'doe@john.fr','0785764175','1',now(),now());
INSERT INTO maitre_apprentissage(id_maitre_apprentissage,nom,prenom,email,telephone,id_entreprise,updated_at,created_at) VALUES ('2','Jean-Michele', 'doe', 'doe@jeanmichel.fr','07857641713','10',now(),now());


INSERT INTO tuteur_enseignant(id_utilisateur,updated_at,created_at) VALUES ('1',now(),now());
INSERT INTO tuteur_enseignant(id_utilisateur,updated_at,created_at) VALUES ('6',now(),now());
INSERT INTO mission(id_mission ,mots_cles,metier_cible,commentaires,updated_at,created_at) VALUES ('1','node.js','ingenieur','bon travail',now(),now());
INSERT INTO mission(id_mission ,mots_cles,metier_cible,commentaires,updated_at,created_at) VALUES ('2','node.js','ingenieur','correct travail',now(),now());



INSERT INTO apprenti(numero_etudiant, programme, annee_academique, majeure, feedback, id_maitre_apprentissage, id_tuteur_enseignant, id_mission, id_utilisateur, is_archived, updated_at, created_at) VALUES ('20220161','M2','2023','LSI','Excellent','1','1','1','2',false,now(),now());
INSERT INTO apprenti (numero_etudiant,programme,annee_academique, majeure, feedback, id_maitre_apprentissage, id_tuteur_enseignant, id_mission, id_utilisateur, is_archived,updated_at,created_at) VALUES ('20220265','M1','2023','BDML','Good learner','2','1','2','3',false,now(),now());

INSERT INTO apprenti (numero_etudiant,programme,annee_academique, majeure, feedback, id_maitre_apprentissage, id_tuteur_enseignant, id_mission, id_utilisateur, is_archived,updated_at,created_at) VALUES ('20235145','L3','2023','RS','Fast learner',NULL,'1',NULL,'4',false,now(),now());
INSERT INTO apprenti (numero_etudiant,programme,annee_academique, majeure, feedback, id_maitre_apprentissage, id_tuteur_enseignant, id_mission, id_utilisateur, is_archived,updated_at,created_at) VALUES ('20236598','L2','2023','RS','Smart',NULL,'1',NULL,'4',false,now(),now());



INSERT INTO evaluation_ecole(id_evaluation_ecole,note_finale, commentaires, numero_etudiant, updated_at, created_at, type) VALUES ('1','15','good job','20220161',now(),now(),'soutenance');
INSERT INTO evaluation_ecole(id_evaluation_ecole,note_finale, commentaires, numero_etudiant, updated_at, created_at, type) VALUES ('2','18','great','20220265',now(),now(),'soutenance');
INSERT INTO evaluation_ecole(id_evaluation_ecole,note_finale, commentaires, numero_etudiant, updated_at, created_at, type) VALUES ('3','14','great','20220261',now(),now(),'memoire');
INSERT INTO evaluation_ecole(id_evaluation_ecole,note_finale, commentaires, numero_etudiant, updated_at, created_at, type) VALUES ('4','17','great','20220265',now(),now(), 'memoire');

INSERT INTO visite(date_visite, format, compte_rendu_express, numero_etudiant, id_tuteur_enseignant, updated_at, created_at) VALUES ('2022-10-10','presentiel','compte_rendu','20220161','1',now(),now());
INSERT INTO visite(date_visite, format, compte_rendu_express, numero_etudiant, id_tuteur_enseignant, updated_at, created_at) VALUES ('2022-11-11','presentiel','compte_rendu','20220265','1',now(),now());

INSERT INTO soutenance(date_soutenance, id_evaluation_ecole, updated_at, created_at) VALUES ('2022-10-10','1',now(),now());
INSERT INTO soutenance(date_soutenance, id_evaluation_ecole, updated_at, created_at) VALUES ('2022-12-12','2',now(),now());

INSERT INTO memoire(theme, id_evaluation_ecole, updated_at, created_at) VALUES ('memoire','3',now(),now());
INSERT INTO memoire(theme, id_evaluation_ecole, updated_at, created_at) VALUES ('memoire','4',now(),now());


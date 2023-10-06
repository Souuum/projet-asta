INSERT INTO entreprise(id_entreprise,raison_sociale,adresse,informations,updated_at,created_at) VALUES (10,'SNCF','Rue sncf','information sncf',now(),now());
INSERT INTO utilisateur(id_utilisateur,nom,prenom,email,password,telephone,isadmin,updated_at,created_at) VALUES (1,'za','mohamed','za@mohamed.fr','user1','07',0,now(),now());
INSERT INTO utilisateur(id_utilisateur,nom,prenom,email,password,telephone,isadmin,updated_at,created_at) VALUES (2,'augustin','jacques','augustin@jacques.fr','admin1','07',1,now(),now());
INSERT INTO maitre_apprentissage(id_maitre_apprentissage,nom,prenom,email,telephone,id_entreprise,updated_at,created_at) VALUES (3,'john', 'doe', 'doe@john.fr','07',10,now(),now());
INSERT INTO tuteur_enseignant(id_tuteur_enseignant,id_utilisateur,updated_at,created_at) VALUES (2,2,now(),now());
INSERT INTO mission(id_mission,mots_cles,metier_cible,commentaires,updated_at,created_at) VALUES (15,'node.js','ingenieur','bon travail',now(),now());
INSERT INTO apprenti(numero_etudiant, programme, annee_academique, majeure, feedback, id_maitre_apprentissage, id_tuteur_enseignant, id_mission, id_utilisateur, is_archived, updated_at, created_at) VALUES ('123','M2','2023','Software enginer','noob',3,2,15,1,0,now(),now());
INSERT INTO evaluation_ecole(id_evaluation_ecole, note_finale, commentaires, numero_etudiant, updated_at, created_at) VALUES (20,'15','good job bro','123',now(),now());
INSERT INTO visite(id_visite, date_visite, format, compte_rendu_express, numero_etudiant, id_tuteur_enseignant, updated_at, created_at) VALUES (25,'2022-10-10','presentiel','compte_rendu','123',2,now(),now());
INSERT INTO soutenance(id_soutenance, date_soutenance, id_evaluation_ecole, updated_at, created_at) VALUES (30,'2022-10-10',20,now(),now());
INSERT INTO memoire(id_memoire, theme, id_evaluation_ecole, updated_at, created_at) VALUES (35,'memoire',20,now(),now());

# d_entreprise = 10
# id_utilisateur = 1-> apprentie
# id_utilisateur = 2-> Tuteur
# id_maitre_apprenti = 3
# id_tuteur_enseignent = 2
# id_mission = 15
# numero_etudiant = '123'
# id_evalutation_ecole = 20
# id_visite = 25
# id_soutenance = 30
# id_memoire = 35

# apprentie:
# user: user1
# pass: user1
#
# Tuteur:
# user: admin1
# pass: admin1
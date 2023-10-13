


USE `projet-asta`;

DROP TABLE `memoire`;
DROP TABLE `soutenance`;
DROP TABLE `visite`;
DROP TABLE `evaluation_ecole`;
DROP TABLE  `apprenti`;
DROP TABLE `mission`;
DROP TABLE `tuteur_enseignant`;
DROP TABLE `maitre_apprentissage`;
DROP TABLE `utilisateur`;
DROP TABLE `entreprise`;

CREATE TABLE `entreprise` (
  `id_entreprise` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `raison_sociale` varchar(50),
  `adresse` varchar(50),
  `informations` varchar(50),
  `updated_at` timestamp DEFAULT now(),
  `created_at` timestamp DEFAULT now()
);

CREATE TABLE `utilisateur` (
  `id_utilisateur` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `nom` varchar(50),
  `prenom` varchar(50),
  `email` varchar(50),
  `password` varchar(32),
  `telephone` varchar(50),
  `isadmin` bool default false,
  `updated_at` timestamp DEFAULT now(),
  `created_at` timestamp DEFAULT now()
);

CREATE TABLE `mission` (
  `id_mission` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `mots_cles` varchar(50),
  `metier_cible` varchar(50),
  `commentaires` varchar(50),
  `updated_at` timestamp DEFAULT now(),
  `created_at` timestamp DEFAULT now()
);

CREATE TABLE `maitre_apprentissage` (
  `id_maitre_apprentissage` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `nom` varchar(50),
  `prenom` varchar(50),
  `email` varchar(50),
  `telephone` varchar(50),
  `id_entreprise` int NOT NULL,
  `updated_at` timestamp DEFAULT now(),
  `created_at` timestamp DEFAULT now()
);

CREATE TABLE `tuteur_enseignant` (
  `id_tuteur_enseignant` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `id_utilisateur` int NOT NULL,
  `updated_at` timestamp DEFAULT now(),
  `created_at` timestamp DEFAULT now()
);

CREATE TABLE `apprenti` (
  `numero_etudiant` varchar(50) PRIMARY KEY,
  `programme` varchar(50),
  `annee_academique` varchar(50),
  `majeure` varchar(50),
  `feedback` varchar(50),
  `id_maitre_apprentissage` int DEFAULT NULL,
  `id_tuteur_enseignant` int DEFAULT NULL,
  `id_mission` int DEFAULT NULL,
  `id_utilisateur` int NOT NULL,
  `is_archived` bool DEFAULT false,
  `updated_at` timestamp DEFAULT now(),
  `created_at` timestamp DEFAULT now()
);

CREATE TABLE `visite` (
  `id_visite` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `date_visite` date,
  `format` varchar(50),
  `compte_rendu_express` varchar(50),
  `numero_etudiant` varchar(50) NOT NULL,
  `id_tuteur_enseignant` int NOT NULL,
  `updated_at` timestamp DEFAULT now(),
  `created_at` timestamp DEFAULT now()
);

CREATE TABLE `evaluation_ecole` (
  `id_evaluation_ecole` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `note_finale` varchar(50),
  `commentaires` varchar(50),
  `numero_etudiant` varchar(50) NOT NULL,
  `updated_at` timestamp DEFAULT now(),
  `created_at` timestamp DEFAULT now()
);

CREATE TABLE `memoire` (
  `id_memoire` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `theme` varchar(50),
  `id_evaluation_ecole` int NOT NULL,
  `updated_at` timestamp DEFAULT now(),
  `created_at` timestamp DEFAULT now()
);

CREATE TABLE `soutenance` (
  `id_soutenance` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `date_soutenance` date,
  `id_evaluation_ecole` int NOT NULL,
  `updated_at` timestamp DEFAULT now(),
  `created_at` timestamp DEFAULT now()
);

ALTER TABLE `maitre_apprentissage` ADD FOREIGN KEY (`id_entreprise`) REFERENCES `entreprise` (`id_entreprise`);

ALTER TABLE `tuteur_enseignant` ADD FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

ALTER TABLE `apprenti` ADD FOREIGN KEY (`id_maitre_apprentissage`) REFERENCES `maitre_apprentissage` (`id_maitre_apprentissage`);

ALTER TABLE `apprenti` ADD FOREIGN KEY (`id_tuteur_enseignant`) REFERENCES `tuteur_enseignant` (`id_tuteur_enseignant`);

ALTER TABLE `apprenti` ADD FOREIGN KEY (`id_mission`) REFERENCES `mission` (`id_mission`);

ALTER TABLE `apprenti` ADD FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

ALTER TABLE `visite` ADD FOREIGN KEY (`numero_etudiant`) REFERENCES `apprenti` (`numero_etudiant`);

ALTER TABLE `visite` ADD FOREIGN KEY (`id_tuteur_enseignant`) REFERENCES `tuteur_enseignant` (`id_tuteur_enseignant`);

ALTER TABLE `evaluation_ecole` ADD FOREIGN KEY (`numero_etudiant`) REFERENCES `apprenti` (`numero_etudiant`);

ALTER TABLE `memoire` ADD FOREIGN KEY (`id_evaluation_ecole`) REFERENCES `evaluation_ecole` (`id_evaluation_ecole`);

ALTER TABLE `soutenance` ADD FOREIGN KEY (`id_evaluation_ecole`) REFERENCES `evaluation_ecole` (`id_evaluation_ecole`);

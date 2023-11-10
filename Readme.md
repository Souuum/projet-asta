Ce README à pour but d'expliquer les étapes pour démarrer l'application et ajouter des éléments dans la base de données.

## Etape 1 : Clone le repository
- Utiliser n'importe quels moyens (Github Desktop, etc) pour Clone le repository
- URL : https://github.com/Souuum/projet-asta.git


## Etape 2 : Assurer vous d'avoir bien setup WildFly
- Pour cela il faut avoir la même version que celle conseillé dans les cours de Programmation Avancée (ou ultérieur)


## Etape 3 : Creer le schéma et les tables
- Connecter vous à votre base de données MySQL en local et lancer utils/projet-asta.sql.
- Il faudra se connecter à la database et pas un schema.

## Etape 4 : Alimenter la Base de données
- Lancer utils/insert-date.sql en se connectant au schema projet-asta.

## Etape 5 : Ajouter vos credentials de base de données 
- Modifier le fichier src/main/ressources/persistence.xml avec vos credentials de base de données

## Etape 6 : Lancer l'application
- Faites attention à avoir mis un artifact war pour WildFly

## Etape 7 : Faites vos tests 
- On a un user TUTEUR qui a des apprenti
- Credentials : EMAIL : tuteur1@hotmail.com | PASSWORD : Password1

- On a un user TUTEUR qui n'a pas d'apprenti
- Credentials : EMAIL : tuteur1@hotmail.com | PASSWORD : Password1

- On a un APPRENTI qui n'a pas d'apprenti
- Credentials : EMAIL : tuteur1@hotmail.com | PASSWORD : Password1
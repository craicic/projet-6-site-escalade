
# Projet 6 : Site communautaire d'escalade
Projet étudiant Openclassrooms

## Fonctionnalités
Ce site permet créer un espace communautaire autour de l'escalade, les membres pourront :

 - S'inscrire, poster des commentaires,
 - Poster / consulter des information concernant des sites de grimpes,
 - Rendre accécible au prêt les topos que possèdent les membres.

## Description technique
L'application issue de ce projet repose sur une architecture multimodules.
Elle est packagée grâce à Maven. Le modèle MVC est réalisé via le framwork Struts 2. Enfin l'application utilise Spring IOC pour l'injection de dépendance et Spring Tx pour les transactions. L'application est déployée sur un serveur tomcat 9.

## Contenu
En plus de l'application, le dépôt contient un dossier documents, celui contient trois script des créations / remplissage de base de données :
- projet-6-script-creation-bdd-02-12.sql : création des tables
- projet-6-script-on-delete-escalade.sql : ajout de règles on delete
- projet-6-script-jeu-donnees.sql : remplissage des tables par jeu de données

 
Enfin ce dossier comporte des représentations du domaine fonctionnel et du modèle de données.
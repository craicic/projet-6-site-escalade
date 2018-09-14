<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<header>
    <s:if test="#session.utilisateur">
        Utilisateur connecté :
        <s:property value="#session.utilisateur.pseudo" />
        <s:a action="update_password">Changer de mot de passe</s:a>
        <s:a action="update_my_account">Editer mon compte</s:a>
        <s:a action="detail_my_account">Détail de mon compte</s:a>
        <s:a action="logout">Déconnexion</s:a>
    </s:if>
    <s:else>
        <s:a action="login">Connexion</s:a>
        <s:a action="utilisateur_new">Inscription</s:a>
    </s:else>
</header>

<nav>
    <s:a action="list_topo">
        Liste des topos
    </s:a>
    <s:a action="topo_new">
        Nouveau topo
    </s:a>
    <s:a action="list_utilisateur">
        Liste des utilisateurs
    </s:a>
    <s:a action="utilisateur_new">
        Nouvel utilisateur
    </s:a>
    <s:a action="list_site">
        Liste des sites
    </s:a>
    <s:a action="site_new">
        Nouveau site
    </s:a>
    <s:a action="list_secteur">
        Liste des secteurs
    </s:a>
    <s:a action="secteur_new">
        Nouveau secteur
    </s:a>
    <s:a action="list_voie">
        Liste des voies
    </s:a>
    <s:a action="voie_new">
        Nouvelle voie
    </s:a>
    <s:a action="index">
        Retour à l'index
    </s:a>
</nav>

<s:actionmessage/>
<s:actionerror/>
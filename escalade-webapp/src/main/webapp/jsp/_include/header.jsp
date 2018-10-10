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
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Dropdown
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<header>

</header>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Menu</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <s:a class="nav-link" action="index">Index <span class="sr-only">(current)</span></s:a>
            </li>

            <%-- NavLink --%>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">Link</a>--%>
            <%--</li>--%>


            <%-- Dropdown--%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    CRUD
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <s:a class="dropdown-item" action="list_topo">
                        Liste des topos
                    </s:a>
                    <s:a class="dropdown-item" action="topo_new">
                        Nouveau topo
                    </s:a>
                    <s:a class="dropdown-item" action="list_utilisateur">
                        Liste des utilisateurs
                    </s:a>
                    <s:a class="dropdown-item" action="utilisateur_new">
                        Nouvel utilisateur
                    </s:a>
                    <s:a class="dropdown-item" action="list_site">
                        Liste des sites
                    </s:a>
                    <s:a class="dropdown-item" action="site_new">
                        Nouveau site
                    </s:a>
                    <s:a class="dropdown-item" action="list_secteur">
                        Liste des secteurs
                    </s:a>
                    <s:a class="dropdown-item" action="secteur_new">
                        Nouveau secteur
                    </s:a>
                    <s:a class="dropdown-item" action="list_voie">
                        Liste des voies
                    </s:a>
                    <s:a class="dropdown-item" action="voie_new">
                        Nouvelle voie
                    </s:a>
                </div>
            </li>


            <s:if test="#session.utilisateur">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <s:property value="#session.utilisateur.pseudo"/>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <s:a class="dropdown-item" action="detail_my_account">Détail de mon compte</s:a>
                        <s:a class="dropdown-item" action="update_password">Changer de mot de passe</s:a>
                        <s:a class="dropdown-item" action="update_my_account">Editer mon compte</s:a>
                        <div class="dropdown-divider"></div>
                        <s:a class="dropdown-item" action="logout">Se déconnecter</s:a>
                    </div>
                </li>
            </s:if>
            <s:else>
                <li><s:a class="nav-link" action="login">Connexion</s:a></li>
                <li><s:a class="nav-link" action="utilisateur_new">Inscription</s:a></li>
            </s:else>

        </ul>
        <s:form class="form-inline my-2 my-lg-0" action="search">
            <input class="form-control mr-sm-2" type="search" placeholder="Rechercher" name="termeDeLaRecherche" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Go</button>
        </s:form>
    </div>
</nav>

<s:actionmessage/>
<s:actionerror/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>

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
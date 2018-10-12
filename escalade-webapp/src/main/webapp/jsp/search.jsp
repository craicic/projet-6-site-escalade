<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="./_include/head.jsp" %>
</head>

<%@ include file="./_include/header.jsp" %>

<body>

<h2>Resultat</h2>

<p>Mots recherchés : <s:property value="termeDeLaRecherche"/></p>

<ul class="list-group">
    <h5>Topos trouvés</h5>
<s:iterator value="listTopo">
    <li class="list-group-item">
        <div>Id : <s:property value="id"/></div>
        <div>Titre : <s:property value="titre"/></div>
        <div>Auteur : <s:property value="auteur"/></div>
        <div>Description : <s:property value="description"/></div>
    </li>
</s:iterator>
</ul>


<ul class="list-group">
    <h5>Sites trouvés</h5>
    <s:iterator value="listSite">
        <li class="list-group-item">
            <div>Id : <s:property value="id"/></div>
            <div>Nom : <s:property value="nom"/></div>
            <div>Description : <s:property value="description"/></div>
            <div>Roche : <s:property value="roche"/></div>
            <div>Profil : <s:property value="profil"/></div>
            <div>Type : <s:property value="type"/></div>
        </li>
    </s:iterator>
</ul>

<ul class="list-group">
    <h5>Secteurs trouvés</h5>
    <s:iterator value="listSecteur">
        <li class="list-group-item">
            <div>Id : <s:property value="id"/></div>
            <div>Nom : <s:property value="nom"/></div>
            <div>Description : <s:property value="description"/></div>
        </li>
    </s:iterator>
</ul>

<ul class="list-group">
    <h5>Voies trouvés</h5>
    <s:iterator value="listVoie">
        <li class="list-group-item">
            <div>Id : <s:property value="id"/></div>
            <div>Nom : <s:property value="nom"/></div>
            <div>Description : <s:property value="description"/></div>
            <div>Nombre de points : <s:property value="nombreDePoints"/></div>
            <div>Nombre de longueurs : <s:property value="nombreDeLongueurs"/></div>
            <div>Cotation : <s:property value="cotation"/></div>
            <div>Hauteur : <s:property value="hauteur"/></div>
            <div>Id du secteur associé <s:property value ="secteurId"/></div>
        </li>
    </s:iterator>
</ul>


</body>
</html>
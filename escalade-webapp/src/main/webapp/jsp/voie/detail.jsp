<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<head>
    <%@include file="../_include/head.jsp" %>
</head>

<%@ include file="../_include/header.jsp"%>

<body>

<h2>Détail d'un voie</h2>

<ul>
    <li>ID : <s:property value="voie.id"/></li>
    <li>Nom : <s:property value="voie.nom"/></li>
    <li>Description : <s:property value="voie.description"/></li>
    <li>Nombre de points : <s:property value="voie.nombreDePoints"/></li>
    <li>Nombre de longueurs : <s:property value="voie.nombreDeLongueurs"/></li>
    <li>Cotation : <s:property value="voie.cotation"/></li>
    <li>Hauteur : <s:property value="voie.hauteur"/></li>
    <li>Secteur associé : <s:property value="voie.secteurId"/></li>
</ul>
</body>
</html>

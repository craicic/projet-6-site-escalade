<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<head>
    <%@include file="../_include/head.jsp" %>
</head>

<%@ include file="../_include/header.jsp" %>
<body>
<div class="container-fluid">
<h2>Détail de mon compte</h2>

<ul>
    <li>ID : <s:property value="utilisateur.id"/></li>
    <li>Nom : <s:property value="utilisateur.nom"/></li>
    <li>Prenom : <s:property value="utilisateur.prenom"/></li>
    <li>Pseudo : <s:property value="utilisateur.pseudo"/></li>
    <li>Adresse : <s:property value="utilisateur.adresse"/></li>
    <li>Description : <s:property value="utilisateur.description"/></li>
    <li>Adresse mail : <s:property value="utilisateur.adresseMail"/></li>
    <li>Date d'inscription : <s:property value="utilisateur.dateInscription"/></li>
    <li>UUID : <s:property value="utilisateur.uuid"/></li>
</ul>
</div>
</body>
</html>
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
    <h2>Détail d'un utilisateur</h2>

    <ul>
        <li>Pseudo : <s:property value="utilisateur.pseudo"/></li>
        <li>Description : <s:property value="utilisateur.description"/></li>
        <li>Date d'inscription : <s:property value="utilisateur.dateInscription"/></li>
        <li>Adresse : <s:property value="utilisateur.adresse"/></li>
    </ul>
</div>
</body>
</html>
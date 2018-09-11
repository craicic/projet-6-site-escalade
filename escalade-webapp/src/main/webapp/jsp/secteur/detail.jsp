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

<h2>Détail d'un secteur</h2>

<ul>
    <li>ID : <s:property value="secteur.id"/></li>
    <li>Nom : <s:property value="secteur.nom"/></li>
    <li>Description : <s:property value="secteur.description"/></li>
    <%-- todo coord GPS --%>
    <li>Site associé : <s:property value="secteur.siteId"/></li>
</ul>
<%--<p><s:a action="voie_new">nouvelle voie associée</s:a></p>--%>
</body>
</html>

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

<h2>Détail d'un topo</h2>

<ul>
    <li>ID : <s:property value="topo.id"/></li>
    <li>Titre : <s:property value="topo.titre"/></li>
    <li>Auteur : <s:property value="topo.auteur"/></li>
    <li>Description : <s:property value="topo.description"/></li>
    <li>Dispo à l'empreint : <s:property value="topo.empreintable"/></li>
</ul>
<p><s:a action="commentaire_new">
    <s:param name="objectType" value="topo"/>
    Rédiger un commentaire</s:a></p>
</body>
</html>

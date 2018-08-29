<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<head>
    <%@include file="../_include/head.jsp" %>
</head>

<body>
<s:actionmessage/>

<h2>Détail d'un topo</h2>

<ul>
    <li>ID : <s:property value="topo.id"/></li>
    <li>Titre : <s:property value="topo.titre"/></li>
    <li>Auteur : <s:property value="topo.auteur"/></li>
    <li>Description : <s:property value="topo.description"/></li>
</ul>
</body>
</html>

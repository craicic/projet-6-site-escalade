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

<h2>Détail d'un site</h2>

<ul>
    <li>ID : <s:property value="site.id"/></li>
    <li>Nom : <s:property value="site.nom"/></li>
    <li>Description : <s:property value="site.description"/></li>
    <li>Profils : <s:property value="site.profils"/></li>
    <li>Roche : <s:property value="site.roche"/></li>
    <li>Type : <s:property value="site.type"/></li>
</ul>
</body>
</html>

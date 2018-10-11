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

<p><s:property value="termeDeLaRecherche"/></p>

<ul class="list-group">
<s:iterator value="listTopo">
    <li class="list-group-item">
        <div>Id : <s:property value="id"/></div>
        <div>Titre : <s:property value="titre"/></div>
        <div>Auteur : <s:property value="auteur"/></div>
        <div>Description : <s:property value="description"/></div>
    </li>
</s:iterator>
</ul>

</body>
</html>
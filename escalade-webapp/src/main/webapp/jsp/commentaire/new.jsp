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

<h2>Saisie d'un nouveau commentaire</h2>

<s:form action="commentaire_new">
    <s:textarea name="commentaire.contenuTexte" label="Commentaire" requiredLabel="false" cols="32" rows="9"/>
    <!-- todo enlever ce fix de recupération d'id lorsque j'aurai implémenté les sessions utilisateurs -->
    <s:hidden name="utilisateur.id" value="1"/>
    <s:submit value="Ok"/>
</s:form>

</body>
</html>
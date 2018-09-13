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

<h2>Modifier le mot de passe</h2>

<s:form action="update_password">
    <s:password name="utilisateur.hashMotDePasse" label="Ancien mot de Passe" requiredLabel="true"/>
    <s:password name="nouveauMotDePasse" label="Nouveau mot de Passe" requiredLabel="true"/>
    <s:password name="motDePasseDoubleVerifiction" label="Vérif mot de passe" requiredLabel="true"/>

    <s:hidden name="utilisateur.id" value="%{id}"/>
    <s:submit value="Ok"/>
</s:form>

</body>
</html>
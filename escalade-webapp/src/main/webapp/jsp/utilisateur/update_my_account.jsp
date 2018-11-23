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
<div class="container-fluid">
<h2>Modifier mon compte</h2>

<s:form action="update_my_account">
    <s:textfield  name="utilisateur.nom" label="Nom" requiredLabel="true"/>
    <s:textfield name="utilisateur.prenom" label="Prenom" requiredLabel="false"/>
    <s:textfield name="utilisateur.pseudo" label="Pseudo" requiredLabel="true"/>
    <s:textfield name="utilisateur.adresseMail" label="Adresse mail" requiredLabel="true"/>
    <s:textarea name="utilisateur.description" label="Description" requiredLabel="false" cols="32" rows="9"/>
    <s:textarea name="utilisateur.adresse" label="Adresse" requiredLabel="false" cols="32" rows="9"/>
    <s:submit value="Ok"/>
</s:form>

</div>
</body>
</html>

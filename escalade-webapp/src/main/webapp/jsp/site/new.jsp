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
<h2>Saisie d'un nouveau site</h2>

<s:form action="site_new">
    <s:textfield  name="site.nom" label="Nom" requiredLabel="true"/>
    <s:textarea name="site.description" label="Description" requiredLabel="false" cols="32" rows="9"/>
    <s:textfield name="site.profil" label="Profil" requiredLabel="true"/>
    <s:textfield name="site.roche" label="Roche" requiredLabel="true"/>
    <s:textfield name="site.type" label="Type" requiredLabel="true"/>
    <s:textfield name="site.coordonneeX" label="GPS X" requiredLabel="false"/>
    <s:textfield name="site.coordonneeY" label="GPS X" requiredLabel="false"/>

    <s:submit value="Ok"/>
</s:form>
</div>
</body>
</html>
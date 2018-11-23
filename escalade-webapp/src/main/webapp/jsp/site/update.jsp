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
<h2>Modifier un site</h2>

<s:form action="update_site">
    <s:textfield  name="site.nom" label="Nom" requiredLabel="true"/>
    <s:textarea name="site.description" label="Description" requiredLabel="false" cols="32" rows="9"/>
    <s:textfield name="site.profil" label="Profil" requiredLabel="false"/>
    <s:textfield name="site.roche" label="Roche" requiredLabel="false"/>
    <s:textfield name="site.type" label="Type" requiredLabel="false"/>
    <s:hidden name="site.id" value="%{id}"/>
    <s:submit value="Ok"/>
</s:form>
</div>
</body>
</html>

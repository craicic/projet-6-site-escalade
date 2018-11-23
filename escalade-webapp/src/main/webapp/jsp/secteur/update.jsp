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
<h2>Modifier un secteur</h2>

<s:form action="update_secteur">
    <s:textfield  name="secteur.nom" label="Nom" requiredLabel="true"/>
    <s:textarea name="secteur.description" label="Description" requiredLabel="false" cols="32" rows="9"/>
    <s:select name="secteur.siteId" Label="Site"
              list="listSite" listKey="id" listValue="nom"
              emptyOption="false"
              requiredLabel="true"/>
    <s:hidden name="secteur.id" value="%{id}"/>
    <s:submit value="Ok"/>
</s:form>
</div>
</body>
</html>

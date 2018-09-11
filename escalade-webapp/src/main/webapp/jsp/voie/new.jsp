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

<h2>Saisie d'un nouvelle voie</h2>

<s:form action="voie_new">
    <s:textfield name="voie.nom" label="Nom" requiredLabel="true"/>
    <s:textarea name="voie.description" label="Description" requiredLabel="false" cols="32" rows="9"/>
    <s:textfield name="voie.nombreDePoints" label="Nombre de points" requiredLabel="true"/>
    <s:textfield name="voie.nombreDeLongueurs" label="Nombre de longueurs" requiredLabel="true"/>
    <s:textfield name="voie.cotation" label="Cotation" requiredLabel="true"/>
    <s:textfield name="voie.hauteur" label="Hauteur" requiredLabel="true"/>
    <s:select name="voie.secteurId" Label="Secteur"
              list="listSecteur" listKey="id" listValue="nom"
              emptyOption="false"
              requiredLabel="true"/>
    <s:submit value="Ok"/>
</s:form>

</body>
</html>
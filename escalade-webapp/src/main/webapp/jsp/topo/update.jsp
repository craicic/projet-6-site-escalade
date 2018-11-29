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
<div class="container-fluid">
    <h2>Modifier un topo</h2>


    <s:form action="update_topo">
        <s:textfield name="topo.titre" label="Titre" requiredLabel="true"/>
        <s:textfield name="topo.auteur" label="Auteur" requiredLabel="false"/>
        <s:textarea name="topo.description" label="Description" requiredLabel="false" cols="32" rows="9"/>
        <s:hidden name="topo.id" value="%{id}"/>
        <s:hidden name="topo.proprietaireId" value="%{topo.getProprietaireId()}"/>
        <s:submit value="Ok"/>
    </s:form>
    s
    <div><s:a action="delete_topo">
        <s:param name="id" value="id"/>
        Supprimer
    </s:a></div>
</div>
</body>
</html>

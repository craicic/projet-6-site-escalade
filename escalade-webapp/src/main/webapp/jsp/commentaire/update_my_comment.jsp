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

<h2>Édition de mon commentaire</h2>

<%-- actionName est défini dans GestionCommentaireAction --%>
<s:form action="%{actionName}">
    <s:textarea name="commentaire.contenuTexte" label="Commentaire" requiredLabel="false" cols="32" rows="9"/>
    <s:hidden name="commentaire.id" value="%{id}"/>
    <s:hidden name="topo.id" value="%{topo.id}"/>
    <s:hidden name="site.id" value="%{site.id}"/>
    <s:hidden name="voie.id" value="%{voie.id}"/>
    <s:submit value="Ok"/>
</s:form>

</body>
</html>
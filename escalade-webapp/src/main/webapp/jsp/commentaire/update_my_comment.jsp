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

<%-- TODO ATTENTION CETTE METHODE EST NULLE CAR ON PEUT MODIFIER NIMPORTE QUEL COMMENTAIRE EN MODIFIANT LE PARAM ID DANS LE NAVIGATEUR --%>
<s:form action="update_my_comment">
    <s:textarea name="commentaire.contenuTexte" label="Commentaire" requiredLabel="false" cols="32" rows="9"/>
    <s:hidden name="commentaire.id" value="%{id}"/>
    <s:submit value="Ok"/>
</s:form>

</body>
</html>
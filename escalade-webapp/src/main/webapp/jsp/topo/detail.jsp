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

<h2>Détail d'un topo</h2>

<ul>
    <li>ID : <s:property value="topo.id"/></li>
    <li>Titre : <s:property value="topo.titre"/></li>
    <li>Auteur : <s:property value="topo.auteur"/></li>
    <li>Description : <s:property value="topo.description"/></li>
    <li>Dispo à l'empreint : <s:property value="topo.empreintable"/></li>
</ul>
<%--<p><s:a action="commentaire_new">--%>
    <%--<s:param name="objectType" value="topo"/>--%>
    <%--Rédiger un commentaire</s:a></p>--%>
<s:if test="#session.utilisateur">
    <s:form action="add_comment_topo">
        <s:textarea name="commentaire.contenuTexte" label="Votre commentaire"/>
        <s:hidden name="id" value="%{id}"/>
        <s:submit value="Ok"/>
    </s:form>
</s:if>
<s:else>
    <s:a action="login">Connectez vous pour écrire un commentaire.</s:a>
</s:else>
<!-- todo afficher la liste des commentaire -->
<ul>
    <s:iterator value="listCommentaire">
        <li>
            <div>Auteur : <s:property value="utilisateurId"/></div>
            <!-- todo résoudre le probleme de dateCréation : il doit être de type timestamp et non date -->
            <div>Posté à <s:property value="dateCreation"/></div>
            <div><s:property value="contenuTexte"/></div>
        </li>
    </s:iterator>
</ul>
</body>
</html>

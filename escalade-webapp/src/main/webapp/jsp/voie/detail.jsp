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

<h2>Détail d'un voie</h2>

<ul>
    <li>ID : <s:property value="voie.id"/></li>
    <li>Nom : <s:property value="voie.nom"/></li>
    <li>Description : <s:property value="voie.description"/></li>
    <li>Nombre de points : <s:property value="voie.nombreDePoints"/></li>
    <li>Nombre de longueurs : <s:property value="voie.nombreDeLongueurs"/></li>
    <li>Cotation : <s:property value="voie.cotation"/></li>
    <li>Hauteur : <s:property value="voie.hauteur"/></li>
    <li>
        <s:a action="detail_secteur">
        Secteur associé : <s:property value="secteur.nom"/>
    <s:param name="id" value="secteur.id"/>
    </s:a>
    </li>
</ul>

<s:if test="#session.utilisateur">
    <s:form action="add_comment_voie">
        <s:textarea name="commentaire.contenuTexte" label="Votre commentaire"/>
        <s:hidden name="id" value="%{id}"/>
        <s:submit value="Ok"/>
    </s:form>
</s:if>
<s:else>
    <s:a action="login">Connectez vous pour écrire un commentaire.</s:a>
</s:else>

<ul>
    <s:iterator value="listCommentaire">
        <li>
            <div>Auteur : <s:property value="utilisateur.pseudo"/></div>
            <div>Posté à <s:property value="dateCreation"/></div>
            <div><s:property value="contenuTexte"/></div>
            <s:if test="%{utilisateurId == #session.utilisateur.id}">
                <s:a action="delete_commentaire_voie">
                    <s:param name="id" value="id"/>
                    <s:param name="voie.id" value="%{voie.id}"/>
                    Supprimer
                </s:a>
                <s:a action="update_my_comment_voie">
                    <s:param name="id" value="id"/>
                    <s:param name="voie.id" value="%{voie.id}"/>
                    Éditer
                </s:a>
            </s:if>
        </li>
    </s:iterator>
</ul>
</body>
</html>

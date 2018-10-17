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

<h2>Détail d'un site</h2>

<ul>
    <li>ID : <s:property value="site.id"/></li>
    <li>Nom : <s:property value="site.nom"/></li>
    <li>Description : <s:property value="site.description"/></li>
    <li>Profil : <s:property value="site.profil"/></li>
    <li>Roche : <s:property value="site.roche"/></li>
    <li>Type : <s:property value="site.type"/></li>

    <s:iterator value="listSecteur">

        <%-- Test sur les differentes valeurs --%>
        <%--<div>siteId : <s:property value="siteId"/></div>--%>
        <%--<div>%siteId : <s:property value="%{siteId}"/></div>--%>
        <%--<div>secteur.siteId : <s:property value="secteur.siteId"/></div>--%>
        <%--<div>%secteur.siteId : <s:property value="%{secteur.siteId}"/></div>--%>
        <%--<div>site.id : <s:property value="site.id"/></div>--%>
        <%--<div>%site.id : <s:property value="%{site.id}"/></div>--%>
        <%--<div>id : <s:property value="id"/></div>--%>
        <%--<div>%id : <s:property value="%{id}"/></div>--%>
        <%--<div>secteur.id : <s:property value="secteur.id"/></div>--%>
        <%--<div>%secteur.id : <s:property value="%{secteur.id}"/></div>--%>

        <s:if test="%{siteId eq site.id}">
            <li><s:a action="detail_secteur">
                <s:param name="id" value="id"/>
                Secteur associé : <s:property value="nom"/>
            </s:a></li>
        </s:if>
    </s:iterator>
</ul>


<div>
    <s:a action="secteur_new">nouveau secteur associé
        <s:param name="secteur.siteId" value="id"/>
    </s:a>
</div>

<s:if test="#session.utilisateur">
    <s:form action="add_comment_site">
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
                <s:a action="delete_commentaire">
                    <s:param name="id" value="id"/>
                    Supprimer
                </s:a>
                <s:a action="update_my_comment">
                    <s:param name="id" value="id"/>
                    Éditer
                </s:a>
            </s:if>
        </li>
    </s:iterator>
</ul>
</body>
</html>

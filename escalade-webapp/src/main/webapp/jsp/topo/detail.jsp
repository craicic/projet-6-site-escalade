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

<h2>Détail d'un topo</h2>

<ul>
    <li>ID : <s:property value="topo.id"/></li>
    <li>Titre : <s:property value="topo.titre"/></li>
    <li>Auteur : <s:property value="topo.auteur"/></li>
    <li>Description : <s:property value="topo.description"/></li>
    <li>Dispo à l'emprunt : <s:property value="topo.empreintable"/></li>
</ul>

<%-- Liste des sites associés --%>
<s:iterator value="listSite">
    <div>
        <s:a action="detail_site">
        <s:param name="id" value="id"/>
        <s:property value="nom"/>
    </s:a>
        <s:a action="delete_link">
            <s:param name="topo.id" value="%{topo.id}"/>
            <s:param name="site.id" value="id"/>
            Supprimer l'association
        </s:a>
    </div>
</s:iterator>

<%--<div><s:a action="site_new">--%>
<%--<s:param name="id" value="id"/>--%>
<%--Créer un nouveau site--%>
<%--</s:a></div>--%>

<div><s:a action="link_site_topo">
    <s:param name="id" value="id"/>
    Lier ce topo à un site existant
</s:a></div>

<%-- ==== Commentaires ==== --%>
<s:if test="#session.utilisateur">
    <%-- Je peut preter ce topo--%>
    <%-- todo n'afficher ce bouton si aucune entrée en bdd --%>
    <div>Je possède ce topo, et décide de le prêter
        <s:a action="mark_my_topo_as_reservable">
            <s:param name="topo.id" value="%{topo.id}"/>
            <button type="button" class="btn btn-success">Prêter ce topo</button>
        </s:a>
    </div>

    <%-- Poster un commantaire --%>
    <s:form action="add_comment_topo">
        <s:textarea name="commentaire.contenuTexte" label="Votre commentaire"/>
        <s:hidden name="id" value="%{id}"/>
        <s:submit value="Ok"/>
    </s:form>
</s:if>
<s:else>
    <s:a action="login">Connectez vous pour écrire un commentaire.</s:a>
</s:else>
<%-- Liste des commentaires --%>
<ul>
    <s:iterator value="listCommentaire">
        <li>
            <div>Auteur : <s:property value="utilisateur.pseudo"/></div>
            <div>Posté à <s:property value="dateCreation"/></div>
            <div><s:property value="contenuTexte"/></div>
            <s:if test="%{utilisateurId == #session.utilisateur.id}">
                <s:a action="delete_commentaire_topo">
                    <s:param name="id" value="%{id}"/>
                    <s:param name="topo.id" value="%{topo.id}"/>
                    Supprimer
                </s:a>
                <s:a action="update_my_comment_topo">
                    <s:param name="id" value="id"/>
                    <s:param name="topo.id" value="%{topo.id}"/>
                    Éditer
                </s:a>
            </s:if>
        </li>
    </s:iterator>
</ul>


</body>
</html>

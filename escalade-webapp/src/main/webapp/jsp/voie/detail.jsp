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
    <div class="row">
        <div class="col-lg-8">
            <h2>Détail d'un voie</h2>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Nom</th>
                    <th scope="col">Nombre de points</th>
                    <th scope="col">Nombre de longueurs</th>
                    <th scope="col">Cotation</th>
                    <th scope="col">Hauteur</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td scope="row"><s:property value="voie.nom"/></td>
                    <td><s:property value="voie.nombreDePoints"/></td>
                    <td><s:property value="voie.nombreDeLongueurs"/></td>
                    <td><s:property value="voie.cotation"/></td>
                    <td><s:property value="voie.hauteur"/></td>
                </tr>
                </tbody>
            </table>

            <p>Description : <s:property value="voie.description"/></p>
        </div>
        <div class="col-lg-4">
            <h5>Secteur associé :</h5>
            <s:a action="detail_secteur">
                <div><s:property value="secteur.nom"/></div>
                <s:param name="id" value="secteur.id"/>
            </s:a>

            <s:if test="#session.utilisateur">
                <h5>Édition de la voie</h5>
                <div><s:a action="update_voie">
                    <s:param name="id" value="%{id}"/>
                    Éditer cette voie
                </s:a></div>
                <div><s:a action="delete_voie">
                    <s:param name="id" value="%{id}"/>
                    Supprimer cette voie
                </s:a></div>
            </s:if>
        </div>
    </div>
    <div class="row">
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

        <ul class="list-group">
            <s:iterator value="listCommentaire">
                <li class="list-group-item">
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
    </div>
</div>

</body>
</html>

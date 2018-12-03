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
            <h2>Détail de <s:property value="topo.titre"/></h2>

            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Titre</th>
                    <th scope="col">Auteur</th>
                    <th scope="col">Propriétaire</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td scope="row"><s:property value="topo.titre"/></td>
                    <td><s:property value="topo.auteur"/></td>
                    <td><s:property value="proprietaire.pseudo"/></td>
                </tr>
                </tbody>
            </table>

            <div><p>Description : <s:property value="topo.description"/></p></div>
        </div>

        <div class="col-lg-4">

            <s:if test="%{listSite.isEmpty()}">
                Ce topo n'est lié a aucun site.
            </s:if>
            <s:else>
                <div>Sites liés à ce topo :</div>
                <s:iterator value="listSite">
                    <div>
                        <s:a action="detail_site">
                            <s:param name="id" value="id"/>
                            <s:property value="nom"/>
                        </s:a>
                        <s:if test="#session.utilisateur">
                            <s:a action="delete_link">
                                <s:param name="topo.id" value="%{topo.id}"/>
                                <s:param name="site.id" value="id"/>
                                Supprimer l'association
                            </s:a>
                        </s:if>
                    </div>
                </s:iterator>
            </s:else>
            <%-- ==== Pour les users connectés ==== --%>
            <%-- ==== Commentaires & Reservation ==== --%>
            <s:if test="#session.utilisateur">
                <%-- Édition du topo --%>
                <div><s:a action="update_topo">
                    <s:param name="id" value="%{id}"/>
                    Éditer ce topo
                </s:a></div>
                <%-- Réservation --%>
                <s:if test="%{reservedFlag eq true}">
                    <div>Réservé jusqu'au <s:property value="emprunt.dateRetour"/></div>
                </s:if>
                <s:else>
                    <%-- Le propriétaire ne peut emprunter son topo --%>
                    <s:if test="%{!(#session.utilisateur.pseudo eq proprietaire.pseudo)}">
                        <div><s:a action="borrow">
                            <s:param name="topo.id" value="%{id}"/>
                            Réserver ce topo</s:a></div>
                    </s:if>
                    <s:else>
                        <div>Ce topo vous appartient</div>
                    </s:else>
                </s:else>

                <%-- lié un site à ce topo --%>
                <div><s:a action="link_site_topo">
                    <s:param name="id" value="id"/>
                    Lier ce topo à un site existant
                </s:a></div>
            </s:if>
        </div>
    </div>

    <%-- Poster un commantaire --%>
    <div class="row">
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
    </div>
    <div class="row">
        <%-- Liste des commentaires --%>
        <ul class="list-group">
            <s:iterator value="listCommentaire">
                <li class="list-group-item">
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
    </div>
</body>
</html>

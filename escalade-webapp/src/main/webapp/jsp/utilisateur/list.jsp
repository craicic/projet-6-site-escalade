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

<h2>Liste des utilisateurs</h2>

<ul>
    <s:iterator value="listUtilisateur">
        <li>
            <div>ID : <s:property value="id"/></div>
            <div>Nom : <s:property value="nom"/></div>
            <div>Prenom : <s:property value="prenom"/></div>
            <div>Pseudo : <s:property value="pseudo"/></div>
            <div>Adresse : <s:property value="adresse"/></div>
            <div>Description : <s:property value="description"/></div>
            <div>Adresse mail : <s:property value="adresseMail"/></div>
            <div>Date d'inscription : <s:property value="dateInscription"/></div>
            <div>UUID : <s:property value="uuid"/></div>
            <div><s:a action="detail_utilisateur">
                <s:param name="id" value="id"/>
                détail de l'utilisateur
            </s:a></div>
            <div><s:a action="update_utilisateur">
                <s:param name="id" value="id"/>
                modifier
            </s:a></div>
            <div><s:a action="delete_utilisateur">
                <s:param name="id" value="id"/>
                supprimer
            </s:a></div>
        </li>
    </s:iterator>
</ul>
</body>
</html>
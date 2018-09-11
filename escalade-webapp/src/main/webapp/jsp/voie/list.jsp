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
<h2>Liste des Secteur</h2>

<ul>
    <s:iterator value="listVoie">
        <li>
            <div>ID : <s:property value="id"/></div>
            <div>Nom : <s:property value="nom"/></div>
            <div>Description : <s:property value="description"/></div>
            <div>Nombre de points : <s:property value="nombreDePoints"/></div>
            <div>Nombre de longueurs : <s:property value="nombreDeLongueurs"/></div>
            <div>Cotation : <s:property value="cotation"/></div>
            <div>Hauteur : <s:property value="hauteur"/></div>
            <div>Secteur associé : <s:property value="secteurId"/></div>
            <div><s:a action="detail_voie">
                <s:param name="id" value="id"/>
                détail de la voie
            </s:a></div>
            <div><s:a action="update_voie">
                <s:param name="id" value="id"/>
                modifier
            </s:a></div>
            <div><s:a action="delete_voie">
                <s:param name="id" value="id"/>
                supprimer
            </s:a></div>
        </li>
    </s:iterator>
</ul>
</body>
</html>

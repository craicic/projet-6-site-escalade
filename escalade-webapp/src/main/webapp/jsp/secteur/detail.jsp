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

<h2>Détail d'un secteur</h2>

<ul>
    <li>ID : <s:property value="secteur.id"/></li>
    <li>Nom : <s:property value="secteur.nom"/></li>
    <li>Description : <s:property value="secteur.description"/></li>
    <%-- todo coord GPS --%>
    <li>Site associé : <s:property value="secteur.siteId"/></li>
</ul>

<s:iterator value="listVoie">

    <%-- Test sur les differentes valeurs --%>
    <%--<div>secteurId : <s:property value="secteurId"/></div>--%>
    <%--<div>%secteurId : <s:property value="%{secteurId}"/></div>--%>
    <%--<div>voie.secteurId : <s:property value="voie.secteurId"/></div>--%>
    <%--<div>%voie.secteurId : <s:property value="%{voie.secteurId}"/></div>--%>
    <%--<div>secteur.id : <s:property value="secteur.id"/></div>--%>
    <%--<div>%secteur.id : <s:property value="%{secteur.id}"/></div>--%>
    <%--<div>id : <s:property value="id"/></div>--%>
    <%--<div>%id : <s:property value="%{id}"/></div>--%>
    <%--<div>voie.id : <s:property value="voie.id"/></div>--%>
    <%--<div>%voie.id : <s:property value="%{voie.id}"/></div>--%>

    <%--<s:if test="%{secteurId eq secteur.id}">--%>
        <li><s:a action="detail_voie">
            <s:param name="id" value="id"/>
            Voie associée : <s:property value="nom"/>
        </s:a></li>
    <%--</s:if>--%>
</s:iterator>

<div>
    <s:a action="voie_new">nouvelle voie associée
        <s:param name="voie.secteurId" value="id"/>
    </s:a>
</div>

</body>
</html>

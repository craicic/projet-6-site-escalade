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

<h2>Détail d'un site</h2>

<ul>
    <li>ID : <s:property value="site.id"/></li>
    <li>Nom : <s:property value="site.nom"/></li>
    <li>Description : <s:property value="site.description"/></li>
    <li>Profil : <s:property value="site.profil"/></li>
    <li>Roche : <s:property value="site.roche"/></li>
    <li>Type : <s:property value="site.type"/></li>
    <s:iterator value="listSecteur">
        <s:property value="siteId"/>
        <s:property value="id"/>
        <%-- todo fixer cette condition qui ne marche pas --%>
        <s:if test="%{siteId == id}">
        <li><s:a action="detail_secteur">
            <s:param name="id" value="id"/>
            Secteur associé : <s:property value="nom"/>
        </s:a></li>
        </s:if>
    </s:iterator>
    <iframe
            width="600"
            height="450"
            frameborder="0" style="border:0"
            src="https://www.google.com/maps/embed/v1/place?key=&q=Space+Needle,Seattle+WA" allowfullscreen>
    </iframe>
</ul>
<p><s:a action="secteur_new">nouveau secteur associé</s:a></p>
</body>
</html>

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
<h2>Liste des sites</h2>

<ul class="list-group">
    <s:iterator value="listSite">
        <li class="list-group-item">
            <div>ID : <s:property value="id"/></div>
            <div>Nom : <s:property value="nom"/></div>
            <div>Description : <s:property value="description"/></div>
            <div>Profil : <s:property value="profil"/></div>
            <div>Roche : <s:property value="roche"/></div>
            <div>Type : <s:property value="type"/></div>
            <div><s:a action="detail_site">
                <s:param name="id" value="id"/>
                détail du site
            </s:a></div>
            <div><s:a action="update_site">
                <s:param name="id" value="id"/>
                modifier
            </s:a></div>
            <div><s:a action="delete_site">
                <s:param name="id" value="id"/>
                supprimer
            </s:a></div>
        </li>
    </s:iterator>
</ul>
</body>
</html>

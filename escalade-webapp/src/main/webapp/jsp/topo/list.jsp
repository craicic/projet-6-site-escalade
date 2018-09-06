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
<h2>Liste des topos</h2>

<ul>
    <s:iterator value="listTopo">
        <li>
            <div>ID : <s:property value="id"/></div>
            <div>Titre : <s:property value="titre"/></div>
            <div>Auteur : <s:property value="auteur"/></div>
            <div>Description : <s:property value="description"/></div>
            <div><s:a action="detail_topo">
                <s:param name="id" value="id"/>
                détail du topo
            </s:a></div>
            <div><s:a action="update_topo">
                <s:param name="id" value="id"/>
                modifier
            </s:a></div>
            <div><s:a action="delete_topo">
                <s:param name="id" value="id"/>
                supprimer
            </s:a></div>
        </li>
    </s:iterator>
</ul>
</body>
</html>

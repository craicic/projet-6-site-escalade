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
<s:if test="%{listAvailableTopo.isEmpty()}">
    <p>Aucun topo disponible à l'heure actuelle.</p>
</s:if>
<s:else>
    <ul class="list-group">
        <s:iterator value="listAvailableTopo">
            <li class="list-group-item">
                <div>Titre : <s:property value="titre"/></div>
                <div>Auteur : <s:property value="auteur"/></div>
                <div>Description : <s:property value="description"/></div>
                <div><s:a action="detail_topo">
                    <s:param name="id" value="id"/>
                    Détail du topo
                </s:a></div>
            </li>
        </s:iterator>
    </ul>
</s:else>
</div>
</body>
</html>
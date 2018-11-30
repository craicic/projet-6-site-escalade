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

    <h2>Liste des utilisateurs</h2>

    <ul class="list-group">
        <s:iterator value="listUtilisateur">
            <li class="list-group-item">
                <div><s:a action="detail_utilisateur">
                    <s:property value="pseudo"/>
                    <s:param name="id" value="id"/>
                </s:a></div>
                <div>Description : <s:property value="description"/></div>
                <div>Date d'inscription : <s:property value="dateInscription"/></div>
            </li>
        </s:iterator>
    </ul>
</div>
</body>
</html>
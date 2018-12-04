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
    <h2>Détail d'un utilisateur</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Pseudo</th>
            <th scope="col">Adresse</th>
            <th scope="col">Date d'inscription</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td scope="row"><s:property value="utilisateur.pseudo"/></td>
            <td><s:property value="utilisateur.adresse"/></td>
            <td><s:property value="utilisateur.dateInscription"/></td>
        </tr>
        </tbody>
    </table>
    <p>Description : <s:property value="utilisateur.description"/></p>
</div>
</body>
</html>
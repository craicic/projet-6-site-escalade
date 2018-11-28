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
    <h3>Mes emprunts</h3>
    <ul class="list-group">
        <s:iterator value="listBorrowedTopo">
            <li class="list-group-item">
                <div>Titre du topo : <s:property value="titre"/></div>
                <div>Description : <s:property value="description"/></div>
            </li>
        </s:iterator>
    </ul>

    <h3>Mes prêts en cours</h3>
    <ul class="list-group">
        <s:iterator value="listLoanedTopo">
            <li class="list-group-item">
                <div>Titre du topo : <s:property value="titre"/></div>
                <div>Description : <s:property value="description"/></div>
                <s:if test="%{true}">
                    <div>Emprunté du <s:property value="emprunt.dateEmprunt"/> au <s:property
                            value="emprunt.dateRetour"/>
                        par <s:a action="detail_utilisateur">
                            <s:param name="id" value="emprunteur.id"/>
                            <s:property value="emprunteur.pseudo"/>
                        </s:a></div>
                </s:if>
            </li>
        </s:iterator>
    </ul>

    <h3>En attente d'emprunt</h3>
    <ul class="list-group">
        <s:iterator value="listAvailableTopo">
            <li class="list-group-item">
                <div>Titre du topo : <s:property value="titre"/></div>
                <div>Description : <s:property value="description"/></div>
            </li>
        </s:iterator>
    </ul>
</div>
</body>
</html>

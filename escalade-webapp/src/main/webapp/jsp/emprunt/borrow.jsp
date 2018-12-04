<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<head>
    <%@include file="../_include/head.jsp" %>
    <sx:head/>
</head>

<%@ include file="../_include/header.jsp" %>
<body>

<div class="container-fluid">

    <s:if test="%{!listEmprunt.isEmpty()}">
        <h5>Historique de réservation</h5>
    </s:if>
    <ul class="list-group">
        <s:iterator value="listEmprunt">
            <li class="list-group-item">
                <div>Date d'emprunt : <s:property value="dateEmprunt"/></div>
                <div>Date de retour : <s:property value="dateRetour"/></div>
                <div>Emprunteur : <s:property value="emprunteur.pseudo"/></div>
            </li>
        </s:iterator>

    </ul>
    <h5>Choisissez une date de retour</h5>
    <s:form action="borrow">

        <sx:datetimepicker name="date" label="Format (dd-MMM-yyyy)"
                           displayFormat="dd-MMM-yyyy" value="todayDate"/>
        <s:hidden name="topo.id" value="%{topo.id}"/>
        <s:submit value="Ok"/>
    </s:form>
</div>

</body>
</html>

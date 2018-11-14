<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<head>
    <%@include file="../_include/head.jsp" %>

</head>

<%@ include file="../_include/header.jsp" %>

<h3>Mes emprunts</h3>
<ul>
    <s:iterator value="listBorrowedTopo">
        <li>
            <div>Titre du topo : <s:property value="titre"/></div>
            <div>Description : <s:property value="description"/></div>
        </li>
    </s:iterator>
</ul>

<h3>Mes prêts</h3>
<ul>
    <s:iterator value="listLoanedTopo">
        <li>
            <div>Titre du topo : <s:property value="titre"/></div>
            <div>Description : <s:property value="description"/></div>
        </li>
    </s:iterator>
</ul>


</html>

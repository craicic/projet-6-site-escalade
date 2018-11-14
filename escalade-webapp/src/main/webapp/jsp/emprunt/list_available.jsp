<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<head>
    <%@include file="../_include/head.jsp" %>

</head>

<%@ include file="../_include/header.jsp"%>

<ul>
    <s:iterator value="listAvailableTopo">
        <li>
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

</html>
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

<h2>Saisie d'un nouveau topo</h2>

<s:form action="topo_new">
    <s:textfield  name="topo.titre" label="Titre" requiredLabel="true"/>
    <s:textfield name="topo.auteur" label="Auteur" requiredLabel="false"/>
    <s:textarea name="topo.description" label="Description" requiredLabel="false" cols="32" rows="9"/>
    <s:submit value="Ok"/>
</s:form>

</body>
</html>

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
<h2>Association du topo à un site</h2>

<div><s:property value="topo.titre"/></div>

<s:if test="%{listSite.isEmpty()}">
    <div>Aucun site à associer</div>
    <s:a action="site_new">
        Créer un nouveau site.
    </s:a>
</s:if>
<s:else>
    <s:form action="link_site_topo">
        <s:select name="site.id" Label="Site"
                  list="listSite" listKey="id" listValue="nom"
                  emptyOption="false"
                  requiredLabel="true"/>
        <s:hidden name="topo.id" value="%{id}"/>
        <s:submit value="Ok"/>
    </s:form>
</s:else>
</div>
</body>
</html>

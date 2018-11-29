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
        <p>Aucun topo n'est disponible à l'heure actuelle.</p>
    </s:if>
    <%--<s:else>--%>
    <%--<ul class="list-group">--%>
    <%--<s:iterator value="listAvailableTopo">--%>
    <%--<li class="list-group-item">--%>
    <%--<div>Titre : <s:property value="titre"/></div>--%>
    <%--<div>Auteur : <s:property value="auteur"/></div>--%>
    <%--<div>Description : <s:property value="description"/></div>--%>
    <%--<div><s:a action="detail_topo">--%>
    <%--<s:param name="id" value="id"/>--%>
    <%--Accèder au topo--%>
    <%--</s:a></div>--%>
    <%--</li>--%>
    <%--</s:iterator>--%>
    <%--</ul>--%>
    <%--</s:else>--%>

    <s:else>
        <s:iterator value="listAvailableTopo">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title"><s:property value="titre"/></h5>
                    <h6 class="card-subtitle mb-2 text-muted">Auteur : <s:property value="auteur"/></h6>
                    <p class="card-text">Description : <s:property value="description"/></p>
                    <s:a action="detail_topo" class="card-link">
                        <s:param name="id" value="id"/>
                        Accèder au topo
                    </s:a>
                </div>
            </div>
        </s:iterator>
    </s:else>
</div>

</body>
</html>
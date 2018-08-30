<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<head>
    <%@include file="./_include/head.jsp" %>
</head>


<body>

<h2>Index</h2>

<div>
    <s:a action="list_topo">
        Liste des topos
    </s:a>
</div>
<div>
    <s:a action="topo_new">
        Ajouter un topo
    </s:a>
</div>
</body>

</html>

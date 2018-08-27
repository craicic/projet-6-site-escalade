<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<body>
<h2>Liste des topos</h2>

<ul>
    <s:iterator value="listTopo">
        <li>
            <div><s:property value="id"/></div>
            <div><s:property value="titre"/></div>
            <div><s:property value="auteur"/></div>
            <div><s:property value="description"/></div>
        </li>
    </s:iterator>
</ul>

</body>
</html>

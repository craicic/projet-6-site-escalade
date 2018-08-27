<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<body>
<h2>Index</h2>


<s:a action="list_topo">
    Liste des topos
</s:a>

<s:a action="get_by_id_topo">
    Topo par ID
</s:a>

</body>

</html>

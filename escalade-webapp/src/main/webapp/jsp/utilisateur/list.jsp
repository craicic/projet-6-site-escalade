<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<body>
<h2>Liste des topos</h2>

<ul>
    <s:iterator value="listUtilisateur">
        <li>
            <div>ID : <s:property value="id"/></div>
            <div>Nom : <s:property value="nom"/></div>
            <div>Prenom : <s:property value="prenom"/></div>
            <div>Pseudo : <s:property value="pseudo"/></div>
            <div>adresse : <s:property value="adresse"/></div>
            <div>Description : <s:property value="description"/></div>
            <div>adresseMail : <s:property value="adresseMail"/></div>
            <div>dateInscription : <s:property value="dateInscription"/></div>
            <div>uuid : <s:property value="uuid"/></div>
        </li>
    </s:iterator>
</ul>
</body>
</html>
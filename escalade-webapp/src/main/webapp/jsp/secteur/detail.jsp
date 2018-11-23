<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<head>
    <%@include file="../_include/head.jsp" %>
    <%--<style>--%>
        <%--/* Set the size of the div element that contains the map */--%>
        <%--#map {--%>
            <%--height: 400px; /* The height is 400 pixels */--%>
            <%--width: 100%; /* The width is the width of the web page */--%>
        <%--}--%>
    <%--</style>--%>
</head>

<%@ include file="../_include/header.jsp" %>

<body>

<h2>Détail d'un secteur</h2>

<ul>
    <li>ID : <s:property value="secteur.id"/></li>
    <li>Nom : <s:property value="secteur.nom"/></li>
    <li>Description : <s:property value="secteur.description"/></li>
    <li>Coordonnée GPS X : <s:property value="secteur.coordonneeX"/></li>
    <li>Coordonnée GPS Y : <s:property value="secteur.coordonneeY"/></li>
</ul>

<s:a action="detail_site">
    Site associé : <s:property value="site.nom"/>
    <s:param name="id" value="site.id"/>
</s:a>

<s:if test="%{!listVoie.isEmpty()}">
    <div>Liste des voies associées :</div>
    <s:iterator value="listVoie">
        <%--<s:if test="%{secteurId eq secteur.id}"/>--%>
        <div><s:a action="detail_voie">
            <s:param name="id" value="id"/>
            <s:property value="nom"/>
        </s:a></div>
    </s:iterator>
</s:if>
<s:else>
    <div>Aucune voie associée.</div>
</s:else>

<div>
    <s:a action="voie_new">Nouvelle voie associée
        <s:param name="secteurId" value="id"/>
    </s:a>
</div>

<%--<h3>My Google Maps Demo</h3>--%>
<%--<!--The div element for the map -->--%>
<%--&lt;%&ndash;<div id="map"></div>&ndash;%&gt;--%>
<%--<script>--%>
<%--// Initialize and add the map--%>
<%--function initMap() {--%>
<%--// The location of Uluru--%>
<%--var uluru = {lat: ${secteur.getCoordonneeX()}, lng: ${secteur.getCoordonneeY()}};--%>
<%--// The map, centered at Uluru--%>
<%--var map = new google.maps.Map(--%>
<%--document.getElementById('map'), {zoom: 4, center: uluru});--%>
<%--// The marker, positioned at Uluru--%>
<%--var marker = new google.maps.Marker({position: uluru, map: map});--%>
<%--}--%>
<%--</script>--%>
<%--<!--Load the API from the specified URL--%>
<%--* The async attribute allows the browser to render the page while the API loads--%>
<%--* The key parameter will contain your own API key (which is not needed for this tutorial)--%>
<%--* The callback parameter executes the initMap() function--%>
<%---->--%>
<%--<script async defer--%>
<%--src="https://maps.googleapis.com/maps/api/js?key=MYAPIKEY&callback=initMap">--%>
<%--</script>--%>

</body>
</html>

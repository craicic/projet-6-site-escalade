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
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-8">
            <h2><s:property value="secteur.nom"/></h2>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Nom</th>
                    <th scope="col">Coordonnée GPS X</th>
                    <th scope="col">Coordonnée GPS Y</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td scope="row"><s:property value="secteur.nom"/></td>
                    <td><s:property value="secteur.coordonneeX"/></td>
                    <td><s:property value="secteur.coordonneeY"/></td>
                </tr>
                </tbody>
            </table>
            <p>Description : <s:property value="secteur.description"/></p>
        </div>

        <div class="col-lg-4">
            <h5>Site associé</h5>
            <s:a action="detail_site">
                <s:property value="site.nom"/>
                <s:param name="id" value="site.id"/>
            </s:a>

            <h5>Voies associées</h5>
            <s:if test="%{!listVoie.isEmpty()}">
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

            <s:if test="#session.utilisateur">
                <div>
                    <s:a action="voie_new">Nouvelle voie associée
                        <s:param name="secteurId" value="id"/>
                    </s:a>
                </div>

                <h5>Édition du secteur</h5>
                <div><s:a action="update_secteur">
                    <s:param name="id" value="%{id}"/>
                    Éditer ce Secteur
                </s:a>
                </div>
                <div><s:a action="delete_secteur">
                    <s:param name="id" value="%{id}"/>
                    Supprimer ce secteur
                </s:a></div>
            </s:if>
        </div>
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
</div>
</body>
</html>

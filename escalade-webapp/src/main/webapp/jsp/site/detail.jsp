<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<head>
    <%@include file="../_include/head.jsp" %>
    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            height: 400px;  /* The height is 400 pixels */
            width: 100%;  /* The width is the width of the web page */
        }
    </style>
</head>

<%@ include file="../_include/header.jsp" %>

<body>

<h2>Détail d'un site</h2>

<ul>
    <li>ID : <s:property value="site.id"/></li>
    <li>Nom : <s:property value="site.nom"/></li>
    <li>Description : <s:property value="site.description"/></li>
    <li>Profil : <s:property value="site.profil"/></li>
    <li>Roche : <s:property value="site.roche"/></li>
    <li>Type : <s:property value="site.type"/></li>

    <s:iterator value="listSecteur">

        <s:if test="%{siteId eq site.id}">
            <li><s:a action="detail_secteur">
                <s:param name="id" value="id"/>
                Secteur associé : <s:property value="nom"/>
            </s:a></li>
        </s:if>
    </s:iterator>
</ul>


<div>
    <s:a action="secteur_new">nouveau secteur associé
        <s:param name="secteur.siteId" value="id"/>
    </s:a>
</div>

<s:if test="#session.utilisateur">
    <s:form action="add_comment_site">
        <s:textarea name="commentaire.contenuTexte" label="Votre commentaire"/>
        <s:hidden name="id" value="%{id}"/>
        <s:submit value="Ok"/>
    </s:form>
</s:if>
<s:else>
    <s:a action="login">Connectez vous pour écrire un commentaire.</s:a>
</s:else>

<ul>
    <s:iterator value="listCommentaire">
        <li>
            <div>Auteur : <s:property value="utilisateur.pseudo"/></div>
            <div>Posté à <s:property value="dateCreation"/></div>
            <div><s:property value="contenuTexte"/></div>
            <s:if test="%{utilisateurId == #session.utilisateur.id}">
                <s:a action="delete_commentaire_site">
                    <s:param name="id" value="id"/>
                    <s:param name="site.id" value="%{site.id}"/>
                    Supprimer
                </s:a>
                <s:a action="update_my_comment_site">
                    <s:param name="id" value="id"/>
                    <s:param name="site.id" value="%{site.id}"/>
                    Éditer
                </s:a>
            </s:if>
        </li>
    </s:iterator>
</ul>

<h3>My Google Maps Demo</h3>
<!--The div element for the map -->
<div id="map"></div>
<script>
    var map;
    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            zoom: 2,
            center: new google.maps.LatLng(2.8,-187.3),
            mapTypeId: 'terrain'
        });

        // Create a <script> tag and set the USGS URL as the source.
        var script = document.createElement('script');
        // This example uses a local copy of the GeoJSON stored at
        // http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.geojsonp
        script.src = 'https://developers.google.com/maps/documentation/javascript/examples/json/earthquake_GeoJSONP.js';
        document.getElementsByTagName('head')[0].appendChild(script);
    }

    // Loop through the results array and place a marker for each
    // set of coordinates.
    window.eqfeed_callback = function(results) {
        for (var i = 0; i < results.features.length; i++) {
            var coords = results.features[i].geometry.coordinates;
            var latLng = new google.maps.LatLng(coords[1],coords[0]);
            var marker = new google.maps.Marker({
                position: latLng,
                map: map
            });
        }
    }
</script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBp5GFe0VeiTP-Jigfi9tXautoDekjHRFY&callback=initMap">
</script>
</body>
</html>

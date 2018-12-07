<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<head>
    <%@include file="../_include/head.jsp" %>
    <%--<style>--%>
    <%--/* Always set the map height explicitly to define the size of the div--%>
    <%--* element that contains the map. */--%>
    <%--#map {--%>
    <%--height: 400px;  /* The height is 400 pixels */--%>
    <%--width: 100%;  /* The width is the width of the web page */--%>
    <%--}--%>
    <%--</style>--%>
</head>

<%@ include file="../_include/header.jsp" %>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-8">
            <h2><s:property value="site.nom"/></h2>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Nom</th>
                    <th scope="col">Profil</th>
                    <th scope="col">Roche</th>
                    <th scope="col">Type</th>
                    <th scope="col">Coordonnée GPS X</th>
                    <th scope="col">Coordonnée GPS Y</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td scope="row"><s:property value="site.nom"/></td>
                    <td><s:property value="site.profil"/></td>
                    <td><s:property value="site.roche"/></td>
                    <td><s:property value="site.type"/></td>
                    <td><s:property value="site.coordonneeX"/></td>
                    <td><s:property value="site.coordonneeY"/></td>
                </tr>
                </tbody>
            </table>
            <p>Description : <s:property value="site.description"/></p>
        </div>

        <div class="col-lg-4">
            <h5>Topos associés</h5>
            <s:if test="%{!listTopo.isEmpty()}">
                <s:iterator value="listTopo">
                    <div><s:a action="detail_topo">
                        <s:param name="id" value="id"/>
                        <s:property value="titre"/>
                    </s:a>
                    </div>

                </s:iterator>
            </s:if>
            <s:else>
                <div>Aucun topo n'est lié à ce site
                </div>
            </s:else>

            <h5>Secteurs associés</h5>
            <s:if test="%{!listSecteur.isEmpty()}">

                <s:iterator value="listSecteur">
                    <div><s:a action="detail_secteur">
                        <s:param name="id" value="id"/>
                        <s:property value="nom"/>
                    </s:a></div>
                </s:iterator>
            </s:if>
            <s:else>Aucun secteur associé</s:else>

            <s:if test="#session.utilisateur">
                <div><s:a action="secteur_new">Nouveau secteur associé
                        <s:param name="siteId" value="id"/>
                    </s:a></div>
            </s:if>

            <s:if test="#session.utilisateur">
                <h5>Édition du site</h5>
                <div><s:a action="update_site">
                    <s:param name="id" value="%{id}"/>
                    Éditer ce site
                </s:a>
                </div>
                <div><s:a action="delete_site">
                    <s:param name="id" value="%{id}"/>
                    Supprimer ce site
                </s:a></div>
            </s:if>
        </div>
    </div>

    <div class="row">
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

        <ul class="list-group">
            <s:iterator value="listCommentaire">
                <li class="list-group-item">
                    <div>Auteur : <s:property value="utilisateur.pseudo"/></div>
                    <div>Posté le <s:date name="dateCreation" format="dd/MM/yyyy à HH:mm"/></div>
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
    </div>
    <%--<h3>My Google Maps Demo</h3>--%>
    <%--<!--The div element for the map -->--%>
    <%--<div id="map"></div>--%>
    <%--<script>--%>
    <%--var map;--%>
    <%--function initMap() {--%>
    <%--map = new google.maps.Map(document.getElementById('map'), {--%>
    <%--zoom: 2,--%>
    <%--center: new google.maps.LatLng(${site.getCoordonneeX()},${site.getCoordonneeY()}),--%>
    <%--mapTypeId: 'terrain'--%>
    <%--});--%>

    <%--// Create a <script> tag and set the USGS URL as the source.--%>
    <%--var script = document.createElement('script');--%>
    <%--// This example uses a local copy of the GeoJSON stored at--%>
    <%--// http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.geojsonp--%>
    <%--script.src = 'https://developers.google.com/maps/documentation/javascript/examples/json/earthquake_GeoJSONP.js';--%>
    <%--document.getElementsByTagName('head')[0].appendChild(script);--%>
    <%--}--%>

    <%--// Loop through the results array and place a marker for each--%>
    <%--// set of coordinates.--%>
    <%--window.eqfeed_callback = function(results) {--%>
    <%--for (var i = 0; i < results.features.length; i++) {--%>
    <%--var coords = results.features[i].geometry.coordinates;--%>
    <%--var latLng = new google.maps.LatLng(coords[1],coords[0]);--%>
    <%--var marker = new google.maps.Marker({--%>
    <%--position: latLng,--%>
    <%--map: map--%>
    <%--});--%>
    <%--}--%>
    <%--}--%>
    <%--</script>--%>

    <%--<script async defer--%>
    <%--src="https://maps.googleapis.com/maps/api/js?key=MYAPIKEY&callback=initMap">--%>
    <%--</script>--%>
</div>
</body>
</html>

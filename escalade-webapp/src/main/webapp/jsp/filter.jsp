<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="./_include/head.jsp" %>
</head>

<%@ include file="./_include/header.jsp" %>

<body>
<div class="container-fluid">
    <h2>Resultat</h2>

    <p>Mots recherchés : <s:property value="termeDeLaRecherche"/></p>


    <ul class="list-group">
        <h5>Topos <span class="badge badge-primary badge-pill"><s:property value="listTopo.size()"/></span></h5>
        <s:iterator value="listTopo">
            <li class="list-group-item">
                <div>Titre : <s:property value="titre"/></div>
                <div>Description : <s:property value="description"/></div>
                <div><s:a action="detail_topo">Accéder au topo
                    <s:param name="id" value="%{id}"/>
                </s:a></div>
            </li>
        </s:iterator>
    </ul>

    <ul class="list-group">
        <h5>Sites <span class="badge badge-primary badge-pill"><s:property value="listSite.size()"/></span></h5>
        <s:iterator value="listSite">
            <li class="list-group-item">
                <div>Nom : <s:property value="nom"/></div>
                <div>Description : <s:property value="description"/></div>
                <div><s:a action="detail_site">Accéder au site
                    <s:param name="id" value="%{id}"/>
                </s:a></div>
            </li>
        </s:iterator>
    </ul>

    <ul class="list-group">
        <h5>Secteurs <span class="badge badge-primary badge-pill"><s:property value="listSecteur.size()"/></span></h5>
        <s:iterator value="listSecteur">
            <li class="list-group-item">
                <div>Nom : <s:property value="nom"/></div>
                <div>Description : <s:property value="description"/></div>
                <div><s:a action="detail_secteur">Accéder au secteur
                    <s:param name="id" value="%{id}"/>
                </s:a></div>
            </li>
        </s:iterator>
    </ul>

    <ul class="list-group">
        <h5>Voies <span class="badge badge-primary badge-pill"><s:property value="listVoie.size()"/></span></h5>
        <s:iterator value="listVoie">
            <li class="list-group-item">
                <div>Nom : <s:property value="nom"/></div>
                <div>Description : <s:property value="description"/></div>
                <div>Cotation : <s:property value="cotation"/></div>
                <div><s:a action="detail_voie">Accéder à la voie
                    <s:param name="id" value="%{id}"/>
                </s:a></div>
            </li>
        </s:iterator>
    </ul>
</div>
</body>
</html>
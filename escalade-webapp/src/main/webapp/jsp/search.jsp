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

    <s:if test="%{listTopo.isEmpty() and listSite.isEmpty() and listSecteur.isEmpty() and listVoie.isEmpty()}">
        <div>Aucun résultat trouvé</div>
    </s:if>
    <s:else>
    <s:form action="filter" method="GET">

        <s:select name="difficulteMin" Label="Difficulte minimum"
                  list="listDifficulte"
                  emptyOption="false"/>

        <s:select name="difficulteMax" Label="Difficulte minimum"
                  list="listDifficulte"
                  emptyOption="false"/>

        <s:hidden name="termeDeLaRecherche" value="%{termeDeLaRecherche}"/>

        <s:submit value="Filtrer"/>
    </s:form>
    </s:else>

    <ul class="list-group">
        <h5>Topos trouvés : <s:property value="listTopo.size()"/></h5>
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
        <h5>Sites trouvés : ${listSite.size()}</h5>
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
        <h5>Secteurs trouvés : ${listSecteur.size()}</h5>
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
        <h5>Voies trouvés : ${listVoie.size()}</h5>
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
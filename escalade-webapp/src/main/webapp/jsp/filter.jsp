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

    <%--<s:form action="search">--%>

        <%--<s:select name="difficulteMin" Label="Difficulte minimum"--%>
                  <%--list="listDifficulte"--%>
                  <%--emptyOption="false"/>--%>

        <%--<s:select name="difficulteMax" Label="Difficulte minimum"--%>
                  <%--list="listDifficulte"--%>
                  <%--emptyOption="false"/>--%>

        <%--<s:hidden name="termeDeLaRecherche" value="%{termeDeLaRecherche}"/>--%>

        <%--<s:submit value="Filtrer"/>--%>
    <%--</s:form>--%>

    <ul class="list-group">
        <h5>Topos trouvés : <s:property value="listTopo.size()"/></h5>
        <s:iterator value="listTopo">
            <li class="list-group-item">
                <div>Id : <s:property value="id"/></div>
                <div>Titre : <s:property value="titre"/></div>
                <div>Auteur : <s:property value="auteur"/></div>
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
                <div>Id : <s:property value="id"/></div>
                <div>Nom : <s:property value="nom"/></div>
                <div>Description : <s:property value="description"/></div>
                <div>Roche : <s:property value="roche"/></div>
                <div>Profil : <s:property value="profil"/></div>
                <div>Type : <s:property value="type"/></div>
            </li>
        </s:iterator>
    </ul>

    <ul class="list-group">
        <h5>Secteurs trouvés : ${listSecteur.size()}</h5>
        <s:iterator value="listSecteur">
            <li class="list-group-item">
                <div>Id : <s:property value="id"/></div>
                <div>Nom : <s:property value="nom"/></div>
                <div>Description : <s:property value="description"/></div>
            </li>
        </s:iterator>
    </ul>

    <ul class="list-group">
        <h5>Voies trouvés : ${listVoie.size()}</h5>
        <s:iterator value="listVoie">
            <li class="list-group-item">
                <div>Id : <s:property value="id"/></div>
                <div>Nom : <s:property value="nom"/></div>
                <div>Description : <s:property value="description"/></div>
                <div>Nombre de points : <s:property value="nombreDePoints"/></div>
                <div>Nombre de longueurs : <s:property value="nombreDeLongueurs"/></div>
                <div>Cotation : <s:property value="cotation"/></div>
                <div>Hauteur : <s:property value="hauteur"/></div>
                <div>Id du secteur associé <s:property value="secteurId"/></div>
            </li>
        </s:iterator>
    </ul>
</div>
</body>
</html>
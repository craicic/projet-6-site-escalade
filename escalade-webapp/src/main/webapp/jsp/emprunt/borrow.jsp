<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<head>
    <%@include file="../_include/head.jsp" %>
    <sx:head />
</head>

<%@ include file="../_include/header.jsp"%>

<h5>Historique de réservation</h5>
<%-- todo lister les date de réservation sur ce topo --%>

<h5>Choisissez une date de retour :</h5>
<s:form action="borrow">

    <sx:datetimepicker name="date" label="Format (dd-MMM-yyyy)"
                       displayFormat="dd-MMM-yyyy" value="todayDate" />
    <s:hidden name="topo.id" value="%{topo.id}"/>
    <s:submit value="Ok"/>
</s:form>
</html>

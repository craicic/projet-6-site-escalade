<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>

<body>
<h2>Hello World!</h2>

<ul>
    <s:iterator value="listTopo">
        <li>
            <s:a action="list_topo">
                <s:property/>
            </s:a>
        </li>
    </s:iterator>
</ul>

</body>

</html>

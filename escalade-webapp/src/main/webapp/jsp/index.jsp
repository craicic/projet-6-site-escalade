<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<body>
<h2>Hello World!</h2>
<ul>
    <s:iterator value="listTopo">
        <li><s:property/></li>
    </s:iterator>
</ul>
</body>

</html>

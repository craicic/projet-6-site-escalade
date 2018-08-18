<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>
<h2>Hello World!</h2>
<p>
    <s:iterator value="listTopo">
    <li><s:property /></li>
    </s:iterator>
</p>
</body>

</html>

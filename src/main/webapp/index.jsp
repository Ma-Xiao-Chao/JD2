%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/13
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<%--<%=request.getAttribute("clist")%>--%>
<%--<%=request.getAttribute("obj")%>--%>
<hr>
${requestScope.clist}
<hr>
<%--增强for--%>
<c:forEach var="catalog" items="${requestScope.clist}">
    <a href="${catalog.url}"> ${catalog.cname}  <br></a>
</c:forEach>
<hr>


</body>
</html>

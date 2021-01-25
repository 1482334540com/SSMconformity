
<%--jsp标准代码--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath=request.getScheme()
            +"://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/"
            ;
       request.getSession().setAttribute("basePath",basePath);
%>
<html>
<head>
    <title>Title</title>
    <base href="${sessionScope.basePath}">
</head>
<body>
<h2>hello word</h2>
<jsp:forward page="book/index.do"></jsp:forward>
</body>
</html>







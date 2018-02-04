<%@ page pageEncoding="utf-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/lib/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/test.js"></script>
<html>
<head>
    <meta charset="utf-8">
    <%--<c:url var="bootstrap" value="${contextPath}/css/bootstrap.min.css" />--%>
</head>
<body>
<div class="container">
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="content" />
    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>

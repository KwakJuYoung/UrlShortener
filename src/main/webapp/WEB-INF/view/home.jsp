<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<script type="text/javascript">
    console.log("${contextPath}")
</script>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome Home Page</title>
</head>
<body>
<h2>WelCome Home! ${test.id}</h2>
<h2>Today : ${test.name}</h2>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Url Shortening</title>
</head>
<body>
<div>


</div>
<div id="url_list_container">

</div>

</body>
</html>
<script type="text/javascript" src="${contextPath}/script/test.js"></script>
<script type="application/javascript">
    var urlList = "${urlList}";
    test();
    console.log(urlList);
    var UrlList = function() {
        var _urlList;
        var init = function() {
            _urlList
        };
        var bindEvent = function() {

        };
        return {
            init: init,
            bindEvent: bindEvent
        }
    }
</script>

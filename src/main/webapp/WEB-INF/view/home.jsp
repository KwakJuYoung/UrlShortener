<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <script type="text/javascript" src="${contextPath}/script/url.js"></script>
    <link href="${contextPath}/css/url.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>URL Shortening</title>
</head>
<body>
<div id="home_container">
    <div id="url_register_container">
        <div class="input-wrapper">
            <input type="url" id="input_url">
            <input type="button" id="add_btn" class="btn btn-default" value="등록">
        </div>
    </div>
    <div id="url_list_container">
        <table id="url_list">
            <thead>
            <tr>
                <th class="origin-url">Original URL</th>
                <th class="shorten-url">Shorten URL</th>
                <th class="call-count">Count</th>
                <th class="action"></th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
        <div id="paging_area">

        </div>
    </div>
</div>

<div id="popup" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
                <div id="content"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script type="application/javascript">
    $(function () {
        var urlList = new UrlList();
        urlList.init()
    });
</script>

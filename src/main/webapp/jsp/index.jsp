<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html lang="ru">
<head>
    <title>Index</title>
    <meta charset="UTF-8">
    <style type="text/css">
        <%@include file = "../css/index.css"%>
    </style>
</head>
<body>
<div class="wrapper">
    <div class="inner-wrap">
        <div class="header">
            <h1>Department</h1>
        </div>

        <div class="content">
            <button onclick="location.href='/listDepartment'">List Department</button>
        </div>
    </div>
</div>
</body>
</html>
<%--@elvariable id="name" type="java"--%>
<%--@elvariable id="id" type="java"--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html lang="ru">
<head>
    <title>Update Department</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Update Department</h1>
<form action="updateDepartment" method="post">
    <fieldset class="form-name">
        <label for="name">Name</label><input id="name" type="text" name="name" value="${name}"/><br/>
        <input type="hidden" name="id" value="${id}"/>
    </fieldset>
    <input type="submit" class="btn btn-success" value="UPDATE">
</form>
</body>
</html>
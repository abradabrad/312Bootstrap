<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users</title>
</head>
<body>
<h1 style="font-size: medium">Spring CRUD Security app start page</h1>
<div>
    <th:block th:each="msg : ${messages}">
        <h1 style="font-size: medium" th:text="${msg}"></h1>
    </th:block>
</div>
<form th:action="@{/admin}" th:method="get">
    <input  class="button button-block" type="submit" value="Login"/>
</form>

</body>
</html>
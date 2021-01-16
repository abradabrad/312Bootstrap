<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User</title>
</head>
<body>
<h1 style="font-size: medium">User page</h1>
<form th:action="@{/user/{id}(id=${user.id})}" th:method="GET" th:object="${user}">
    <b>Name: </b><span th:text="${user.name}" >user</span><p/>
    <b>Second name: </b><span th:text="${user.secondName}" >user</span><p/>
    <b>Login: </b><span th:text="${user.login}" >user</span><p/>
    <b>Roles: </b> <span th:each="role : ${user.getRoles()}" th:utext="${role.getRole()}+' '">
    </span><p/>
</form>
<br/>
<form th:action="@{/logout}" th:method="GET" >
    <input class="button button-block" type="submit" value="Logout"/>
</form>
</body>
</html>
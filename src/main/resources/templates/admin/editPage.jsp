<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit User</title>
    </head>
<body>
<h1 style="font-size: medium">Edit user</h1>
<form th:action="@{/admin/edit/{id}(id=${user.id})}" th:method="POST" th:object="${user}">
     <label for="name">Name: </label>
    <input type="text" th:field="*{name}" id="name" />
    <label for="secondName">Second name: </label>
    <input type="text" th:field="*{secondName}" id="secondName"/>
    <label for="login">Login: </label>
    <input type="text" th:field="*{login}" id="login"/>
    <label for="password">Password: </label>
    <input type="text" th:field="*{password}" id="password"/>
    <br/>    <!--     -->
    <label for="admin"  >Admin</label>
    <input type="checkbox" id="admin" name="admin" th:value="ROLE_ADMIN" th:checked="${user.isAdmin}"/>
    <br/>
    <input class="button button-block" type="submit" value="Save user"/>
</form>
<br/>
<form th:action="@{/admin}" th:method="GET" >
    <input class="button button-block" type="submit" value="Cancel"/>
</form>
<br/>
    <h2 style="font-size: medium">Roles</h2>
    <tr th:each="role : ${user.getRoles()}" th:utext="${role.getRole()}">
    <tr/>
<br/>
<br/>
<form th:action="@{/logout}" th:method="GET" >
    <input class="button button-block" type="submit" value="Logout"/>
</form>
</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New User</title>
</head>
<body>
<form th:action="@{/admin/add}" th:method="post" th:object="${user}">
    <label for="name">Enter name: </label>
    <input type="text" th:field="*{name}" id="name" />
    <label for="secondName">Enter Second name: </label>
    <input type="text" th:field="*{secondName}" id="secondName"/>
    <label for="login">Enter login: </label>
    <input type="text" th:field="*{login}" id="login"/>
    <label for="password">Enter password: </label>
    <input type="text" th:field="*{password}" id="password"/>
    <br/>    <!--     -->
    <label for="admin"  >Admin</label>
    <input type="checkbox" id="admin" name="admin" th:value="ROLE_ADMIN"/>
    <br/>
    <input class="button button-block" type="submit" value="New user"/>
</form>
<br/>
<form th:action="@{/admin}" th:method="GET" >
    <input class="button button-block" type="submit" value="Cancel"/>
</form>
<br/>
<form th:action="@{/logout}" th:method="GET" >
    <input class="button button-block" type="submit" value="Logout"/>
</form>
<br/>
</body>
</html>
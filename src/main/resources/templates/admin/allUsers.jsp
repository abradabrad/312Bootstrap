<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users</title>
</head>
<body>
<h1>Users</h1>
<br/>
<div>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Second Name</th>
            <th>Login</th>
            <th>Edit</th>
            <th>Delete</th>
            <th>Roles</th>
        </tr>
        <tr th:each="user : ${usersList}">
            <td th:utext="${user.getId()}">Id</td>
            <td th:utext="${user.getName()}">name</td>
            <td th:utext="${user.getSecondName()}">Second Name</td>
            <td th:utext="${user.getLogin()}">Login</td>
            <td><form th:action="@{/admin/edit/{id}(id=${user.id})}">
                <input class="button button-block" type="submit" value="Edit"/>
            </form>
            <td><form th:action="@{/admin/{id}(id=${user.id})}" th:method="delete">
                <input class="button button-block" type="submit" value="Delete"/>
            </form>
            <td th:each="role : ${user.getRoles()}" th:utext="${role.getRole()}">Roles</td>

            </td>
        </tr>
    </table>
</div>
<br/>

<h2>Add</h2>
<form th:action="@{/admin/add}" >
    <input  class="button button-block" type="submit" value="Add User"/>
</form>
<br/>
<form th:action="@{/logout}" th:method="GET" >
    <input class="button button-block" type="submit" value="Logout"/>
</form>
</body>
</html>
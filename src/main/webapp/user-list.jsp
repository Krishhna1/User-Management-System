<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>User Management System</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="<%=request.getContextPath()%>/list">
                User Management System
            </a>

            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/list">
                        Home
                    </a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-4">

        <div class="d-flex justify-content-between align-items-center mb-3">
            <h3>User List</h3>

            <a href="<%=request.getContextPath()%>/new"
               class="btn btn-success">
                Add User
            </a>
        </div>

        <table class="table table-bordered table-hover">

            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Country</th>
                    <th width="180">Actions</th>
                </tr>
            </thead>

            <tbody>

                <c:forEach var="user" items="${listUser}">

                    <tr>

                        <td><c:out value="${user.id}" /></td>

                        <td><c:out value="${user.name}" /></td>

                        <td><c:out value="${user.age}" /></td>

                        <td><c:out value="${user.email}" /></td>

                        <td><c:out value="${user.country}" /></td>

                        <td>

                            <a class="btn btn-warning btn-sm"
                               href="edit?id=<c:out value='${user.id}' />">
                                Edit
                            </a>

                            <a class="btn btn-danger btn-sm"
                               href="delete?id=<c:out value='${user.id}' />">
                                Delete
                            </a>

                        </td>

                    </tr>

                </c:forEach>

            </tbody>

        </table>

    </div>

</body>

</html>
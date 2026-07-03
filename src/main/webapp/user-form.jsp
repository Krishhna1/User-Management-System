<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

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
            <a class="navbar-brand"
                href="<%=request.getContextPath()%>/list">
                User Management System
            </a>
        </div>
    </nav>

    <div class="container mt-5">

        <div class="card shadow">

            <div class="card-body">

                <c:choose>

                    <c:when test="${user != null}">
                        <form action="update" method="post">

                            <input type="hidden"
                                   name="id"
                                   value="<c:out value='${user.id}'/>">

                            <h3 class="mb-4">Edit User</h3>

                    </c:when>

                    <c:otherwise>

                        <form action="insert" method="post">

                            <h3 class="mb-4">Add New User</h3>

                    </c:otherwise>

                </c:choose>

                <div class="form-group">

                    <label>Name</label>

                    <input type="text"
                           class="form-control"
                           name="name"
                           value="<c:out value='${user.name}'/>"
                           required>

                </div>

                <div class="form-group">

                    <label>Age</label>

                    <input type="number"
                           class="form-control"
                           name="age"
                           value="<c:out value='${user.age}'/>"
                           required>

                </div>

                <div class="form-group">

                    <label>Email</label>

                    <input type="email"
                           class="form-control"
                           name="email"
                           value="<c:out value='${user.email}'/>"
                           required>

                </div>

                <div class="form-group">

                    <label>Country</label>

                    <input type="text"
                           class="form-control"
                           name="country"
                           value="<c:out value='${user.country}'/>"
                           required>

                </div>

                <button type="submit" class="btn btn-success">
                    Save
                </button>

                <a href="<%=request.getContextPath()%>/list"
                   class="btn btn-secondary">
                    Cancel
                </a>

                </form>

            </div>

        </div>

    </div>

</body>

</html>
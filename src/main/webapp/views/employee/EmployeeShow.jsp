<%@ page language="java" pageEncoding="UTF-8" session="true" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
        }
    </style>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/employee/show" method="POST">
    <table style>
        <tr>
            <td>First name</td>
            <td>${employee.firstName}</td>
        </tr>
        <tr>
            <td>Last name</td>
            <td>${employee.lastName}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${employee.email}</td>
        </tr>
        <tr>
            <td>Phone</td>
            <td>${employee.phone}</td>
    </table>
    <tr>
        <br><br>
        <td><input type="submit" align="center" value="Ok"/></td>
    </tr>
</form>
</body>
</html>
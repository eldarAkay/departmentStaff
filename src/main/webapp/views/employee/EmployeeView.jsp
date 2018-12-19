<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/employee/CreateEmployee.jsp">Добавить пользователя</a>
<table>
    <tr>
        <td>First name</td>
        <td>Last name</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${employees}" var="employee" varStatus="status">
        <tr valign="top">
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/employee/show?id=${employee.id}">Просмотреть</a>
                <a href="${pageContext.servletContext.contextPath}/employee/edit?id=${employee.id}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/employee/delete?id=${employee.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%--подключение библиотеки тегов jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/employee/CreateEmployee.jsp">Добавить пользователя</a>
<table border="1">
    <tr>
        <td>First name</td>
        <td>Last name</td>
        <td>Email</td>
        <td>Phone</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${employees}" var="employee" varStatus="status">
        <tr valign="top">
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.email}</td>
            <td>${employee.phone}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/employee/edit?id=${employee.id}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/employee/delete?id=${employee.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page  pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<html>
<head>

</head>
<body>
    <table cellpadding="0px" cellspacing="0px" border="1px" width="80%">
        <tr>
            <th>用户id</th>
            <th>用户名</th>
            <th>年龄</th>
            <th>工资</th>
        </tr>
        <c:forEach items="${requestScope.users}" var="users">
            <tr>
                <td>${users.id}</td>
                <td>${users.name}</td>
                <td>${users.age}</td>
                <td>${users.salary}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
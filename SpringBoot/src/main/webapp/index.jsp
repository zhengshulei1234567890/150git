<%@page isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>
    <c:forEach var="user" items="${sessionScope.user}">
        ${user.username}------ ${user.password}<br/>
    </c:forEach>
</body>
</html>

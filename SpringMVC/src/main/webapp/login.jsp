<%@ page  pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<html>
<head>

</head>
<body>
<form action="${pageContext.request.contextPath}/users/login.do" method="post">
    用户名：<input type="text" name="name"/><br/>
    密码：<input type="text" name="password"/><br/>
    <%--工资：<input type="text" name="salary"/><br/>--%>
    <input type="submit" value="登录">
</form>
</body>

</html>
<%@ page  pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<html>
<head>

</head>
<body>
    <form action="${pageContext.request.contextPath}/users/register.do" method="post">
        用户名：<input type="text" name="name"/><br/>
        年龄：<input type="text" name="age"/><br/>
        工资：<input type="text" name="salary"/><br/>
        密码：<input type="text" name="password"/><br/>
        <input type="submit" value="注册">
    </form>
</body>
</html>
<%@ page pageEncoding="UTF-8" contentType="text/html;UTF-8"  isELIgnored="false" %>
<html>
    <head>
        <script type="application/javascript">
            function checkUserName() {
                //获取用户输入的用户名
               var input= document.getElementById("input");
                var username=input.value;
                //把用户名发送到后台进行校验
                location.href="${pageContext.request.contextPath}/checkusername?username="+username;
            }
        </script>
    </head>
<body>
    <form action="" method="post">
        用户名<input type="text" name="username" onblur="checkUserName();"/>${requestScope.message}<br/>
        密码  <input type="password" name="password"/><br/>
        年龄  <input type="text" name="age"/><br/>
    <input type="submit" value="注册"/>
    </form>
</body>
</html>
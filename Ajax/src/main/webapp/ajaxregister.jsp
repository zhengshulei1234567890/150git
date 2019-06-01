<%@ page pageEncoding="UTF-8" contentType="text/html;UTF-8"  isELIgnored="false" %>
<html>
<head>
    <script type="application/javascript">
        function checkUserName() {
            //获取用户输入的用户名
           var input= document.getElementById("input");
            var username=input.value;
                //异步请求步骤
                //创建异步请求对象
            var xhr;
            if(window.ActiveXObject){
                    xhr=new ActiveXObject("Microsoft.XMLHTTP");
            }else{
                xhr=new XMLHttpRequest();
            }
            //发送异步请求
            xhr.open("GET","${pageContext.request.contextPath}/ajaxcheckusername?username="+username);
            //发送数据
            xhr.send(null);
            //监听响应
            xhr.onreadystatechange=function () {
                //响应正确解析完成
                if(xhr.readyState==4 && xhr.status==200){
                        //获取校验信息 并展示
                   var span= document.getElementById("span");
                    //把校验信息放入span标签内
                   span.innerHTML= xhr.responseText;
                }
            }
        }
    </script>
</head>
<body>
<form action="" method="post">
    用户名<input id="input"  type="text" name="username" onblur="checkUserName();"/><span id="span"></span><br/>
    密码  <input type="password" name="password"/><br/>
    年龄  <input type="text" name="age"/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
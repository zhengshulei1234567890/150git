<%@page pageEncoding="utf-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<html>
    <head>
        <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>

        <script type="application/javascript">
          $(function () {
              $("#show").blur(function () {
                $("#span").append()(
                  $("<img src='${pageContext.request.contextPath}/images/load.gif'><img>")
                ),
                  setTimeout(function () {
                      $("#span").empty();
                      //发送ajax请求的步骤
                      $.ajax({
                          //发送ajax到url
                          url:"${pageContext.request.contextPath}/User/showAll",
                          //请求方式
                          type:"POST",
                          //
                          data:"username="+$("#show").val(),
                          //返回的数据类型  json自定转换
                          dataType:"json",
                          success:function (user) {
                              $("#span").append(
                                  $("<img src=${pageContext.request.contextPath}/images/"+img.s+"></img>")
                          )
                          }
                      })
                  },2000);
              })
          })

        </script>
        <style>
            img{
                width:22px;
            }
        </style>
    </head>

    <body>
        <form >
            用户名<input id="show" type="text" name="username" value=""/><span id="span"></span><br/>
            密码 <input type="password" name="user.password"value=""/><br/>
            年龄<input type="text" name="user.age" value=""/><br/>
            <input type="submit" value="注册"/>
        </form>
    </body>
</html>
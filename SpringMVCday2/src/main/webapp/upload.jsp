<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<html>
<head>

</head>
        <!--客户端-->
<body>
    <form method="post" action="${pageContext.request.contextPath}/upload/u.do" enctype="multipart/form-data">
        <input type="file" name="upload"/>
        <input type="submit" value="上传文件">
    </form>
</body>
</html>
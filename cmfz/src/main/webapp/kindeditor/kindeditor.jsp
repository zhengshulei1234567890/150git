<%@page isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script charset="utf-8" src="kindeditor-all-min.js"></script>
    <script charset="utf-8" src="lang/zh-CN.js"></script>
    <script>
        KindEditor.ready(function(K) {
            K.create('#editor_id',{
                uploadJson:"${pageContext.request.contextPath}/kindeditor/uploading",
                filePostName:"img",//默认是imgFile
                allowFileManager:true,//显示图片空间
                fileManagerJson:"${pageContext.request.contextPath}/kindeditor/getAll",
            });
        });
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/kindeditor/addkindeditor">
        <textarea id="editor_id" name="content" style="width:700px;height:300px;">
            文本内容
        </textarea>
        <input type="submit" value="戳我">
    </form>
</body>
</html>
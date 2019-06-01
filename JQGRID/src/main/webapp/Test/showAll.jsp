<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!--引入移动设备优先  必须写-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--引入BootStrap的全局样式-->
    <link rel="stylesheet" href="../boot/css/bootstrap.css">
    <script src="../boot/js/jquery-1.10.1.min.js"></script>
    <script src="../boot/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../jqgrid/css/css/cupertino/jquery-ui-1.8.16.custom.css">
    <link rel="stylesheet" href="../jqgrid/css/ui.jqgrid.css">
    <script src="../jqgrid/js/i18n/grid.locale-cn.js"></script>
    <script src="../jqgrid/js/jquery.jqGrid.src.js"></script>

    <script type="application/javascript">
        $(function () {
                $("#list").jqGrid({
                url: "${pageContext.request.contextPath}/user/showAll.do", //发送请求向后台获取数据
                datatype: "json",     //定义服务器返回的数据类型
                colNames: ["ID", "用户名", "密码", "年龄","部门参数","部门名称"],//定义列名
                pager:"#pager", //分页
                rowNum:"3", //每页显示的条数   rows为名字传值
                rowList:[3,6,9,12],
                caption:"用户信息列表展示", //表格名称
                autowidth:true, //自适应宽度
                multiselect:true, //支持多选
                viewrecords:true,//是否显示总记录数
                //通过ColModel填充具体的数据内容
                colModel: [
                    {name:"id",editable:true},
                    {name:"username",editable:true},
                    {name:"password",editable:true},
                    {name:"age",editable:true},
                    {name:"department.deptnumber",editable:true},
                    {name:"department.id",
                        formatter:function (cellvalue,options,rowObject) {
                            if (rowObject.department) {
                                return  rowObject.department.deptname ;
                            }
                        },
                        /*editable:true,*/
                        edittype:"select",
                        editoptions:{
                            //查询所有的部门
                            dataurl:"${pageContext.request.contextPath}/department/options.do"
                        }
                    }
                ]
            }).jqGrid("navGrid","#pager","edit:true");//固定写死  增删改
        })
    </script>

</head>
<body>
<table id="list"></table>
<div id="pager"></div>
</body>
</html>

















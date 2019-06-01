<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8"  isELIgnored="false" %>
<script>
    $(function () {
        $("#userList").jqGrid({
            url: "${pageContext.request.contextPath}/user/getUserByPager",
            editurl:"${pageContext.request.contextPath}/user/edit",
            datatype: "json",
            colNames: ["id", "法名", "真名", "密码", "性别", "省份","电话号","状态","创建时间","签名","头像"],
            colModel: [
                {name: "id"},
                {name: "dharma", editable: true},
                {name: "name", editable: true},
                {name: "password", editable: true},
                {name: "sex", editable: true},
                {name: "province", editable: true},
                {name: "phoneNum", editable: true},
                {name:"status",editable:true,edittype:"select",
                    editoptions:{value:"展示:展示;不展示:不展示"}
                },
                {name: "createDate",editable:true,edittype:"date"},
                {name: "sign", editable: true},
                {name: "headPic", editable: true, edittype: "file",
                    formatter:function (cellValue) {
                        return "<img style='height: 50px;width: 50px' src='${pageContext.request.contextPath}/img/"+cellValue+"'/>"
                    }
                }
            ],
            styleUI:"Bootstrap",
            pager: "#userPager",
            rowNum:2,
            rowList: [2, 4, 6],
            viewrecords: true,
            //height: '50%',
            page:2,
            multiselect:true,
            rownumbers:true,
            //viewrecords: true,
            autowidth: true

    }).jqGrid("navGrid","#userPager" ,
        {addtext:"添加",edittext:"编辑",deltext:"删除", search:false},
        {//修改

            closeAfterEdit:true,
            afterSubmit:function (response) {
                var userId = response.responseJSON.userId;
                var msg = response.responseJSON.msg;
                if (userId != "") {
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/user/upload",
                        type: "post",
                        fileElementId: "headPic",
                        data:{userId:userId},
                        success:function () {
                            $("#userList").trigger("reloadGrid");
                            $("#bannerMsgId").show().html(msg);
                            setTimeout(function(){
                                $("#bannerMsgId").hide()
                            }, 3000);
                        }
                    });

                }
                return response;
            }
        },
        {//添加
            closeAfterAdd:true,
            afterSubmit:function (response) {
                var userId = response.responseJSON.userId;
                var msg = response.responseJSON.msg;
                $.ajaxFileUpload({
                    url: "${pageContext.request.contextPath}/user/upload",
                    type: "post",
                    fileElementId: "headPic",
                    data:{userId:userId},
                    success:function () {
                        $("#userList").trigger("reloadGrid");
                        $("#bannerMsgId").show().html(msg);
                        setTimeout(function(){
                            $("#bannerMsgId").hide()
                        }, 3000);
                    }
                });
                return response;
            }

        },
        {//删除
            afterComplete:function (response) {
                var msg=response.responseJSON.msg;
                setTimeout(function () {
                    $("#bannerMsgId").hide()
                },3000);
            }
        }
    )
    })
    function outUserMsg() {
        location.href="${pageContext.request.contextPath}/user/easyPoiOut"
    }

</script>
<h3>用户管理</h3>
<div>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                  data-toggle="tab">用户信息</a></li>
        <li><a href="#" onclick="outUserMsg()">导出用户信息</a></li>
        <li><a href="javascript:$('#changeContent').load('echarts.jsp')" >用户注册走势图信息</a></li>
        <li><a href="javascript:$('#changeContent').load('goEasy.jsp')" >用户分布图信息</a></li>
        <li><a href="javascript:$('#changeContent').load('echarts2.jsp')" >月份分布图信息</a></li>

    </ul>
</div>
<table id="userList" class="table table-striped"></table>
<div style="height: 50px" id="userPager"></div>
<div id="bannerMsgId" class="alert alert-warning alert-dismissible" role="alert" style="display:none">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <strong>Warning!</strong>
</div>
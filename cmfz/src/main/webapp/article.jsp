<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>
<script>
    $(function () {
        $("#articleList").jqGrid({
            url:"${pageContext.request.contextPath}/Article/getAllarticle",
            editurl:"${pageContext.request.contextPath}/Article/delete",
            datatype:"json",
            colNames:["编号","标题","作者","状态","创建日期","描述","操作"],
            colModel:[
                {name:"id"},
                {name:"title",editable:true},
                {name:"author",editable:true,hidden:true},
                {name:"status",editable:true,editable:true,edittype:"select",
                    editoptions:{value:"展示:展示;不展示:不展示"}},
                {name:"createDate",editable:true,edittype: "date"},
                {name:"content",editable:true,hidden:true},
                {name:"",//,editable:true,edittype:"file"
                    formatter:function (cellvalue,opo,value) {
                    return "<a href='#' onclick=\"lookModal('"+value.id+"')\">查看详情</a>&nbsp;&nbsp;"+
                        "<a href='#' onclick=\"deleteModal('"+value.id+"')\">删除</a>"

                    },
                },
            ],
            styleUI:"Bootstrap",
            pager:"#pager",//分页
            rowNum:2,//每页显示条数
            rowList:[3,6,9],
            page:1,
            viewrecords:true,//显示总记录数
            autowidth:true,//自适应宽度
            multiselect:true,
            rownumbers:true
        }).jqGrid("navGrid","#pager" ,
            {add:false,edit:false,del:true},
            {},
            {},
            {
                afterComplete:function (response) {
                    var msg=response.responseJSON.msg;
                    setTimeout(function () {
                        $("#bannerMsgId").hide()
                    },3000);
                }
            }
            )//,search:false
    })
   function showModal() {
       $("#myModal").modal("show");
       $("#addArticleFrom")[0].reset();
       KindEditor.html("#editor","");

     /*  $("#myModal").modal("hide")
       $("#addArticleFrom")[0].reset();
       KindEditor.html("#editor", "");*/
       $("#modal_footer").html(
           "<button type=\"button\" class=\"btn btn-primary\" onclick=\"addModal()\">保存</button>\n" +
           "<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">取消</button>")
       KindEditor.create('#editor',{
           uploadJson:"${pageContext.request.contextPath}/kindeditor/uploading",
           filePostName:"img",//默认是imgFile
           allowFileManager:true,//显示图片空间
           fileManagerJson:"${pageContext.request.contextPath}/kindeditor/getAll",
            allowFileManager:true,
           resizeType:2, //2或1或0，2时可以拖动改变宽度和高度，1时只能改变高度，0时不能拖动。
           afterBlur: function () {
               this.sync();
           }
       });
   }
   function addModal() {
       $("#myModal").modal("hide");
       //var msg = response.responseJSON.msg;
       $.ajax({
           url:"${pageContext.request.contextPath}/Article/edit",
           datatype:"json",
           type:"post",
           data:$("#addArticleFrom").serialize(),
           success:function () {
               $("#articleList").trigger("reloadGrid");
               $("#articleMsgId").show().html(msg);
               setTimeout(function(){
                   $("#articleMsgId").hide()
               }, 3000);
           }
       });
       //return response;
   }
    function lookModal(id) {
        var value=$("#articleList").jqGrid("getRowData",id);
        $("#myModal").modal("show");
        $("#title").val(value.title);
        if (value.status == '展示') {
            $("#status").val('展示')
        }else {
            $("#status").val('不展示')
        }
        $("#modal_footer").html(
            "<button type=\"button\" class=\"btn btn-primary\" onclick=\"saveModal('"+id+"')\">保存</button>\n" +
            "<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">取消</button>")
        KindEditor.create('#editor',{
            uploadJson:"${pageContext.request.contextPath}/kindeditor/uploading",
            filePostName:"img",//默认是imgFile
            allowFileManager:true,//显示图片空间
            fileManagerJson:"${pageContext.request.contextPath}/kindeditor/getAll",
            resizeType:2, //2或1或0，2时可以拖动改变宽度和高度，1时只能改变高度，0时不能拖动。
            afterBlur: function () {
                this.sync();
            }
        });
        $("#editor").val(value.context);
        KindEditor.html("#editor",value.context);
    }
            function saveModal(id) {
                $("#myModal").modal("hide");
                $.ajax({
                    url:"${pageContext.request.contextPath}/Article/update?id="+id,
                    datatype:"json",
                    type:"post",
                    data:$("#addArticleFrom").serialize(),
                    success:function () {
                        $("#articleList").trigger("reloadGrid");
                        $("#articleMsgId").show().html(msg);
                        setTimeout(function(){
                            $("#articleMsgId").hide()
                        }, 3000);
                    }
                })
            }
            function deleteModal(id) {
                $.ajax({
                    url:"${pageContext.request.contextPath}/Article/delete?id="+id,
                    datatype:"json",
                    type:"post",
                    data:$("#addArticleFrom").serialize(),
                    success:function () {
                        $("#articleList").trigger("reloadGrid");
                        $("#articleMsgId").show().html(msg);
                        setTimeout(function(){
                            $("#articleMsgId").hide()
                        }, 3000);
                    }
                });
            }

</script>
<h1>文章管理</h1>
<div>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active">
            <a href="#home" aria-controls="home" role="tab" data-toggle="tab">文章信息</a></li>
        <li><a href="javascript:void(0)" onclick="showModal()"><b>添加文章</b></a></li>

    </ul>
</div>
<table id="articleList" class="table table-striped"></table>

<div id="pager" style="height: 50px"></div>

<div id="articleMsgId" class="alert alert-warning alert-dismissible" role="alert" style="display:none">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <strong>Warning!</strong>
</div>





<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content" style="width:750px">
            <!--模态框标题-->
            <div class="modal-header">
                <!--
                    用来关闭模态框的属性:data-dismiss="modal"
                -->
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                <h4 class="modal-title">编辑用户信息</h4>
            </div>

            <!--模态框内容体-->
            <div class="modal-body">
                <form action="" class="form-horizontal"
                      id="addArticleFrom">
                    <div class="form-group">
                        <label class="col-sm-1 control-label">标题</label>
                        <div class="col-sm-5">
                            <input type="text" name="title" id="title" placeholder="请输入标题" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">状态</label>
                        <div class="col-sm-5">
                            <select class="form-control" name="status" id="status">
                                <option value="展示">展示</option>
                                <option value="不展示">不展示</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <textarea id="editor" name="content" style="width:700px;height:300px;"></textarea>
                        </div>
                    </div>
                    <input id="addInsertImg" name="insertImg" hidden>
                </form>
            </div>
            <!--模态页脚-->
            <div class="modal-footer" id="modal_footer">

            </div>
        </div>
    </div>
</div>
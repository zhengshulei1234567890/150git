<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8"  isELIgnored="false" %>
<script>
   $(function () {
       $("#albumList").jqGrid({
           url:"${pageContext.request.contextPath}/Album/pager",
           editurl:"${pageContext.request.contextPath}/Album/edit",
           datatype:"json",
           colNames:["编号","标题","分数","作者","播音员","数量","简介","发布时间","状态","封面"],
           colModel:[
               {name:"id"},
               {name:"title",editable:true},
               {name:"score",editable:true},
               {name:"author",editable:true},
               {name:"broadcast",editable:true},
               {name:"count",editable:true},
               {name:"brief",editable:true},
               {name:"createDate",editable:true,edittype: "date"},
               {name:"status",editable:true,editable:true,edittype:"select",
                   editoptions:{value:"展示:展示;不展示:不展示"}},
               {name:"coverPic",editable:true,edittype:"file",
                   formatter:function (cellvalue,options,rowObject){
                       return "<img style='height:80px;width:80px' src='${pageContext.request.contextPath}/img/"+cellvalue+"'>"
                   }
               },
           ],
           pager:"#albumPage",
           height:'200px',
           styleUI:"Bootstrap",
           rowNum:2,//每页显示条数
           page:1,
           rowList:[3,6,9],
           viewrecords:true,//显示总记录数
           autowidth:true,//自适应宽度
           multiselect:true,
           rownumbers:true,
           subGrid:true,
           subGridRowExpanded:function (subGidId, albumId) {
               addSubGrid(subGidId,albumId);
           }
       }).jqGrid("navGrid","#albumPage",
           {addtext:"添加",edittext:"编辑",deltext:"删除", search:false},
           {//修改
               closeAfterEdit:true,
               afterSubmit:function (response) {
                   var albumId = response.responseJSON.albumId;
                   var msg = response.responseJSON.msg;
                   if (albumId != "") {
                   $.ajaxFileUpload({
                       url: "${pageContext.request.contextPath}/Album/upload",
                       type: "post",
                       fileElementId: "coverPic",
                       data:{albumId:albumId},
                       success:function () {
                           $("#albumList").trigger("reloadGrid");
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
                   var albumId = response.responseJSON.albumId;
                   var msg = response.responseJSON.msg;
                   $.ajaxFileUpload({
                       url: "${pageContext.request.contextPath}/Album/upload",
                       type: "post",
                       fileElementId: "coverPic",
                       data:{albumId:albumId},
                       success:function () {
                           $("#albumList").trigger("reloadGrid");
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

       );
   })


    function addSubGrid(subGidId, albumId) {
        var subGridTableId=subGidId +"table";
        var subGridPagerId=subGidId + "paper";
        $("#" +subGidId).html(
            "<table id='" + subGridTableId + "' class=\"table table-striped\"></table>" +
            "<div id='" + subGridPagerId + "' style=\"height: 50px\"></div>")
    $("#"+ subGridTableId).jqGrid({
        url:"${pageContext.request.contextPath}/chapter/pager?albumId="+albumId,
        editurl: "${pageContext.request.contextPath}/chapter/edit?albumId="+albumId,
        datatype:"json",
        colNames:["编号","albumId","标题","章节大小","时长","上传时间","操作"],
        colModel:[
            {name:"id"},
            {name:"albumId"},
            {name:"title",editable:true},
            {name:"size"},
            {name:"duration"},
            {name:"createdate",edittype: "date"},
            {name:"path",editable:true,edittype:"file",
                formatter:function (cellvalue){
                    return "<a href='#' onclick=\"playAudio('"+cellvalue+"')\"><span class='glyphicon glyphicon-play-circle'></span></a>&nbsp;&nbsp;&nbsp;" +
                        "<a href='#' onclick=\"downLoadAudio('"+cellvalue+"')\"><span class='glyphicon glyphicon-download'></span></a> "
                }
            }
        ],
        pager:"#"+subGridPagerId,
        height:'200px',
        styleUI:"Bootstrap",
        rowNum:4,//每页显示条数
        rowList:[3,6,9],
        viewrecords:true,//显示总记录数
        autowidth:true,//自适应宽度
        multiselect:true,
        rownumbers:true,
    }).jqGrid("navGrid","#" + subGridPagerId,
        {addtext:"添加",edittext:"编辑",deltext:"删除", search:false},
        {//修改
            closeAfterEdit:true,
            afterSubmit: function (response) {
                var chapterId = response.responseJSON.chapterId
                $.ajaxFileUpload({
                    url: "${pageContext.request.contextPath}/chapter/upload",
                    type: "post",
                    fileElementId: "path",
                    data: {chapterId: chapterId},
                    success: function () {
                        $("#subGridTableId").trigger("reloadGrid");
                        $("#subGridPagerId").show().html(msg);
                        setTimeout(function(){
                            $("#subGridPagerId").hide()
                        }, 3000);
                    }
                })

                return response;
            }
        },
        {//添加
            closeAfterAdd:true,
            afterSubmit: function (response){
                var chapterId=response.responseJSON.chapterId
                //console.log(response)
                $.ajaxFileUpload({
                    url: "${pageContext.request.contextPath}/chapter/upload",
                    type: "post",
                    fileElementId: "path",
                    data: {chapterId: chapterId},
                    success: function () {
                        $("#subGridTableId").trigger("reloadGrid");
                        $("#subGridPagerId").show().html(msg);
                        setTimeout(function(){
                            $("#subGridPagerId").hide()
                        }, 3000);
                    }
                })
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
   }
   function playAudio(cellvalue) {
       $("#playAudio").modal("show")
       $("#audioId").attr("src","${pageContext.request.contextPath}/upload/audio/"+cellvalue);
   }
   function downLoadAudio(cellvalue) {
       location.href="${pageContext.request.contextPath}/chapter/downLoadAudio?audioName="+cellvalue;
   }
</script>
<h1>专辑与章节管理</h1>
<div>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">专辑与章节信息</a></li>
    </ul>
</div>

<div id="playAudio" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <audio id="audioId" src="" controls></audio>
    </div>
</div>


<table id="albumList" class="table table-striped"></table>
<div id="albumPage" style="height:50px"></div>

<div id="bannerMsgId" class="alert alert-warning alert-dismissible" role="alert" style="display:none">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <strong>Warning!</strong>
</div>
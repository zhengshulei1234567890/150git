<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<html>
<head>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="application/javascript">
        $(function () {
            //通过ajax查询所有的省份 并渲染到第一个下拉列表中    省
            $.ajax({
                url: "${pageContext.request.contextPath}/cascade/showAllProvince",
                type: "GET",
                dataType: "json",
                success: function (provinces) {
                    for (var i = 0; i < provinces.length; i++) {
                        var option = $("<option value=" + provinces[i].code + ">" + provinces[i].name + "<option>");
                        //把option放入select标签里
                        $("#province").append(option);
                    }
                }
            });
            //把第一个市展示 在第二个下拉框
            $.ajax({
                url: "${pageContext.request.contextPath}/cascade/showcity",
                type: "GET",
                data: "provincecode=" + 110000,
                dataType: "json",
                success: function (citys) {
                    //把查到的市放入下拉列表中
                    //alert(citys[0]);
                    for (var i = 0; i < citys.length; i++) {
                        var option = $("<option value=" + citys[i].code + ">" + citys[i].name + "<option>");
                        $("#city").append(option);
                    }
                }
            });
            //把第一个区展示出来
          $.ajax({
                url:"${pageContext.request.contextPath}/cascade/areashow",
                type:"GET",
                data:"citycode=" +110100,
                dataType:"json",
                success:function (areas) {
                    for (var i = 0; i < areas.length; i++) {
                        var option = $("<option>" + areas[i].name + "<option>");
                        $("#area").append(option);
                    }
                }
            });

            //给第一个select标签添加onchange事件   市
            $("#province").change(function () {
                $("#city").empty();
                $("#area").empty();
                //获取选中的省份code
                var provincecode = $("#province option:selected").val();
                // alert(provincecode);
                //通过AJAX请求查询对应的市
                $.ajax({
                    url: "${pageContext.request.contextPath}/cascade/showcity",
                    type: "GET",
                    data: "provincecode=" + provincecode,
                    dataType: "json",
                    success: function (citys) {
                        //把查到的市放入下拉列表中
                        //alert(citys[0].code);
                        for (var i = 0; i < citys.length; i++) {
                            var option = $("<option value=" + citys[i].code + ">" + citys[i].name + "<option>");
                            $("#city").append(option);
                        }
        //查到所有城市之后 把第一个城市的code通过ajax请求  获取对应的区域
                        $.ajax({
                            url: "${pageContext.request.contextPath}/cascade/areashow",
                            type: "GET",
                            data: "citycode=" + citys[0].code,
                            dataType: "json",
                            success: function (areas) {
                                for (var i = 0; i < areas.length; i++) {
                                    var option = $("<option>" + areas[i].name + "<option>");
                                    $("#area").append(option);
                                }
                            }
                        });
                    }
                });
            });
            //给第二个下拉列表添加change事件    区
            $("#city").change(function () {
                $("#area").empty();
                //获取选中的city的code
                var citycode = $("#city option:selected").val();
                //通过ajax获取该是对应的区域
                $.ajax({
                    url: "${pageContext.request.contextPath}/cascade/areashow",
                    type: "GET",
                    data: "citycode=" + citycode,
                    dataType: "json",
                    success: function (areas) {
                        for (var i = 0; i < areas.length; i++) {
                            var option = $("<option>" + areas[i].name + "<option>");
                            $("#area").append(option);
                        }
                    }
                });
            })
        })
    </script>
</head>
    <body>
        <select id="province">

        </select>
        <select id="city">

        </select>
        <select id="area">

        </select>
    </body>
</html>
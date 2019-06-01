<%@page pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="boot/js/jquery-2.2.1.min.js"></script>
    <script src="echarts/echarts.min.js"></script>
    <script src="echarts/china.js"></script>
</head>
<body>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '一周内的用户注册走势图'
            },
            tooltip: {},
            legend: {
                data:['形式']
            },
            xAxis: {
                data: []
            },
            yAxis: {},

        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        $.ajax({
            url:"${pageContext.request.contextPath}/user/goeasy",
            type:"get",
            datatype:"json",
            success:function (data) {
                myChart.setOption({
                    xAxis: {
                        data:data[0].日期
                    },
                    series: [{
                        name: '销量',
                        type: 'line',//'line'线'pie'圆形
                        data: data[0].数量
                    },
                    ]
                })
            }

        })
        /*var goEasy=new goEasy({
            appkey:"my_appkey",
        });
        //用户分布图
       goEasy.subscribe({

        })*/

    </script>
</body>
</html>
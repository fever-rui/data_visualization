/*----------------------柱状图-----------------------*/
//坐标轴刻度与标签对齐

    var columnar1 = echarts.init(document.getElementById("columnar1"));

    option1 = {

        title: {
            text: "柱状图",
            x:'left'
        },

        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        toolbox: {
            show: true,
            feature: {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data: ['直接访问']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'直接访问',
                type:'bar',
                data:[10, 52, 200, 334, 390, 330, 220]
            }
        ]
    };

    columnar1.setOption(option1);



//堆叠条形图
    var columnar2 = echarts.init(document.getElementById("columnar2"));

    option2 = {

        title : {
            text: "堆叠条形图",
            x:'left'
        },

        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        toolbox: {
            show: true,
            feature: {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data: ['直接访问', '邮件营销','联盟广告','视频广告','搜索引擎'],
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis:  {
            type: 'value'
        },
        yAxis: {
            type: 'category',
            data: ['周一','周二','周三','周四','周五','周六','周日']
        },
        series: [
            {
                name: '直接访问',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [320, 302, 301, 334, 390, 330, 320]
            },
            {
                name: '邮件营销',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [120, 132, 101, 134, 90, 230, 210]
            },
            {
                name: '联盟广告',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [220, 182, 191, 234, 290, 330, 310]
            },
            {
                name: '视频广告',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [150, 212, 201, 154, 190, 330, 410]
            },
            {
                name: '搜索引擎',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [820, 832, 901, 934, 1290, 1330, 1320]
            }
        ]
    };
    columnar2.setOption(option2);


//正负条形图

    var columnar3 = echarts.init(document.getElementById("columnar3"));

    option3 = {

        title : {
            text: "正负条形图",
            x:'left'
        },

        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        toolbox: {
            show: true,
            feature: {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data:['利润', '支出', '收入'],
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'value'
            }
        ],
        yAxis : [
            {
                type : 'category',
                axisTick : {show: false},
                data : ['周一','周二','周三','周四','周五','周六','周日']
            }
        ],
        series : [
            {
                name:'利润',
                type:'bar',
                label: {
                    normal: {
                        show: true,
                        position: 'inside'
                    }
                },
                data:[200, 170, 240, 244, 200, 220, 210]
            },
            {
                name:'收入',
                type:'bar',
                label: {
                    normal: {
                        show: true
                    }
                },
                data:[320, 302, 341, 374, 390, 450, 420]
            },
            {
                name:'支出',
                type:'bar',
                label: {
                    normal: {
                        show: true,
                        position: 'left'
                    }
                },
                data:[-120, -132, -101, -134, -190, -230, -210]
            }
        ]
    };
    columnar3.setOption(option3);


//折柱混合
    var columnar4 = echarts.init(document.getElementById("columnar4"));


    option = {

        title : {
            text: "折柱混合图",
            x: "left"
        },

        tooltip: {
            trigger: 'axis'
        },
        toolbox: {
            show: true,
            feature: {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data:['蒸发量','降水量','平均温度'],
        },
        xAxis: [
            {
                type: 'category',
                data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '水量',
                min: 0,
                max: 250,
                interval: 50,
                axisLabel: {
                    formatter: '{value} ml'
                }
            },
            {
                type: 'value',
                name: '温度',
                min: 0,
                max: 25,
                interval: 5,
                axisLabel: {
                    formatter: '{value} °C'
                }
            }
        ],
        series: [
            {
                name:'蒸发量',
                type:'bar',
                data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
            },
            {
                name:'降水量',
                type:'bar',
                data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
            },
            {
                name:'平均温度',
                type:'line',
                yAxisIndex: 1,
                data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
            }
        ]
    };
    columnar4.setOption(option);

$('#fileSubmit').click(function () {
    if($("#doc-form-file").val() == "") {
        $('#alertSelectFile').modal();
    }else {
        var form = new FormData(document.getElementById("fileForm"));
        $.ajax({
            url:"/record/columnar_fileLoad",
            type:"post",
            data:form,
            processData:false,
            contentType:false,
            success:function(data){
                if(data==='false') {
                    $('#typeFalse-model').modal();
                }else {
                    removeFile();
                    $('#success-model').modal();
                    modifyChart(data);
                }
            },
            error:function(){
                $('#failure-model').modal();
            }
        });
    }

});


function modifyChart(chartData) {

    var jsonData = JSON.parse(chartData);
    var len = jsonData.data.length;

    var namesx = [];    //类别数组（实际用来盛放X轴坐标值）
    var names = [];     //存放数据系列名称

    namesx=jsonData.axis[0].name;

    {
        //图1，柱形图
        var Item = function () {
            return {
                name:'',
                type:'bar',
                data:[]
            }
        };

        var mySeries = [];

        for (var i = 0; i < len; i++) {
            names.push(jsonData.data[i].name);    //挨个取出类别并填入
            var it = new Item();
            it.name = jsonData.data[i].name;
            it.data = jsonData.data[i].value
            mySeries.push(it);
        }
        option1.title.text=jsonData.title;
        option1.series = mySeries;

        option1.legend.data = names;
        option1.xAxis.data = namesx;


        columnar1.setOption(option1,true);

    }


    {
        //图2，堆叠条形图
        var Item = function () {
            return {
                name:'',
                type:'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data:[]
            }
        };

        var mySeries = [];

        for (var i = 0; i < len; i++) {
            names.push(jsonData.data[i].name);    //挨个取出类别并填入
            var it = new Item();
            it.name = jsonData.data[i].name;
            it.data = jsonData.data[i].value
            mySeries.push(it);
        }
        option2.title.text=jsonData.title;
        option2.series = mySeries;

        option2.legend.data = names;
        option2.yAxis.data = namesx;


        columnar2.setOption(option2,true);
    }

    {
        //图3，正负条形图
        var Item = function () {
            return {
                name:'',
                type:'bar',
                label: {
                    normal: {
                        show: true,
                        position: 'inside'
                    }
                },
                data:[]
            }

        };

        var mySeries = [];

        for (var i = 0; i < len; i++) {
            names.push(jsonData.data[i].name);    //挨个取出类别并填入
            var it = new Item();
            it.name = jsonData.data[i].name;
            it.data = jsonData.data[i].value
            mySeries.push(it);
        }
        option3.title.text=jsonData.title;
        option3.series =mySeries;

        option3.legend.data = names;
        option3.yAxis.data = namesx;


        columnar3.setOption(option3,true);
    }

}

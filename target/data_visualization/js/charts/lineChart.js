/*----------------------折线图-----------------------*/
//表单提交
$('#fileSubmit').click(function () {
    if($("#doc-form-file").val() == "") {
        $('#alertSelectFile').modal();
    }else {
        var form = new FormData(document.getElementById("fileForm"));
        $.ajax({
            url:"/record/line_fileLoad",
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


//折线图堆叠\平铺

	
	var myChart = echarts.init(document.getElementById("Stack"));

    option1 = {
        title: {
            text: '折线图'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['测试1','测试2','测试3']
        },
        toolbox: {
            show: true,
            feature: {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                magicType: {show: true, type: ['stack', 'tiled']},
                saveAsImage: {show: true}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['周一','周二','周三','周四','周五','周六','周日']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: '测试1',
            type: 'line',
            smooth: true,
            data: [10, 12, 21, 54, 260, 830, 710]
        },
            {
                name: '测试2',
                type: 'line',
                smooth: true,
                data: [30, 182, 434, 791, 390, 30, 10]
            },
            {
                name: '测试3',
                type: 'line',
                smooth: true,
                data: [1320, 1132, 601, 234, 120, 90, 20]
            }]
    };

myChart.setOption(option1);



//堆叠区域图

	
	var area = echarts.init(document.getElementById("area"));
	
	option2 = {
    title: {
        text: '堆叠区域图'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['测试1','测试2','测试3','测试4','测试5','测试6','测试7']
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
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : {
            type : 'category',
            boundaryGap : false,
            data : ['周一','周二','周三','周四','周五','周六','周日']
    },
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'测试1',
            type:'line',
            stack: '总量',
            areaStyle: {normal: {}},
            data:[120, 132, 101, 134, 90, 230, 210]
        },
        {
            name:'测试2',
            type:'line',
            stack: '总量',
            areaStyle: {normal: {}},
            data:[220, 182, 191, 234, 290, 330, 310]
        },
        {
            name:'测试3',
            type:'line',
            stack: '总量',
            areaStyle: {normal: {}},
            data:[150, 232, 201, 154, 190, 330, 410]
        },
        {
            name:'测试4',
            type:'line',
            stack: '总量',
            areaStyle: {normal: {}},
            data:[320, 332, 301, 334, 390, 330, 320]
        },
        {
            name:'测试5',
            type:'line',
            stack: '总量',
            // label: {
            //     normal: {
            //         show: true,
            //         position: 'top'
            //     }
            // },
            areaStyle: {normal: {}},
            data:[820, 932, 901, 934, 1290, 1330, 1320]
        }
    ]
};

area.setOption(option2);



//对数轴

	
	var step = echarts.init(document.getElementById("step"));
	
	option3 = {
    title: {
        text: 'Step Line'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['Step Start', 'Step Middle', 'Step End']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
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
    xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name:'Step Start',
            type:'line',
            step: 'start',
            data:[120, 132, 101, 134, 90, 230, 210]
        },
        {
            name:'Step Middle',
            type:'line',
            step: 'middle',
            data:[220, 282, 201, 234, 290, 430, 410]
        },
        {
            name:'Step End',
            type:'line',
            step: 'end',
            data:[450, 432, 401, 454, 590, 530, 510]
        }
    ]
};

step.setOption(option3);



//大数据量面积图

	var shuju = echarts.init(document.getElementById("shuju"));

	var base = +new Date(1968, 9, 3);
var oneDay = 24 * 3600 * 1000;
var date = [];

var data = [Math.random() * 300];

for (var i = 1; i < 20000; i++) {
    var now = new Date(base += oneDay);
    date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'));
    data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]));
}

option4 = {
    tooltip: {
        trigger: 'axis',
        position: function (pt) {
            return [pt[0], '10%'];
        }
    },
    title: {
        left: 'center',
        text: '大数据量面积图',
    },
    legend: {
        top: 'bottom',
        data:['意向']
    },
    toolbox: {
        feature: {
            dataZoom: {
                yAxisIndex: 'none'
            },
            restore: {},
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: date
    },
    yAxis: {
        type: 'value',
        boundaryGap: [0, '100%']
    },
    dataZoom: [{
        type: 'inside',
        start: 0,
        end: 10
    }, {
        start: 0,
        end: 10,
        handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
        handleSize: '80%',
        handleStyle: {
            color: '#fff',
            shadowBlur: 3,
            shadowColor: 'rgba(0, 0, 0, 0.6)',
            shadowOffsetX: 2,
            shadowOffsetY: 2
        }
    }],
    series: [
        {
            name:'模拟数据',
            type:'line',
            smooth:true,
            symbol: 'none',
            sampling: 'average',
            itemStyle: {
                normal: {
                    color: 'rgb(255, 70, 131)'
                }
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgb(255, 158, 68)'
                    }, {
                        offset: 1,
                        color: 'rgb(255, 70, 131)'
                    }])
                }
            },
            data: data
        }
    ]
};

	shuju.setOption(option4);




//动态数据+时间坐标轴


	var trends = echarts.init(document.getElementById("trends"));

	function randomData() {
    now = new Date(+now + oneDay);
    value = value + Math.random() * 21 - 10;
    return {
        name: now.toString(),
        value: [
            [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
            Math.round(value)
        ]
    }
}

var data = [];
var now = +new Date(1997, 9, 3);
var oneDay = 24 * 3600 * 1000;
var value = Math.random() * 1000;
for (var i = 0; i < 1000; i++) {
    data.push(randomData());
}

option5 = {
    title: {
        text: '动态数据 + 时间坐标轴'
    },
    tooltip: {
        trigger: 'axis',
        formatter: function (params) {
            params = params[0];
            var date = new Date(params.name);
            return date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1];
        },
        axisPointer: {
            animation: false
        }
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'time',
        splitLine: {
            show: false
        }
    },
    yAxis: {
        type: 'value',
        boundaryGap: [0, '100%'],
        splitLine: {
            show: false
        }
    },
    series: [{
        name: '模拟数据',
        type: 'line',
        showSymbol: false,
        hoverAnimation: false,
        data: data
    }]
};

	timeTicket = setInterval(function () {

	    for (var i = 0; i < 5; i++) {
	        data.shift();
	        data.push(randomData());
	    }

	    trends.setOption({
	        series: [{
	            data: data
	        }]
	    });
	}, 1000);

trends.setOption(option5);







//动态修改
function modifyChart(chartData) {

    var jsonData = JSON.parse(chartData);
    var len = jsonData.data.length;

    var namesx = [];    //类别数组（实际用来盛放X轴坐标值）
    var names = [];     //存放数据系列名称

    namesx=jsonData.xAxis[0].name;

    {
        //图1，堆叠、平铺
        var Item = function () {
            return {
                name: '',
                type: 'line',
                step: '',
                smooth: 'false',
                data: []
            }
        };

        var mySeries = [];

        for (var i = 0; i < len; i++) {
            names.push(jsonData.data[i].name);    //挨个取出类别并填入
            var it = new Item();
            it.name = jsonData.data[i].name;
            it.smooth = jsonData.data[i].smooth;
            it.data = jsonData.data[i].value
            mySeries.push(it);
        }
        option1.title.text=jsonData.title;
        option1.series = mySeries;

        option1.legend.data = names;
        option1.xAxis.data = namesx;


        myChart.setOption(option1,true);
    }


    {
        //图2、堆叠面积图
        var Item = function () {
            return {
                name: '',
                type: 'line',
                step: '',
                smooth: '',
                stack: '总量',
                areaStyle: {normal: {}},
                data: []
            }
        };

        var mySeries = [];

        for (var i = 0; i < len; i++) {
            names.push(jsonData.data[i].name);    //挨个取出类别并填入
            var it = new Item();
            it.name = jsonData.data[i].name;
            it.smooth = jsonData.data[i].smooth;
            it.data = jsonData.data[i].value;
            mySeries.push(it);
        }

        option2.series = mySeries;
        option2.title.text=jsonData.title;
        option2.legend.data = names;
        option2.xAxis.data=namesx;


        area.setOption(option2,true);

    }

    {
        //图三、step line
        var Item = function () {
            return {
                name: '',
                type: 'line',
                step: 'true',
                smooth: '',
                data: []
            }
        };

        var mySeries = [];

        for (var i = 0; i < len; i++) {
            names.push(jsonData.data[i].name);    //挨个取出类别并填入
            var it = new Item();
            it.name = jsonData.data[i].name;
            it.smooth = jsonData.data[i].smooth;
            it.data = jsonData.data[i].value;
            it.step=jsonData.data[i].step;
            mySeries.push(it);
        }

        option3.series = mySeries;
        option3.title.text=jsonData.title;
        option3.legend.data = names;
        option3.xAxis.data = namesx;


        step.setOption(option3,true);
    }
}



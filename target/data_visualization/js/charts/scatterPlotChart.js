/**
 * Created by fever on 2017/4/6.
 */
var scatter1 = echarts.init(document.getElementById("scatter1"));

var dataAll = [
    [
        [10.0, 8.04],
        [8.0, 6.95],
        [13.0, 7.58],
        [9.0, 8.81],
        [11.0, 8.33],
        [14.0, 9.96],
        [6.0, 7.24],
        [4.0, 4.26],
        [12.0, 10.84],
        [7.0, 4.82],
        [5.0, 5.68]
    ],[
        [10.0, 9.14],
        [8.0, 8.14],
        [13.0, 8.74],
        [9.0, 8.77],
        [11.0, 9.26],
        [14.0, 8.10],
        [6.0, 6.13],
        [4.0, 3.10],
        [12.0, 9.13],
        [7.0, 7.26],
        [5.0, 4.74]
    ],
    [
        [8.0, 6.58],
        [8.0, 5.76],
        [8.0, 7.71],
        [8.0, 8.84],
        [8.0, 8.47],
        [8.0, 7.04],
        [8.0, 5.25],
        [19.0, 12.50],
        [8.0, 5.56],
        [8.0, 7.91],
        [8.0, 6.89]
    ]
];

option1 = {
    title: {
        text: '散点图',
    },
    xAxis: [
        {name:"x"}
    ],
    yAxis: [
        {name:"y"}
    ],
    legend: {
        data: ['I', 'II','III']
    },
    tooltip: {
        formatter: 'Group {a}: ({c})'
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['pie', 'funnel']
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    visualMap: [
        {
            left: 'right',
            top: '10%',
            min: 0,
            max: 20,
            dimension: 0,
            itemWidth: 30,
            itemHeight: 120,
            calculable: true,
            precision: 0.1,
            text: ['x轴'],
            textGap: 20,
            textStyle: {
                color: '#fff'
            },
            inRange: {
                symbolSize: [10, 20]
            },
            outOfRange: {
                symbolSize: [10, 20],
                color: ['rgba(255,255,255,.2)']
            },
            controller: {
                inRange: {
                    color: ['#c23531']
                },
                outOfRange: {
                    color: ['#444']
                }
            }
        },
        {
            left: 'right',
            bottom: '1%',
            dimension: 1,
            min: 0,
            max: 15,
            itemWidth: 30,
            itemHeight: 120,
            calculable: true,
            precision: 0.1,
            text: ['y轴'],
            textGap: 20,
            textStyle: {
                color: '#fff'
            },
            inRange: {
                symbolSize: [10, 20]
            },
            outOfRange: {
                symbolSize: [10, 20],
                color: ['rgba(255,255,255,.2)']
            },
            controller: {
                inRange: {
                    color: ['#c23531']
                },
                outOfRange: {
                    color: ['#444']
                }
            }
        }
    ],
    series: [
        {
            name: 'I',
            type: 'scatter',
            data: dataAll[0]
        },
        {
            name: 'II',
            type: 'scatter',
            data: dataAll[1]
        },
        {
            name: 'III',
            type: 'scatter',
            data: dataAll[2]
        }
    ]
};

scatter1.setOption(option1,true);

//表单提交
$('#fileSubmit').click(function () {
    if($("#doc-form-file").val() == "") {
        $('#alertSelectFile').modal();
    }else {
        var form = new FormData(document.getElementById("fileForm"));
        $.ajax({
            url:"/record/scatter_fileLoad",
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

//动态修改
function modifyChart(chartData) {

    var jsonData = JSON.parse(chartData);
    var len = jsonData.data[0].name.length;
    var namesx = '';
    var namesy = '';//类别数组（实际用来盛放X轴坐标值）
    var names = [];     //存放数据系列名称
    namesx=jsonData.xAxis[0].name;
    namesy=jsonData.yAxis[0].name;

    {
        //修改visualmap
        var itemVisual = function () {
            return {
                left: 'right',
                top: '10%',
                min: 0,
                max: 20,
                dimension: 0,
                itemWidth: 30,
                itemHeight: 120,
                calculable: true,
                precision: 0.1,
                text: ['x轴'],
                textGap: 20,
                textStyle: {
                    color: '#fff'
                },
                inRange: {
                    symbolSize: [10, 20]
                },
                outOfRange: {
                    symbolSize: [10, 20],
                    color: ['rgba(255,255,255,.2)']
                },
                controller: {
                    inRange: {
                        color: ['#c23531']
                    },
                    outOfRange: {
                        color: ['#444']
                    }
                },
            }
        };
        var myVisual = [];


        for(var i=0;i<jsonData.visualMap.length;i++){
            var it = new itemVisual();
            it.min=jsonData.visualMap[i].min;
            it.max=jsonData.visualMap[i].max;
            it.text=jsonData.visualMap[i].text;
            it.dimension=jsonData.visualMap[i].dimension;
            it.inRange.symbolSize=jsonData.visualMap[i].inRange.symbolSize;
            it.outOfRange.symbolSize=jsonData.visualMap[i].outOfRange.symbolSize;
            myVisual.push(it);
        }

        //修改series
        var Item = function () {
            return {
                name: '',
                type: 'scatter',
                data: []
            }
        };

        var mySeries = [];

        for (var i = 0; i < len; i++) {
            names.push(jsonData.data[0].name[i]);    //挨个取出类别并填入
            var it = new Item();
            it.name = jsonData.data[0].name[i];
            it.data=jsonData.dataAll[i];
            mySeries.push(it);
        }
        option1.title.text=jsonData.title;
        option1.series = mySeries;
        option1.legend.data = names;
        option1.xAxis[0].name = namesx;
        option1.yAxis[0].name = namesy;
        option1.visualMap=myVisual;


        scatter1.setOption(option1,true);
    }
}






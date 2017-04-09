/**
 * Created by fever on 2017/4/6.
 */

//表单提交
$('#fileSubmit').click(function () {
    if($("#doc-form-file").val() == "") {
        $('#alertSelectFile').modal();
    }else {
        var form = new FormData(document.getElementById("fileForm"));
        $.ajax({
            url:"/record/radar_fileLoad",
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
    // var indicator_len=jsonData.data.length;
    //
    // var namesIndicator = [];    //类别数组（实际用来存放类型）
    var names = [];     //存放数据系列名称
    for (var i = 0; i < len; i++) {
        names.push(jsonData.data[i].name);    //挨个取出类别并填入
    }

    {
        var Item = function () {
            return {
                type: 'radar',
                data: []
            }
        };

        //设置新的series
        var mySeries = [];
        var it=new Item();
        it.data=jsonData.data;
        mySeries.push(it);

        //赋值给option
        option.radar.shape='polygon';
        option.title.text=jsonData.title;
        option.series = mySeries;
        option.legend.data = names;
        option.radar.indicator=jsonData.indicator;

        radar1.setOption(option,true);
        option.radar.shape='circle';
        radar3.setOption(option,true);
    }

    {

        var Item = function () {
            return {
                type: 'radar',
                areaStyle: {normal: {}},
                data: []
            }
        };

        //设置新的series
        var mySeries = [];
        var it=new Item();
        it.data=jsonData.data;
        mySeries.push(it);

        //赋值给option
        option.title.text=jsonData.title;
        option.series = mySeries;
        option.legend.data = names;
        option.radar.indicator=jsonData.indicator;
        option.radar.shape='polygon';

        radar2.setOption(option,true);
        option.radar.shape='circle';
        radar4.setOption(option,true);
    }
}


var radar1 = echarts.init(document.getElementById("radar1"));

option = {
    title: {
        text: '多边形雷达图'
    },
    tooltip: {},
    legend: {
        data: ['测试标题1', '测试标题2']
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
    radar: {
        shape: 'polygon',
        indicator: [
            { name: '测试1', max: 6500},
            { name: '测试2', max: 16000},
            { name: '测试3', max: 30000},
            { name: '测试4', max: 38000},
            { name: '测试5', max: 52000},
            { name: '测试6', max: 25000}
        ]
    },
    series: [{
        type: 'radar',
        data : [
            {
                value : [4300, 10000, 28000, 35000, 50000, 19000],
                name : '测试标题1'
            },
            {
                value : [5000, 14000, 28000, 31000, 42000, 21000],
                name : '测试标题2'
            }
        ]
    }]
};

radar1.setOption(option,true);

var radar2 = echarts.init(document.getElementById("radar2"));

option = {
    title: {
        text: '多边形区域雷达图'
    },
    tooltip: {},
    legend: {
        data: ['测试标题1', '测试标题2']
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
    radar: {
        shape: 'polygon',
        indicator: [
            { name: '测试1', max: 6500},
            { name: '测试2', max: 16000},
            { name: '测试3', max: 30000},
            { name: '测试4', max: 38000},
            { name: '测试5', max: 52000},
            { name: '测试6', max: 25000}
        ]
    },
    series: [{
        type: 'radar',
        areaStyle: {normal: {}},
        data : [
            {
                value : [4300, 10000, 28000, 35000, 50000, 19000],
                name : '测试标题1'
            },
            {
                value : [5000, 14000, 28000, 31000, 42000, 21000],
                name : '测试标题2'
            }
        ]
    }]
};

radar2.setOption(option,true);

var radar3 = echarts.init(document.getElementById("radar3"));

option = {
    title: {
        text: '圆形雷达图'
    },
    tooltip: {},
    legend: {
        data: ['测试标题1', '测试标题2']
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
    radar: {
        shape: 'circle',
        indicator: [
            { name: '测试1', max: 6500},
            { name: '测试2', max: 16000},
            { name: '测试3', max: 30000},
            { name: '测试4', max: 38000},
            { name: '测试5', max: 52000},
            { name: '测试6', max: 25000}
        ]
    },
    series: [{
        type: 'radar',
        data : [
            {
                value : [4300, 10000, 28000, 35000, 50000, 19000],
                name : '测试标题1'
            },
            {
                value : [5000, 14000, 28000, 31000, 42000, 21000],
                name : '测试标题2'
            }
        ]
    }]
};

radar3.setOption(option,true);

var radar4 = echarts.init(document.getElementById("radar4"));

option = {
    title: {
        text: '圆形区域雷达图'
    },
    tooltip: {},
    legend: {
        data: ['测试标题1', '测试标题2']
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
    radar: {
        shape: 'circle',
        indicator: [
            { name: '测试1', max: 6500},
            { name: '测试2', max: 16000},
            { name: '测试3', max: 30000},
            { name: '测试4', max: 38000},
            { name: '测试5', max: 52000},
            { name: '测试6', max: 25000}
        ]
    },
    series: [{
        type: 'radar',
        areaStyle: {normal: {}},
        data : [
            {
                value : [4300, 10000, 28000, 35000, 50000, 19000],
                name : '测试标题1'
            },
            {
                value : [5000, 14000, 28000, 31000, 42000, 21000],
                name : '测试标题2'
            }
        ]
    }]
};

radar4.setOption(option,true);
/*----------------------饼状图-----------------------*/

//环形图
	
var pie1 = echarts.init(document.getElementById("pie1"));

option = {
	
	title : {
		text: "环形图",
		x: 'center'
	},
	
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
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
    legend: {
        orient: 'vertical',
        x: 'left',
        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    },
    series: [
        {
            name:'访问来源',
            type:'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                {value:135, name:'视频广告'},
                {value:1548, name:'搜索引擎'}
            ]
        }
    ]
};

pie1.setOption(option);


//嵌套环形图

// var pie2 = echarts.init(document.getElementById("pie2"));
//
// option = {
//
// 	title : {
// 		text: "环形图",
// 		x: 'center'
// 	},
//
//     tooltip: {
//         trigger: 'item',
//         formatter: "{a} <br/>{b}: {c} ({d}%)"
//     },
//     toolbox: {
//         show: true,
//         feature: {
//             saveAsImage: {}
//         }
//     },
//     legend: {
//         orient: 'vertical',
//         x: 'left',
//         data:['直达','营销广告','搜索引擎','邮件营销','联盟广告','视频广告','百度','谷歌','必应','其他']
//     },
//     series: [
//         {
//             name:'访问来源',
//             type:'pie',
//             selectedMode: 'single',
//             radius: [0, '30%'],
//
//             label: {
//                 normal: {
//                     position: 'inner'
//                 }
//             },
//             labelLine: {
//                 normal: {
//                     show: false
//                 }
//             },
//             data:[
//                 {value:335, name:'直达', selected:true},
//                 {value:679, name:'营销广告'},
//                 {value:1548, name:'搜索引擎'}
//             ]
//         },
//         {
//             name:'访问来源',
//             type:'pie',
//             radius: ['40%', '55%'],
//
//             data:[
//                 {value:335, name:'直达'},
//                 {value:310, name:'邮件营销'},
//                 {value:234, name:'联盟广告'},
//                 {value:135, name:'视频广告'},
//                 {value:1048, name:'百度'},
//                 {value:251, name:'谷歌'},
//                 {value:147, name:'必应'},
//                 {value:102, name:'其他'}
//             ]
//         }
//     ]
// };
// pie2.setOption(option);



//饼状图
var pie3 = echarts.init(document.getElementById("pie3"));

option = {
    title : {
        text: '某站点用户访问来源',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
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
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    },
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                {value:135, name:'视频广告'},
                {value:1548, name:'搜索引擎'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};

pie3.setOption(option);


//南丁格尔玫瑰（半径）

var pie4 = echarts.init(document.getElementById("pie4"));

option = {
    title : {
        text: '南丁格尔玫瑰图',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        x : 'center',
        y : 'bottom',
        data:['rose1','rose2','rose3','rose4','rose5','rose6','rose7','rose8']
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
    calculable : true,
    series : [
        {
            name:'半径模式',
            type:'pie',
            radius : [20, 110],
            roseType : 'radius',
            data:[
                {value:10, name:'rose1'},
                {value:5, name:'rose2'},
                {value:15, name:'rose3'},
                {value:25, name:'rose4'},
                {value:20, name:'rose5'},
                {value:35, name:'rose6'},
                {value:30, name:'rose7'},
                {value:40, name:'rose8'}
            ]
        }
    ]
};

pie4.setOption(option);


//南丁格尔玫瑰图（面积）
var pie5 = echarts.init(document.getElementById("pie5"));

option = {
    title : {
        text: '南丁格尔玫瑰图',
        x:'left'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        x : 'center',
        y : 'bottom',
        data:['rose1','rose2','rose3','rose4','rose5','rose6','rose7','rose8']
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
    calculable : true,
    series : [
        {
            name:'面积模式',
            type:'pie',
            radius : [30, 110],
            roseType : 'area',
            data:[
                {value:10, name:'rose1'},
                {value:5, name:'rose2'},
                {value:15, name:'rose3'},
                {value:25, name:'rose4'},
                {value:20, name:'rose5'},
                {value:35, name:'rose6'},
                {value:30, name:'rose7'},
                {value:40, name:'rose8'}
            ]
        }
    ]
};

pie5.setOption(option);


$('#fileSubmit').click(function () {
    if($("#doc-form-file").val() == "") {
        $('#alertSelectFile').modal();
    }else {
        var form = new FormData(document.getElementById("fileForm"));
        $.ajax({
            url:"/record/pie_fileLoad",
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
    // var pie1 = echarts.init(document.getElementById("pie1"));

    var jsonData=JSON.parse(chartData);
    var chartTitle=jsonData.title;
    var len=jsonData.data.length;

    var names=[];    //类别数组（实际用来盛放X轴坐标值）

    for(var i=0;i<len;i++){
        names.push(jsonData.data[i].name);    //挨个取出类别并填入类别数组
    }


//设置环形图1
    option = {

        title : {
            text: chartTitle,
            x: 'center'
        },

        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
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
        legend: {
            orient: 'vertical',
            x: 'left',
            data:names,
        },
        series: [
            {
                name:chartTitle,
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: jsonData.data
            }
        ]
    };

    pie1.setOption(option,true);

    // //设置嵌套环形图
    // option = {
    //
    //     title : {
    //         text: "环形图",
    //         x: 'center'
    //     },
    //
    //     tooltip: {
    //         trigger: 'item',
    //         formatter: "{a} <br/>{b}: {c} ({d}%)"
    //     },
    //     legend: {
    //         orient: 'vertical',
    //         x: 'left',
    //         data:['直达','营销广告','搜索引擎','邮件营销','联盟广告','视频广告','百度','谷歌','必应','其他']
    //     },
    //     series: [
    //         {
    //             name:'访问来源',
    //             type:'pie',
    //             selectedMode: 'single',
    //             radius: [0, '30%'],
    //
    //             label: {
    //                 normal: {
    //                     position: 'inner'
    //                 }
    //             },
    //             labelLine: {
    //                 normal: {
    //                     show: false
    //                 }
    //             },
    //             data:[
    //                 {value:335, name:'直达', selected:true},
    //                 {value:679, name:'营销广告'},
    //                 {value:1548, name:'搜索引擎'}
    //             ]
    //         },
    //         {
    //             name:'访问来源',
    //             type:'pie',
    //             radius: ['40%', '55%'],
    //
    //             data:[
    //                 {value:335, name:'直达'},
    //                 {value:310, name:'邮件营销'},
    //                 {value:234, name:'联盟广告'},
    //                 {value:135, name:'视频广告'},
    //                 {value:1048, name:'百度'},
    //                 {value:251, name:'谷歌'},
    //                 {value:147, name:'必应'},
    //                 {value:102, name:'其他'}
    //             ]
    //         }
    //     ]
    // };
    // pie2.setOption(option);


    //饼状图
    option = {
        title : {
            text: chartTitle,
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
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
        legend: {
            orient: 'vertical',
            left: 'left',
            data: names
        },
        series : [
            {
                name: chartTitle,
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:jsonData.data,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    pie3.setOption(option,true);


    //南丁格尔玫瑰图
    option = {
        title : {
            text: chartTitle,
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            x : 'center',
            y : 'bottom',
            data:names
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
        calculable : true,
        series : [
            {
                name:'半径模式',
                type:'pie',
                radius : [20, 110],
                roseType : 'radius',
                data:jsonData.data
            }
        ]
    };

    pie4.setOption(option,true);

    option.series[0].name="面积模式";
    option.series[0].radius=[30,110];
    option.series[0].roseType="area";

    pie5.setOption(option,true);
}


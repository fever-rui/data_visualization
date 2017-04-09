<%@ page import="java.util.List" %>
<%@ page import="com.csu.data_visualization.model.data_record" %>
<%@ page import="com.csu.data_visualization.model.Page" %>
<%--
  Created by IntelliJ IDEA.
  User: fever
  Date: 2017/3/18
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/app.css">
    <script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js"></script>

</head>

<body data-type="widgets">
<script src="<%=request.getContextPath()%>/js/theme.js"></script>
<div class="am-g tpl-g">
    <div>
        <%@ include file="header.jsp" %>
    </div>

    <div class="left-sidebar">

        <!-- 菜单 -->
        <ul class="sidebar-nav">
            <li class="sidebar-nav-link">
                <a href="<%=request.getContextPath()%>/home" class="active">
                    <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                </a>
            </li>

            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title">
                    <i class="am-icon-bar-chart sidebar-nav-link-logo"></i> 图表
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub">
                    <li class="sidebar-nav-link">
                        <a href="chart_line">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 折线图
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="chart_columnar " >
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 柱状图
                        </a>
                    </li>
                    <li class="sidebar-nav-link">
                        <a href="chart_pie" >
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 扇形图
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="chart_scatterPlot">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 散点图
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="chart_radar">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 雷达图
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="chart_map">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 地图
                        </a>
                    </li>
                </ul>
            </li>

        </ul>

    </div>


    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">
                                <span style="vertical-align: middle;font-size: 17px">记录</span>

                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-3" style="float: right">
                                    <form action="<%=request.getContextPath()%>/search" method="get">
                                        <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                            <input type="text" class="am-form-field " name="key" id="key" placeholder="请输入文件名" value=<%=request.getAttribute("key")%>>
                                            <span class="am-input-group-btn">
                                            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
                                                    type="submit"></button>
                                        </span>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>


                        <div class="widget-body  am-fr">
                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table  tpl-table-black "
                                       id="example-r">
                                    <thead>
                                        <tr>
                                            <th width="30%">文件</th>
                                            <th width="30%">图表类型</th>
                                            <th width="30%">上传时间</th>
                                            <th width="10%">详情</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        if(request.getAttribute("recordList").equals("-")) {
                                    %>
                                    <%--记录为空--%>
                                    <tr >
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                    </tr>
                                    <%
                                    }else {
                                        List<data_record> recordList=(List<data_record>)request.getAttribute("recordList");
                                        for(int i=0;i<recordList.size();i++){
                                            data_record record=recordList.get(i);
                                    %>
                                    <tr id="tr<%=i%>" >
                                        <td ><%=record.getData_name()%></td>
                                        <td ><%=record.getChart_type()%></td>
                                        <td ><%=record.getCreate_time().substring(0,19)%></td>
                                        <td >
                                            <div class="am-icon-angle-down" id="down<%=i%>" style="display: block;margin-left: 10px;cursor: pointer" onclick="showInfo(this)">
                                            </div>
                                            <div class="am-icon-angle-up" id="up<%=i%>" style="display: none;margin-left: 10px;cursor: pointer" onclick="hiddenInfo(this)">
                                            </div>
                                        </td>
                                    </tr>

                                    <tr id="record<%=i%>"  style="display: none;">
                                        <td colspan="4">
                                            <div style="min-height: 100px">
                                                <%=record.getData_info()%>
                                            </div>
                                        </td>
                                    </tr>

                                    <%
                                            }//for
                                        }//else
                                    %>


                                    <!-- more data -->
                                    </tbody>
                                </table>
                            </div>

                            <div class="am-u-lg-12 am-cf">
                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination"></ul>
                                </div>
                            </div>

                        </div>

                </div>
            </div>
        </div>
    </div>
</div>

    <div>
        <%@ include file="go_top.jsp" %>
    </div>

</div>
<script src="<%=request.getContextPath()%>/js/amazeui.min.js"></script>
<script src="<%=request.getContextPath()%>/js/amazeui.datatables.min.js"></script>
<script src="<%=request.getContextPath()%>/js/dataTables.responsive.min.js"></script>
<script src="<%=request.getContextPath()%>/js/app.js"></script>
<script src="<%=request.getContextPath()%>/js/home_page.js"></script>
<%--<script src="<%=request.getContextPath()%>/js/amazeui.page.js"></script>--%>
<script src="<%=request.getContextPath()%>/js/amazeui-pagination.js"></script>
<script>
    <% Page pageClass=(Page)request.getAttribute("page"); %>
    var index=0;
//    var inputElement=document.getElementById("key");
//    var key=inputElement.value;
    
    function modifyTable(list) {
        for(var i=0;i<10;i++){
            if(i<list.length){
                var tr1=document.getElementById("tr"+i);
                tr1.firstElementChild.innerHTML=list[i].data_name;
                tr1.firstElementChild.nextElementSibling.innerHTML=list[i].chart_type;
                tr1.firstElementChild.nextElementSibling.nextElementSibling.innerHTML=list[i].create_time.substring(0,19);
                tr1.style.display="table-row";
                tr1.lastElementChild.firstElementChild.style.display="block";
                tr1.lastElementChild.lastElementChild.style.display="none";

                var tr2=document.getElementById("record"+i);
                tr2.style.display="none";
                tr2.firstElementChild.firstElementChild.innerHTML=list[i].data_info;
            }else {
                var tr1=document.getElementById("tr"+i);
                tr1.style.display="none";
                var tr2=document.getElementById("record"+i);
                tr2.style.display="none";
            }


        }
    }

    var pagination = new Pagination({

        wrap: $('.am-pagination'),
        current:<%=pageClass.getCurrentPage()%>,
        count: <%=pageClass.getTotalPage()%>,
        prevText: '上一页',
        nextText: '下一页',
        callback: function(page) {
            console.log(page);
            index=page;
            $.ajax({
                url		: "/page",
                data 	: {
                    index : index,
                    key   : document.getElementById("key").value
                },
                dataType : "json",
                success : function (data){
                    console.log("test")
//                    var jsonData=JSON.parse(data);
                    var list=data.recordList;
                    modifyTable(list);
                },
                error : function(){
//                    $.AMUI.progress.done();
                    console.log("error");
                },
            });
        }
    });
</script>
</body>
</html>


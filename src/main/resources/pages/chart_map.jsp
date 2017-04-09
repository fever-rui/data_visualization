<%--
  Created by IntelliJ IDEA.
  User: fever
  Date: 2017/3/18
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>地图</title>
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
                <a href="<%=request.getContextPath()%>/home" >
                    <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                </a>
            </li>

            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title active">
                    <i class="am-icon-bar-chart sidebar-nav-link-logo"></i> 图表
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub" style="display: block;">
                    <li class="sidebar-nav-link" >
                        <a href="chart_line" >
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 折线图
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="chart_columnar " >
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 柱状图
                        </a>
                    </li>
                    <li class="sidebar-nav-link" >
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
                        <a href="chart_map" class="sub-active">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 地图
                        </a>
                    </li>
                </ul>
            </li>

        </ul>

    </div>


    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">

        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span>地图</div>
                    <p class="page-header-description">图表组件使用的是 <a href="http://echarts.baidu.com">百度图表echarts</a></p>
                </div>

                <form  class="am-u-sm-12 am-u-md-3" id="fileForm" id="fileForm"  method="post" enctype="multipart/form-data">
                    <div class="am-form-group am-form-file">
                        <button type="button" class="am-btn am-btn-danger am-btn-sm">
                            <i class="am-icon-cloud-upload"></i> 添加文件</button>
                        <input id="doc-form-file" type="file" name="file">
                    </div>
                    <div id="file-list">
                    </div>
                    <button class="am-btn am-btn-default am-btn-sm" id="fileSubmit" type="button">提交</button>
                    <!-- 显示excel上传结果返回显示 -->
                    <div id="excel-return">

                    </div>
                </form>

                <form  method="post" action="/record/columnar_fileDownLoad">
                    <button class="am-btn am-btn-primary   am-btn-sm" style="margin-left: 10px" type="submit" >
                        下载数据模板
                        <i class="am-icon-cloud-download"></i>
                    </button>
                </form>

                <div style="margin-left: 10px">
                    <p class="page-header-description">注:txt文件应保存成UTF-8。</p>
                </div>


            </div>

        </div>

        <div class="row-content am-cf">
            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div class="widget-title am-fl">地图</div>
                    <div class="widget-function am-fr">
                        <a href="javascript:;"></a>
                    </div>
                </div>
                <div class="widget-body am-fr">
                    <div  id="map1" style="width: 100%;height: 400px;"></div>
                </div>
            </div>

        </div>
    </div>

    <%@ include file="load_alert.jsp" %>

</div>

<%@ include file="go_top.jsp" %>




<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/amazeui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/app.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/charts/echarts.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/charts/map/china.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/charts/mapChart.js" ></script>
<script>

</script>
</body>

</html>


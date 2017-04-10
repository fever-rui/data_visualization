<%--
  Created by IntelliJ IDEA.
  User: fever
  Date: 2017/4/10
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>扇形图</title>
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
                <a href="<%=request.getContextPath()%>/description" class="active" >
                    <i class="am-icon-book sidebar-nav-link-logo"></i> 说明文档
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

        <div class="container-fluid am-cf">
            <div class="row">


            </div>

        </div>

        <div class="row-content am-cf">


        </div>
    </div>

    <%@ include file="load_alert.jsp" %>

</div>

<%@ include file="go_top.jsp" %>




<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/amazeui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/app.js" ></script>

</body>

</html>
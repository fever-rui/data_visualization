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
    <title>折线图</title>
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/app.css">
    <script src="<%=request.getContextPath()%>/assets/js/jquery-3.1.1.js"></script>

</head>

<body data-type="widgets">
<script src="<%=request.getContextPath()%>assets/js/theme.js"></script>
<div class="am-g tpl-g">

    <div>
        <%@ include file="header.jsp" %>
    </div>

    <!-- 侧边导航栏 -->
    <div class="left-sidebar">
        <ul class="sidebar-nav">
            <li class="sidebar-nav-link">
                <a href="index.html">
                    <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title active">
                    <i class="am-icon-bar-chart sidebar-nav-link-logo"></i> 图表
                </a>
                <ul class="sidebar-nav sidebar-nav-sub" style="display: block;">
                    <li class="sidebar-nav-link">
                        <a href="chart_line" class="sub-active">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 折线图
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="chart_columnar.">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 柱状图
                        </a>
                    </li>
                    <li class="sidebar-nav-link">
                        <a href="chart_pie">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 饼状图
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>


    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">

        <div class="row-content am-cf">
            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div class="widget-title am-fl">折线图堆叠</div>
                    <div class="widget-function am-fr">
                        <a href="javascript:;"></a>
                    </div>
                </div>
                <div class="widget-body am-fr">
                    <div  id="Stack" style="width: 100%;height: 400px;"></div>
                </div>
            </div>

            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div class="widget-title am-fl">堆叠区域图</div>
                    <div class="widget-function am-fr">
                        <a href="javascript:;"></a>
                    </div>
                </div>
                <div class="widget-body am-fr">
                    <div  id="area" style="width: 100%;height: 400px;"></div>
                </div>
            </div>

            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div class="widget-title am-fl">Step Line</div>
                    <div class="widget-function am-fr">
                        <a href="javascript:;"></a>
                    </div>
                </div>
                <div class="widget-body am-fr">
                    <div  id="step" style="width: 100%;height: 400px;"></div>
                </div>
            </div>

            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div class="widget-title am-fl">大数据面积图</div>
                    <div class="widget-function am-fr">
                        <a href="javascript:;"></a>
                    </div>
                </div>
                <div class="widget-body am-fr">
                    <div  id="shuju" style="width: 100%;height: 400px;"></div>
                </div>
            </div>

            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div class="widget-title am-fl">动态数据+时间坐标轴</div>
                    <div class="widget-function am-fr">
                        <a href="javascript:;"></a>
                    </div>
                </div>
                <div class="widget-body am-fr">
                    <div  id="trends" style="width: 100%;height: 400px;"></div>
                </div>
            </div>
        </div>
    </div>


</div>
</div>

<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/app.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/charts/echarts.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/charts/lineChart.js" ></script>
</body>

</html>


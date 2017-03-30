<%--
  Created by IntelliJ IDEA.
  User: fever
  Date: 2017/3/30
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导航栏--%>
<!-- 侧边导航栏 -->
<div class="left-sidebar">
    <ul class="sidebar-nav">
        <li class="sidebar-nav-link">
            <a href="<%=request.getContextPath()%>/home">
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
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 扇形图
                    </a>
                </li>
            </ul>
        </li>
    </ul>
</div>
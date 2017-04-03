<%@ page import="java.util.List" %>
<%@ page import="com.csu.data_visualization.model.data_record" %><%--
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

    <div>
        <%@ include file="sidebar_nav.jsp" %>
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
                                    <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                        <input type="text" class="am-form-field ">
                                        <span class="am-input-group-btn">
                                            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
                                                    type="button"></button>
                                        </span>
                                    </div>
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
                                    <tr id="tr<%=i%>">
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

                                    <tr id="record<%=i%>" style="display: none;">
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



                            <%--<div class="am-u-lg-12 am-cf">--%>

                                <%--<div class="am-fr">--%>
                                    <%--<ul class="am-pagination tpl-pagination">--%>
                                        <%--<li class="am-disabled"><a href="#">«</a></li>--%>
                                        <%--<li class="am-active"><a href="#">1</a></li>--%>
                                        <%--<li><a href="#">2</a></li>--%>
                                        <%--<li><a href="#">3</a></li>--%>
                                        <%--<li><a href="#">4</a></li>--%>
                                        <%--<li><a href="#">5</a></li>--%>
                                        <%--<li><a href="#">»</a></li>--%>
                                    <%--</ul>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <div class="am-u-lg-12 am-cf">
                                <div class="am-fr">
                                    <div id="page">
                                        <ul class="am-pagination tpl-pagination">
                                            <li><a href="javascript:" data-page="7">&lt;</a></li>
                                            <li><a href="javascript:" data-page="1">首页</a></li>
                                            <span>...</span>
                                            <li><a href="javascript:" data-page="4">4</a></li>
                                            <li><a href="javascript:" data-page="5">5</a></li>
                                            <li><a href="javascript:" data-page="6">6</a></li>
                                            <li><a href="javascript:" data-page="7">7</a></li>
                                            <li class="am-active"><a href="javascript:" data-page="8">8</a></li>
                                            <li><a href="javascript:" data-page="8">最后一页</a></li>
                                        </ul>
                                <%--</div>--%>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="<%=request.getContextPath()%>/js/amazeui.min.js"></script>
<script src="<%=request.getContextPath()%>/js/amazeui.datatables.min.js"></script>
<script src="<%=request.getContextPath()%>/js/dataTables.responsive.min.js"></script>
<script src="<%=request.getContextPath()%>/js/app.js"></script>
<script src="<%=request.getContextPath()%>/js/home_page.js"></script>
<script src="<%=request.getContextPath()%>/js/amazeui.page.js"></script>
</body>
</html>


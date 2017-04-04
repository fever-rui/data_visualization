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
    <title>柱状图</title>
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

        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span>柱状图</div>
                    <p class="page-header-description">图表组件使用的是 <a href="http://echarts.baidu.com">百度图表echarts</a></p>
                </div>
                <%--<form  class="am-u-sm-12 am-u-md-3" id="fileForm" action="<%=request.getContextPath()%>/record/columnar_fileLoad" method="post" enctype="multipart/form-data">--%>
                    <%--<div class="am-form-group am-form-file">--%>
                        <%--<button type="button" class="am-btn am-btn-danger am-btn-sm">--%>
                            <%--<i class="am-icon-cloud-upload"></i> 添加文件</button>--%>
                        <%--<input id="doc-form-file" type="file" name="file">--%>
                    <%--</div>--%>
                    <%--<div id="file-list"></div>--%>
                    <%--<button class="am-btn am-btn-default am-btn-sm" type="submit">提交</button>--%>
                    <%--<!-- 显示excel上传结果返回显示 -->--%>
                    <%--<div id="excel-return">--%>

                    <%--</div>--%>
                <%--</form>--%>



                <form  class="am-u-sm-12 am-u-md-3" id="fileForm" id="fileForm"  method="post" enctype="multipart/form-data">
                    <div class="am-form-group am-form-file">
                        <button type="button" class="am-btn am-btn-danger am-btn-sm">
                            <i class="am-icon-cloud-upload"></i> 添加文件</button>
                        <input id="doc-form-file" type="file" name="file">
                    </div>
                    <div id="file-list"></div>
                    <button class="am-btn am-btn-default am-btn-sm" id="fileSubmit" type="button">提交</button>
                    <!-- 显示excel上传结果返回显示 -->
                    <div id="excel-return">

                    </div>
                </form>


            </div>

        </div>

        <div class="row-content am-cf">
            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div class="widget-title am-fl">柱状图</div>
                    <div class="widget-function am-fr">
                        <a href="javascript:;"></a>
                    </div>
                </div>
                <div class="widget-body am-fr">
                    <div  id="columnar1" style="width: 100%;height: 400px;"></div>
                </div>
            </div>

            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div class="widget-title am-fl">堆叠条形图</div>
                    <div class="widget-function am-fr">
                        <a href="javascript:;"></a>
                    </div>
                </div>
                <div class="widget-body am-fr">
                    <div  id="columnar2" style="width: 100%;height: 400px;"></div>
                </div>
            </div>

            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div class="widget-title am-fl">正负条形图</div>
                    <div class="widget-function am-fr">
                        <a href="javascript:;"></a>
                    </div>
                </div>
                <div class="widget-body am-fr">
                    <div  id="columnar3" style="width: 100%;height: 400px;"></div>
                </div>
            </div>

            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div class="widget-title am-fl">折柱混合图</div>
                    <div class="widget-function am-fr">
                        <a href="javascript:;"></a>
                    </div>
                </div>
                <div class="widget-body am-fr">
                    <div  id="columnar4" style="width: 100%;height: 400px;"></div>
                </div>
            </div>
        </div>
    </div>


</div>

<%@ include file="go_top.jsp" %>


</div>

<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/amazeui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/app.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/charts/echarts.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/charts/columnarChart.js" ></script>
<script>
    // 显示文件名
    $(function() {
        $('#doc-form-file').on('change', function() {
            var fileNames = '';
            $.each(this.files, function() {
                fileNames += '<span class="am-badge">' + this.name + '</span> ';
            });
            $('#file-list').html(fileNames);
        });
    });

    var $formSubmit = $("#fileForm button[type=submit]"); //导入文件的submit

    //未导入文件时return
    $formSubmit.on("click",function(check){
        if($("#doc-form-file").val() == "") {
            check.preventDefault();//此处阻止提交表单
            alert("请先选择文件");
        }
    });
    
    $('#fileSubmit').click(function () {
        if($("#doc-form-file").val() == "") {
            check.preventDefault();//此处阻止提交表单
            alert("请先选择文件");
        }else {
            $('#file-list').html('');
            var form = new FormData(document.getElementById("fileForm"));
            $.ajax({
                url:"${pageContext.request.contextPath}/record/columnar_fileLoad",
                type:"post",
                data:form,
                processData:false,
                contentType:false,
                success:function(data){
                    console.log("over..");
                },
                error:function(e){
                    alert("错误！！");
                }
            });
        }

    })
</script>
</body>

</html>


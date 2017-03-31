<%--
  Created by IntelliJ IDEA.
  User: fever
  Date: 2017/3/16
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="keywords" content="login">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/app.css">
    <script src="<%=request.getContextPath()%>/js/jquery-3.1.1.js"></script>

</head>

<body data-type="login">
<script src="<%=request.getContextPath()%>/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 风格切换 -->
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
        <div class="tpl-skiner-content">
            <div class="tpl-skiner-content-title">
                选择主题
            </div>
            <div class="tpl-skiner-content-bar">
                <span class="skiner-color skiner-white" data-color="theme-white"></span>
                <span class="skiner-color skiner-black" data-color="theme-black"></span>
            </div>
        </div>
    </div>
    <div class="tpl-login">
        <div class="tpl-login-content">
            <form class="am-form tpl-form-line-form" action="login">
                <fieldset>
                    <div class="am-g">
                        <div class="am-form-group">
                            <input type="text" class="am-radius" id="account" name="account" placeholder="Account" required="required"/>
                        </div>

                        <div class="am-form-group form-horizontal m-t-20">
                            <input type="password" class="am-radius" id="password" name="password" placeholder="Password" required="required"/>
                        </div>

                        <div class="am-form-group ">
                            <button type="button" class="am-btn am-btn-primary am-radius" id="loginButton"
                                    style="width: 100%;height: 100%;">Login
                            </button>
                        </div>

                        <div class="am-form-group ">
                            <a href="registerView" class="text-muted" id="register"><i class="fa fa-lock m-r-5"></i> 没有账号？请先注册</a>
                        </div>



                    </div>
                </fieldset>
            </form>
        </div>


        <div class="am-modal am-modal-alert" tabindex="-1" id="alertAccount">
            <div class="am-modal-dialog">
                <div class="am-modal-hd">请输入账号</div>
                <div class="am-modal-footer">
                    <span class="am-modal-btn">确定</span>
                </div>
            </div>
        </div>

        <div class="am-modal am-modal-alert" tabindex="-1" id="alertPassword">
            <div class="am-modal-dialog">
                <div class="am-modal-hd">请输入密码</div>
                <div class="am-modal-footer">
                    <span class="am-modal-btn">确定</span>
                </div>
            </div>
        </div>

        <div class="am-modal am-modal-alert" tabindex="-1" id="alertFalse">
            <div class="am-modal-dialog">
                <div class="am-modal-hd">账户或密码错误</div>
                <div class="am-modal-footer">
                    <span class="am-modal-btn">确定</span>
                </div>
            </div>
        </div>

    </div>
</div>

<script src="<%=request.getContextPath()%>/js/amazeui.min.js"></script>
<script src="<%=request.getContextPath()%>/js/app.js"></script>
<script src="<%=request.getContextPath()%>/js/login.js"></script>

</body>
</html>


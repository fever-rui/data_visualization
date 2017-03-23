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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/app.css">
    <script src="<%=request.getContextPath()%>/assets/js/jquery-3.1.1.js"></script>

</head>

<body data-type="login">
<script src="<%=request.getContextPath()%>/assets/js/theme.js"></script>
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
    </div>
</div>

<script src="<%=request.getContextPath()%>/assets/js/amazeui.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/app.js"></script>

<script>
    var $inputAccount = $("form input[name = account]");
    var $inputPass = $("form input[name = password]");

    var inputAccountVal,inputPassVal;

    $('#loginButton').click(function () {
        inputAccountVal = $inputAccount.val().trim();
        inputPassVal = $inputPass.val().trim();

        // 如果账户名或者密码没有输入则阻止提交
        if(inputAccountVal===""){
            alert("请输入账号")
            $inputAccount.focus();
            return false;
        }
        if(inputPassVal===""){
            alert("请输入密码")
            $inputPass.focus();
            return false;
        }

        $.ajax({
            type 	: 'POST',
            url		: "login.html",
            data 	: {
                account : $inputAccount.val(),
                password : $inputPass.val()
            },
            dataType : "json",
            success : function (data){
                if(data.result === "true"){
                    window.location.href = "home";
                } else {
                    alert("账号或密码错误")
                }
            },
            error : function(){
                console.log("error");
            },
        });
    })
</script>

</body>
</html>


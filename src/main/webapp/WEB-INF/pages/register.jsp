<%--
  Created by IntelliJ IDEA.
  User: fever
  Date: 2017/3/16
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/core.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/menu.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/amazeui.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/component.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/page/form.css"/>
</head>
<body>
<div class="account-pages">
    <div class="wrapper-page">

        <div class="m-t-40 card-box">
            <div class="text-center">
                <h4 class="text-uppercase font-bold m-b-0">Register</h4>
            </div>
            <div class="panel-body">
                <form class="am-form" action="/register" data-am-validator>
                    <fieldset>
                        <div class="am-g">
                            <div class="am-form-group">
                                <input type="text" class="am-radius" id="account" name="account"
                                       placeholder="Account" required="required"/>
                            </div>

                            <div class="am-form-group ">
                                <input type="text" class="am-radius" id="name" name="name" placeholder="Name"
                                       required="required"/>
                            </div>

                            <div class="am-form-group form-horizontal m-t-20">
                                <input type="password" class="am-radius" id="password" name="password"
                                       placeholder="Password" required="required"/>
                            </div>

                            <div class="am-form-group ">
                                <button type="button" class="am-btn am-btn-primary am-radius" id="registerButton"
                                        style="width: 100%;height: 100%;">Register
                                </button>
                            </div>

                            <div class="am-form-group ">
                                <a href="/" class="text-muted"><i class="fa fa-lock m-r-5"></i>
                                    已经拥有账号？登录</a>
                            </div>
                        </div>
                    </fieldset>
                </form>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/blockUI.js"></script>

<script>
    var $inputAccount = $("form input[name = account]");
    var $inputPass = $("form input[name = password]");
    var $inputName = $("form input[name = name]");

    var inputAccountVal,inputPassVal,inputNameVal;

    $('#registerButton').click(function () {
        inputAccountVal = $inputAccount.val().trim();
        inputPassVal = $inputPass.val().trim();
        inputNameVal = $inputName.val().trim();

        // 如果账号、昵称或者密码没有输入则阻止提交
        if (inputAccountVal === "") {
            alert("请输入账号")
            $inputAccount.focus();
            return false;
        }
        if (inputNameVal === "") {
            alert("请输入用户名")
            $inputName.focus();
            return false;
        }
        if (inputPassVal === "") {
            alert("请输入密码")
            $inputPass.focus();
            return false;
        }

        $.ajax({
            type: 'POST',
            url: "register.html",
            data: {
                account: $inputAccount.val(),
                name: $inputName.val(),
                password: $inputPass.val()
            },
            dataType: "json",
            success: function (data) {
                if (data.result === "true") {
                    window.location.href = "index";
                } else if(data.result === "exist") {
                    alert("账号已经注册")
                } else {
                    alert("输入信息有误");
                }
            },
            error: function () {
                console.log("error");
            },
        });
    })
</script>

</body>
</html>



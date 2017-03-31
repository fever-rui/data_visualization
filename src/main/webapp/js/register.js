/**
 * Created by fever on 2017/3/31.
 */
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
        $('#alertAccount').modal();
        $inputAccount.focus();
        return false;
    }
    if (inputNameVal === "") {
        $('#alertName').modal();
        $inputName.focus();
        return false;
    }
    if (inputPassVal === "") {
        $('#alertPassword').modal();
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
                window.location.href = "home";
            } else if(data.result === "exist") {
                $('#alertExist').modal();
            } else {
                $('#alertFalse').modal();
            }
        },
        error: function () {
            console.log("error");
        },
    });
})
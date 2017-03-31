/**
 * Created by fever on 2017/3/31.
 */
var $inputAccount = $("form input[name = account]");
var $inputPass = $("form input[name = password]");

var inputAccountVal,inputPassVal;


$('#loginButton').click(function () {
    inputAccountVal = $inputAccount.val().trim();
    inputPassVal = $inputPass.val().trim();

    // 如果账户名或者密码没有输入则阻止提交
    if(inputAccountVal===""){
        $('#alertAccount').modal();
        $inputAccount.focus();
        return false;
    }
    if(inputPassVal===""){
        $('#alertPassword').modal();
        $inputPass.focus();
        return false;
    }

    $.ajax({
        type 	: 'POST',
        url		: "login",
        data 	: {
            account : $inputAccount.val(),
            password : $inputPass.val()
        },
        dataType : "json",
        success : function (data){
            if(data.result === "true"){
                window.location.href = "home";
            } else {
                $('#alertFalse').modal();
            }
        },
        error : function(){
            console.log("error");
        },
    });
})
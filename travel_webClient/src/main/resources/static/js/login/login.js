$(function (){

    var Location = location.href;
    var url = Location.substring(0,Location.indexOf("web") + 4);
    refreshCaptcha();
    $("#btn_regist").click(function (){
        location.href = "/regist";
    })

    $("#btn_submit").click(function (){
        let inputPass = $("#password").val();
        let salt = '1a2b3c4d';
        let str = salt.charAt(2) + salt.charAt(0) + inputPass + salt.charAt(5) + salt.charAt(6);
        let password = md5(str);
        let data = {
            "username":$("#username").val(),
            // "password": password
            "password":$("#password").val(),
            "captcha":$("#checkCode").val()
        }

        //发送ajax请求，提交表单数据
        $.ajax({
            url: "/login",
            type: "POST",
            data: JSON.stringify(data),
            contentType : "application/json;charsetset=UTF-8",
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    window.location.href="/dashboard";
                }else {
                    $("#errorMsg").html(data.message);
                }
            }
        })
    })
})

function refreshCaptcha(){
    $("#captcha").attr("src", "/captcha");
}
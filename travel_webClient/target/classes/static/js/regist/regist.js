/*
  表单校验
        1.用户名：单词字符，长度8到20位
        2.密码：单词字符，长度8到20位
        3.email：邮箱格式
        4.姓名：非空
        5.手机号：手机号格式
        6.出生日期：
        7.验证码：非空
*/

//校验用户名
function checkUserName() {
    var username = $("#username").val();
    //定义正则表达式，判断输入是否符合要求
    var reg_username = /^\w{8,20}$/;

    var flag = reg_username.test(username);

    if (flag) {
        $("#username").parent().removeClass("has-error");
    } else {
        $("#username").parent().addClass("has-error");
    }

    return flag;
}

//校验密码
function  checkPassword(){
    var password = $("#password").val();

    var reg_password = /^\w{8,20}$/ ;

    var flag = reg_password.test(password);

    if(flag){
        $("#password").parent().removeClass("has-error");
    }else {
        $("#password").parent().addClass("has-error");
    }

    return flag;

}

//校验名称
function  checkName(){
    var name = $("#name").val();

    var reg_name = /^[\u4e00-\u9fa5]{2,4}$/ ;

    var flag = reg_name.test(name);

    if(flag){
        $("#name").parent().removeClass("has-error");
    }else {
        $("#name").parent().addClass("has-error");
    }

    return flag;

}

//校验手机号
function  checkTelePhone(){
    var telephone = $("#telephone").val();

    var reg_telephone = /^[1-9][0-9]{10}$/ ;

    var flag = reg_telephone.test(telephone);

    if(flag){
        $("#telephone").parent().removeClass("has-error");
    }else {
        $("#telephone").parent().addClass("has-error");
    }

    return flag;

}

//校验验证码
// function  checkCode(){
//     var checkcode = $("#checkcode").val();
//
//     var reg_checkcode = /^\s*$/ ;
//
//     var flag = reg_checkcode.test(checkcode);
//
//     if(!flag){
//         $("#checkcode").parent().removeClass("has-error");
//     }else {
//         $("#checkcode").parent().addClass("has-error");
//     }
//
//     return !flag;
// }

$(function (){
        $("#regist").click(function () {
            let inputPass = $("#password").val();
            let salt = '1a2b3c4d';
            let str = salt.charAt(2) + salt.charAt(0) + inputPass + salt.charAt(5) + salt.charAt(6);
            let password = md5(str);
            let data = {
                "username":$("#username").val(),
                "password":password,
                "name":$("#name").val(),
                "birth":$("#birthday").val(),
                "sex":$("#sex").val(),
                "telephone":$("#telephone").val(),
                "email":$("#email").val()
            };
            //表单提交时，调用校验方法
            //1.通过ajax请求，异步提交表单数据
            //if(checkUserName() && checkPassword() && checkTelePhone() && checkName()) {
                $.ajax({
                    url: "/user/regist",
                    method: "POST",
                    data: JSON.stringify(data),
                    contentType: "application/json;charset=UTF-8",
                    success: function (data) {
                        console.log("成功");
                        if (data.code == 200) {
                            console.log("成功");
                            //注册成功，跳转
                            //location.href="register_ok.html"; //跳转页面操作！
                            layer.confirm("注册成功！是否登录？", {btn: ["确定", "取消"]}, function () {
                                window.location.href = "/";
                            }, function () {
                                layer.close();
                            });
                        } else {
                            //注册失败，提示页面信息
                            $("#errorMsg").html(data.message);
                        }
                    }
                })
            //}
        })

        // $("#username").blur(checkUserName);
        // $("#password").blur(checkPassword);
        // $("#name").blur(checkName);
        // $("#telephone").blur(checkTelePhone);
        //$("#checkcode").blur(checkCode);
        //
        // var pathName = window.location.pathname;
        // var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        // $("#vcode").attr("src",projectName+"/checkCodeServlet")
        //
        // var Location = location.href;
        // var path = Location.substring(0,Location.indexOf("web") + 4);
        // $("#login").click(function (){
        //     location.href = path + "login.html" ;
        // })

    }
)
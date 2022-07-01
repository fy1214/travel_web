$(function () {
    $.get("/user/findOne",{},function (data){
        var msg = "欢迎回来，" + data.obj.name;
        $("#span_header").html(msg);
        $("#a_header").html("退出");
        $("#user").addClass("hidden");
    })

    $("#a_header").click(function (){
        $.get("/user/exit",{},function (){
            location.href = "/";
        })
    })

    $("#search-btn").click(function (){
        var rname = $("#search-input").val();
        if(rname == null) return;
        //跳转路径 http://localhost:8080/travel/route_list.html?cid=5&rname=xxx
        var cid = getParameter("cid");
        if (cid != null) {
            location.href="/route_list?cid="+cid+"&rname=" + rname;
        }else {
            location.href="/route_list?rname=" + rname;
        }
    })
})
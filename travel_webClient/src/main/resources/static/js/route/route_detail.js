$(function () {

    //1.获取rid
    var length = 0;
    var rid = getParameter("rid");
    //2.发送请求 route/findOne
    $.get("/route/findOne", {rid: rid}, function (data) {
        let route = data.obj.route;
        let seller = data.obj.seller;
        //3.解析数据填充html
        $("#rname").html(route.rname);
        $("#routeIntroduce").html(route.routeIntroduce);
        $("#price").html("&nbsp;￥" + route.rprice);
        $("#sname").html(seller.sname);
        $("#consphone").html(seller.phone);
        $("#address").html(seller.address);
        $("#favoriteCount").html(route.count);

        if(data.obj.favourite != null){
            //用户已经收藏
            $("#favorite").addClass("btn-danger");
            $("#favorite").prop("disabled","disabled");
            $("#favoriteSpan").html("已收藏");
            $("#btn_2").removeAttr("disabled");
        }else {
            //用户未收藏
            $("#favorite").addClass("btn-default");
            $("#favorite").removeAttr("disabled");
            $("#favoriteSpan").html("点击收藏");
            $("btn_2").prop("disabled","disabled");
        }

        length = data.obj.routeImgList.length;

        //图片展示
        var ddstr = '<li><a id="imgChange1" href="javascript:void(0);"><img id="imgtop" src="../../img/轮播图/top.png" class="img-responsive" style="margin: 4px"></a></li>';
        var s = '<img id="bigImg" src="' + data.obj.routeImgList[0].bigPic + '" class="img-responsive" style="margin-left:10px;margin-top: 20px;margin-bottom:20px;">';
        //遍历routeImgList
        for (var i = 0; i < length; i++) {
            var astr = '<li><a id="imgChange2" href="javascript:void(0);"><img id="img' + i + '" src="' + data.obj.routeImgList[i].smallPic + '" class="img-responsive" style="margin: 4px"></a></li>';
            ddstr += astr;
        }

        ddstr += '<li><a id="imgChange5" href="javascript:void(0);"><img id="imgbtm" src="../../img/轮播图/bottom.png" class="img-responsive" style="margin: 4px"></a></li>';
        $("#addDiv").html(s);
        $("#addUl").html(ddstr);

        //给每个图片绑定单击切换大图事件
        $("#bigImg").wait(function () {
            for(var i = 0; i < length; i++) {
                $("#img" + i).bind("click", {index: i}, clickHandler);
            }

            function clickHandler(event) {
                $("#bigImg").attr("src", "../../img/大图/大图" + (event.data.index +1) + ".jpg");
            }
        })
    })



})

function addFavorite(){
    var rid = getParameter("rid");
    //1.判断用户是否登录
    $.get("user/findOne",{rid: rid},function (data){
        if(data.code == 200){
            //用户登录了,添加功能
            $.get("route/addFavorite",{rid: rid},function (data){
                location.reload();
            })
        }else{
            layer.confirm("您尚未登录，请登录", {btn:["确定", "取消"]}, function (){
                window.location.href= "/";
            }, function (){
                window.location.href= "/";
            });
        }
    })
}

function removeFavorite(){
    var rid = getParameter("rid");
    //1.判断用户是否登录
    $.get("user/findOne",{rid: rid},function (data){
        if(data.code == 200){
            //用户登录了,删除功能
            $.get("route/removeFavorite",{rid: rid},function (data){
                location.reload();
            })
        }else{
            layer.confirm("您尚未登录，请登录", {btn:["确定", "取消"]}, function (){
                window.location.href= "/";
            }, function (){
                window.location.href= "/";
            });
        }
    })
}

$(function () {
    /*var search = location.search;
    //切割字符串，拿到第二个值
    var cid = search.split("=")[1];*/

    //获取cid参数值
    var cid = getParameter("cid");
    //获取搜索值
    var rname = getParameter("rname"); //搜索栏中的搜索关键字参数
    //如果rname不为null或空字符串
    if(rname != null && rname !=""){
        //url解码
        rname = window.decodeURIComponent(rname);
    }

    load(cid,1,rname);

    if(cid == 1) {
        $("#topbar1").addClass("active");
    }else if(cid == 2) {
        $("#topbar2").addClass("active");
    }else if(cid == 3) {
        $("#topbar3").addClass("active");
    }else if(cid == 4) {
        $("#topbar4").addClass("active");
    }else if(cid == 5) {
        $("#topbar5").addClass("active");
    }else if(cid == 6) {
        $("#topbar6").addClass("active");
    }else if(cid == 7) {
        $("#topbar7").addClass("active");
    }else if(cid == 8) {
        $("#topbar8").addClass("active");
    }

})

function load(cid, currentPage, rname) {
    //发送ajax请求，请求route/pageQuery，传递cid
    $.get("/route/pageQuery", {cid: cid, currentPage: currentPage, rname: rname}, function (data) {
        let pb = data.obj;
        //解析PageBean数据，展示到页面上

        //分页工具条数据显示
        //1.1展示总页码和总记录数
        $("#totalPage").html(pb.totalPage);
        $("#totalCount").html(pb.totalCount);
        $("#search-input").val(rname);
        var lis = '';

        if (pb.currentPage <= 1) {
            lis = '<li class="disabled"><a aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>';
        } else {
            lis = '<li><a href="javascript:load('+cid+','+(pb.currentPage - 1)+',\''+rname+'\')" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>';
        }

        //2.展示分页页码(原先做法：显示全部页面）
        for(var i = 1;i <= pb.totalPage;i++){
            //创建页码的li
            if(pb.currentPage == i){
                //<li class="active"><a href="javascript:load(cid,i,@{rname})">@{i}</a></li>
                var li = '<li class="active"><a href="javascript:load('+cid+',' + i + ',\''+rname+'\')">'+i+'</a></li>'
            }else {
                var li = '<li><a href="javascript:load('+cid+','+i+','+rname+')">' + i + '</a></li>'
            }
            //拼接字符串
            lis += li
        }

        /**
         * 需求
         * 一共展示十个页码，能够达到前五页后四页效果
         * 如果前面不足五个，后边补齐至总共十个页码
         * 如果后面不足五个，前面补齐至总共十个页码
         */

        //     //定义开始位置begin，结束位置end
        // var begin;
        // var end;
        //
        // //1.要显示10页
        // if (pb.totalPage < 10) {
        //     //总页码不够十页
        //     begin = 1;
        //     end = pb.totalPage;
        // } else {
        //     //总页码超过十页
        //     begin = pb.currentPage - 5;
        //     end = pb.currentPage + 4;
        //
        //     //2.如果前面不够五个，后边补齐10个
        //     if (begin < 1) {
        //         begin = 1;
        //         end = begin + 9;
        //     }
        //
        //     //3.后面不足4个，前面补齐10个
        //     if (end > pb.totalPage) {
        //         end = pb.totalPage;
        //         begin = end - 9;
        //     }
        // }
        //
        // for (var i = begin; i <= end; i++) {
        //     //创建页码的li
        //     if (pb.currentPage == i) {
        //         var li = '<li class="active"><a href="javascript:load(' + cid + ',' + i + ',\''+rname+'\')">' + i + '</a></li>'
        //     } else {
        //         var li = '<li><a href="javascript:load(' + cid + ',' + i + ',\''+rname+'\')">' + i + '</a></li>'
        //     }
        //
        //     //拼接字符串
        //     lis += li
        // }
        //
        if (pb.currentPage < pb.totalPage) {
            lis += '<li><a href="javascript:load('+cid+','+(pb.currentPage + 1)+',\''+rname+'\')" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
        } else {
            lis += '<li class="disabled"><a aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
        }

        //将lis内容设置到ul中
        $("#pageNum").html(lis);

        //列表数据展示
        var route_lis = '<tr><td style="width: 600px;text-align: center;height:40px;background-color: gainsboro;font-weight: bolder">商品信息</td><td style="text-align: center;height:40px;background-color: gainsboro;font-weight: bolder">价格</td></tr>';
        /** <tr>
         <td style="width: 600px;">
         <div className="row">
         <div className="col-md-5"><img src="img/route/旅游图1.jpg" className="img-responsive"></div>
         <div className="col-md-7">
         <div className="div_style1">【减100元 含除夕/春节出发】广州增城三英温泉度假酒店/自由行套票</div>
         <div className="div_style2">1-2月出发，网付立享￥1099/2人起！爆款位置有限，抢完即止！</div>
         </div>
         </div>
         </td> */

        for (var i = 0; i < pb.records.length; i++) {
            var route = pb.records[i];

            var li = '<tr><td style="width: 600px;"><div class="row"><div class="col-md-5"><img src="' + route.rimage + '" class="img-responsive"></div><div class="col-md-7"><div class="div_style1">' + route.rname + '</div><div class="div_style2">' + route.routeIntroduce + '</div></div></div></td>';

            route_lis += li;

            var lip = '<td style="text-align: center;border-left-style: solid;border-left-color: #F8F8FF;"> <p> <br/> <span class="span_style1">￥</span> <span class="span_style1">' + route.rprice + '</span> <span style="color: red;">起</span> </p> <p><a href="http://localhost:84/route_detail?rid='+route.rid+'">查看详情</a></p></td>';

            route_lis += lip;
        }
        $("#route").html(route_lis);
    })

    //定位到页面的顶部
    window.scroll(0, 0);
}
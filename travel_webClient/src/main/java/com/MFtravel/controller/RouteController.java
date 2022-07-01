package com.MFtravel.controller;

import com.MFtravel.service.RouteService;
import com.MFtravel.utils.CookieUtils;
import com.MFtravel.vo.RespBean;
import com.MFtravel.vo.RespBeanEnum;
import com.MFtravel.vo.route.RouteDetail;
import com.MFtravel.vo.route.RouteVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class RouteController {

    @Resource
    private RouteService routeService;

    @GetMapping("/route/pageQuery")
    public RespBean pageQuery(@RequestParam("currentPage") Integer page,
                              @RequestParam(value = "cid", required = false) Integer cid,
                              @RequestParam(value = "rname", required = false) String rname) {
        int rows = 5;
        System.out.println(cid +":" + rname);
        RouteVo routeVo = routeService.pageQuery(page, rows, cid, rname);
        if (routeVo != null) {
            return RespBean.success(routeVo);
        }else {
            return RespBean.error(RespBeanEnum.QUERYALL_FAIL);
        }
    }

    //---------------------route_detail---------------------//
    @GetMapping("/route/findOne")
    public RespBean findRouteDetail(@RequestParam("rid") Long rid, HttpServletRequest request) {
        String ticket = CookieUtils.getCookieValue(request, "userTicket");
        RouteDetail routeDetail = routeService.queryDetail(rid, ticket);
        return RespBean.success(routeDetail);
    }

    @GetMapping("/route/addFavorite")
    public RespBean addFavorite(@RequestParam("rid") Long rid, HttpServletRequest request) {
        String ticket = CookieUtils.getCookieValue(request, "userTicket");
        if (routeService.addFavourite(rid, ticket)) {
            return RespBean.success();
        }else {
            return RespBean.error(RespBeanEnum.ADDFAOURITE_FAIL);
        }
    }

    @GetMapping("/route/removeFavorite")
    public RespBean removeFavorite(@RequestParam("rid") Long rid, HttpServletRequest request) {
        String ticket = CookieUtils.getCookieValue(request, "userTicket");
        if (routeService.removeFavorite(rid, ticket)) {
            return RespBean.success();
        }else {
            return RespBean.error(RespBeanEnum.REMOVE_FAIL);
        }
    }

}

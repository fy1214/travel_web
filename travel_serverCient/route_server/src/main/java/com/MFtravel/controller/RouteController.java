package com.MFtravel.controller;

import com.MFtravel.pojo.RouteDetail;
import com.MFtravel.service.RouteService;
import com.MFtravel.vo.RouteVo;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/route/pageQuery")
    @SentinelResource(value = "route_query")
    public RouteVo pageQuery(@RequestParam("currentPage") Integer page,
                             @RequestParam("rows") Integer rows,
                             @RequestParam(value = "cid", required = false) Integer cid,
                             @RequestParam(value = "rname", required = false) String rname){
        return routeService.queryPage(page, rows, cid, rname);
    }

    @GetMapping("/route/queryDetail")
    @SentinelResource(value = "route_detail")
    public RouteDetail queryDetail(@RequestParam("id") Long id,
                                   @RequestParam(value = "ticket") String ticket){
        return routeService.queryDetail(id, ticket);
    }

    @GetMapping("/route/addFavorite")
    @SentinelResource(value = "route_addFavourite")
    public boolean addFavourite(@RequestParam("id") Long rid, @RequestParam("ticket") String ticket) {
        return routeService.addFavourite(rid, ticket);
    }

    @GetMapping("/route/removeFavorite")
    @SentinelResource(value = "route_removeFavorite")
    public boolean removeFavorite(@RequestParam("id") Long rid, @RequestParam("ticket") String ticket) {
        return routeService.removeFavorite(rid, ticket);
    }
}

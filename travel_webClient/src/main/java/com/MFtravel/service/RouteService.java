package com.MFtravel.service;

import com.MFtravel.vo.route.RouteDetail;
import com.MFtravel.vo.route.RouteVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "travel-server-client-route", fallback = RouteServiceFallbackService.class)
public interface RouteService {
    @GetMapping("/route/pageQuery")
    RouteVo pageQuery(@RequestParam("currentPage") Integer page,
                      @RequestParam("rows") Integer rows,
                      @RequestParam(value = "cid", required = false) Integer cid,
                      @RequestParam(value = "rname", required = false) String rname);

    @GetMapping("/route/queryDetail")
    RouteDetail queryDetail(@RequestParam("id") Long id, @RequestParam("ticket") String ticket);

    @GetMapping("/route/addFavorite")
    boolean addFavourite(@RequestParam("id") Long rid, @RequestParam("ticket") String ticket);

    @GetMapping("/route/removeFavorite")
    boolean removeFavorite(@RequestParam("id") Long rid, @RequestParam("ticket") String ticket);
}

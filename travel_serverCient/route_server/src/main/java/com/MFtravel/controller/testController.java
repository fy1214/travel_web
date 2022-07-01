package com.MFtravel.controller;

import com.MFtravel.pojo.RouteDetail;
import com.MFtravel.service.RouteService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/test")
    @SentinelResource(value = "test" )
    public String test(){
        return "成功";
    }
}

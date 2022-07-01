package com.MFtravel.controller;

import com.MFtravel.pojo.User;
import com.MFtravel.service.RouteService;
import com.MFtravel.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class testController {

    @Resource
    private RouteService routeService;

    @Resource
    private UserService userService;

    @GetMapping("/test/login")
    public String Login() {
        User user = new User();
        user.setUsername("root");
        user.setPassword("1234");
        user.setName("root");
        return null;
    };
}

package com.MFtravel.controller;

import com.MFtravel.pojo.User;
import com.MFtravel.service.UserService;
import com.MFtravel.utils.MD5Utils;
import com.MFtravel.vo.LoginVo;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/regist")
    @SentinelResource(value = "user_regist")
    public boolean regist(@RequestBody User user) {
        return userService.regist(user);
    }

    @PostMapping("/user/login")
    @SentinelResource(value = "user_login")
    public String Login(@RequestBody LoginVo loginVo) {
        User user = new User();
        user.setUsername(loginVo.getUsername());
        user.setPassword(MD5Utils.inputPassToDBPass(loginVo.getPassword(), "1a2b3c4d"));
        return userService.Login(user);
    }

    @GetMapping("/user/findOne")
    @SentinelResource(value = "user_findOne")
    public User findUser(String ticket) {
        User user = userService.findUser(ticket);
        return user;
    }

    @GetMapping("/user/exit")
    @SentinelResource(value = "user_exitUser")
    public Integer exitUser(String ticket) {
        return userService.exitUser(ticket);
    }


    @GetMapping("/test")
    public String test() {
        System.out.println("进入了");
        User user = new User();
        user.setUsername("root");
        user.setPassword("1234");
        return "来自数据库："+ userService.Login(user);
    }

}

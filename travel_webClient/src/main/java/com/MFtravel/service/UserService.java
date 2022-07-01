package com.MFtravel.service;

import com.MFtravel.pojo.User;
import com.MFtravel.vo.login.LoginVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(value = "travel-server-client-user", fallback = UserServiceFallbackService.class)
public interface UserService {
    @PostMapping("/user/regist")
    boolean regist(@RequestBody User user);

    @PostMapping("/user/login")
    String Login(@RequestBody LoginVo loginVo);

    @GetMapping("/user/findOne")
    User findUser(@RequestParam("ticket") String ticket);

    @GetMapping("/user/exit")
    Integer exitUser(@RequestParam("ticket") String ticket);
}

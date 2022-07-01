package com.MFtravel.controller;

import com.ramostear.captcha.HappyCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@RestController
public class CaptchaController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 生成校验码
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/captcha")
    public String verifyCode(HttpServletRequest request, HttpServletResponse response){
        // 设置请求头为输出图片类型
        HappyCaptcha.require(request, response).build().finish();
        String captcha = (String) request.getSession().getAttribute("happy-captcha");
        request.getSession().removeAttribute("happy-captcha");
        return captcha;
    }
}

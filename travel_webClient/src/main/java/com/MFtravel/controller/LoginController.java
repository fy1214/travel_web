package com.MFtravel.controller;

import com.MFtravel.pojo.User;
import com.MFtravel.service.UserService;
import com.MFtravel.utils.CookieUtils;
import com.MFtravel.vo.RespBean;
import com.MFtravel.vo.RespBeanEnum;
import com.MFtravel.vo.login.LoginVo;
import com.ramostear.captcha.HappyCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class LoginController {

    @Resource
    private UserService userService;

    /**
     * 生成校验码
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/captcha")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response){
        // 设置请求头为输出图片类型
        HappyCaptcha.require(request, response).build().finish();
    }

    @PostMapping("/user/regist")
    public RespBean regist(@RequestBody User user) {
        if (userService.regist(user)) {
            return RespBean.success();
        }else {
            return RespBean.error(RespBeanEnum.REGIST_ERROR);
        }
    }

    @PostMapping("/login")
    public RespBean Login(@RequestBody LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getSession().getAttribute("happy-captcha") + "-----" + loginVo.getCaptcha());
        if (!StringUtils.equals((String) request.getSession().getAttribute("happy-captcha"), loginVo.getCaptcha())){
            return RespBean.error(RespBeanEnum.CAPTCHA_ERROR);
        }
        String ticket = userService.Login(loginVo);
        System.out.println(ticket);
        if (ticket != null) {
            Cookie cookie = new Cookie("userTicket", ticket);
            cookie.setMaxAge(60 * 60);
            cookie.setDomain("localhost");//作用域
            /*
              cookie.setPath();  踩坑，https://blog.csdn.net/weixin_41547486/article/details/81294238
              Cookie的SetPath设置cookie的路径，这个路径直接决定服务器的请求是否会从浏览器中加载某些cookie。
              首先默认情况如果不设置cookie的path，默认是 /项目名称/当前路径的上一层地址如：请求路径：/cookie_demo/servlet/login， cookie的路径：/cookie_demo/servlet
              如果我们设置path，如果当前访问的路径包含了cookie的路径（当前访问路径在cookie路径基础上要比cookie的范围小）cookie就会加载到request对象之中。
            */
            response.addCookie(cookie);
            return RespBean.success();
        }else {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
    }

    @GetMapping("/user/findOne")
    public RespBean findUser(HttpServletRequest request, HttpServletResponse response) {
        String ticket = CookieUtils.getCookieValue(request, "userTicket");
        User user = userService.findUser(ticket);
        if (user != null) {
            return RespBean.success(user);
        }else return RespBean.error(RespBeanEnum.NOTLOGIN_ERROR);
    }

    @GetMapping("/user/exit")
    public RespBean exitUser(HttpServletRequest request) {
        String ticket = CookieUtils.getCookieValue(request, "userTicket");
        if (userService.exitUser(ticket) == 1) {
            return RespBean.success();
        }else return RespBean.error(RespBeanEnum.NOTLOGIN_ERROR);
    }
}

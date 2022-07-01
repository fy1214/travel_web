package com.MFtravel.service;

import com.MFtravel.pojo.User;
import com.MFtravel.vo.login.LoginVo;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserServiceFallbackService implements UserService{
    @Override
    public boolean regist(User user) {
        return false;
    }

    @Override
    public String Login(LoginVo loginVo) {
        return null;
    }

    @Override
    public User findUser(String ticket) {
        return null;
    }

    @Override
    public Integer exitUser(String ticket) {
        return -1;
    }
}

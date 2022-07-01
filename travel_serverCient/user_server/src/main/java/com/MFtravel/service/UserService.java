package com.MFtravel.service;

import com.MFtravel.pojo.User;

public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean regist(User user);

    /**
     * 根据用户用户名和密码登录
     * @param user
     * @return
     */
    String Login(User user);

    /**
     * 根据ticket获得用户
     * @param ticket
     * @return
     */
    User findUser(String ticket);

    /**
     * 根据用户ticket退出用户登录
     * @param ticket
     * @return
     */
    Integer exitUser(String ticket);
}

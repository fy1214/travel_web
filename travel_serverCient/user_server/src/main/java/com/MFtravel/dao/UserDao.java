package com.MFtravel.dao;

import com.MFtravel.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    /**
     * 根据用户用户名和密码登录
     * @param user
     * @return
     */
    Integer regist(User user);

    /**
     * 根据用户用户名和密码登录
     * @param user
     * @return
     */
    User login(User user);
}

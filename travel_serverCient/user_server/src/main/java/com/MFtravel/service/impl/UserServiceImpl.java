package com.MFtravel.service.impl;

import com.MFtravel.dao.UserDao;
import com.MFtravel.pojo.User;
import com.MFtravel.service.UserService;
import com.MFtravel.utils.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public boolean regist(User user) {
        Integer res = 0;
        try {
            res = userDao.regist(user);
        }catch (Exception e){
            res = -1;
        }
        return res == 1;
    }

    @Override
    public String Login(User user) {
        String ticket = UUIDutils.uuid();
        User loginUser = userDao.login(user);
        if (loginUser != null) {
            redisTemplate.opsForValue().set("user:" + ticket, loginUser, 60, TimeUnit.MINUTES);
            return ticket;
        }else {
            return null;
        }
    }

    @Override
    public User findUser(String ticket) {
        User user = (User) redisTemplate.opsForValue().get("user:" + ticket);
        return user;
    }

    @Override
    public Integer exitUser(String ticket) {
        if (redisTemplate.delete("user:" + ticket)) {
            return 1;
        }else {
            return -1;
        }
    }
}

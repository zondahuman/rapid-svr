package com.abin.lee.rapid.service.impl;

import com.abin.lee.rapid.mapper.UserMapper;
import com.abin.lee.rapid.model.User;
import com.abin.lee.rapid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-6-27
 * Time: 下午9:58
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(int id){
        User user = userMapper.findUserInfo(id);
        return user;
    }

    public User[] getAllUser(){
        return userMapper.getAllUser();
    }

}

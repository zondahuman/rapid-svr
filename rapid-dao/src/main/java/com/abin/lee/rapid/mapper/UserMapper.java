package com.abin.lee.rapid.mapper;

import com.abin.lee.rapid.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-6-27
 * Time: 下午9:37
 * To change this template use File | Settings | File Templates.
 */
public interface UserMapper {

    public User findUserInfo(int id);

    public User[] getAllUser();

}

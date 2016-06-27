package com.abin.lee.rapid.service;

import com.abin.lee.rapid.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-6-27
 * Time: 下午9:57
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    public User getUserInfo(int id);

    public User[] getAllUser();



}

package com.abin.lee.rapid.boot.controller;

import com.abin.lee.rapid.model.User;
import com.abin.lee.rapid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-6-27
 * Time: 下午1:45
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class HttpServiceController {

    @RequestMapping("/print")
    public String print(){
        return "hello, world!";
    }


    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/userinfo")
    public User getUserInfo(@RequestParam(name = "id")int id){
        User user = userService.getUserInfo(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("/alluser")
    public User[] getAllUser(){
        return userService.getAllUser();
    }

//    public static void main(String[] args) {
//        SpringApplication.run(HttpServiceController.class, args);
//    }


}

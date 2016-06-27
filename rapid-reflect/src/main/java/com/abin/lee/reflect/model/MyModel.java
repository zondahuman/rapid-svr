package com.abin.lee.reflect.model;

import com.abin.lee.reflect.annotation.MyAnnotation;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-6-27
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
@MyAnnotation(name = "init", defaultValue = true)
public class MyModel {
    private String id;
    private String name;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

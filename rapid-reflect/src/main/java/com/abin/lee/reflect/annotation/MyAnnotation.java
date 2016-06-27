package com.abin.lee.reflect.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-6-27
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    public String name() default "fieldName";
    public boolean defaultValue() default false;


}

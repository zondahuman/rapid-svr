package com.abin.lee.rapid.base;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-6-27
 * Time: 下午10:03
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@MapperScan("com.abin.lee.rapid.mapper")
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.abin.lee.rapid.mapper");
        return mapperScannerConfigurer;
    }

}
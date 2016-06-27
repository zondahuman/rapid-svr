package com.abin.lee.reflect;

import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
* Json序列化工具
* @author abin
* @date
*/
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper = new ObjectMapper();
        //序列化时候统一日期格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //设置null时候不序列化(只针对对象属性)
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //反序列化时，属性不存在的兼容处理
        objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //单引号处理
        objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    /**
     * 将对象序列化为JSON字符串
     *
     * @param object
     * @return JSON字符串
     */
    public static String toJson(Object object) {
        if (object == null)
            return null;
        Writer write = new StringWriter();
        try {
            objectMapper.writeValue(write, object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return write.toString();
    }

    /**
     * 将JSON字符串反序列化为对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T decodeJson(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json) || null == clazz)
            return null;
        Object object = null;
        try {
            object = objectMapper.readValue(json, TypeFactory.rawClass(clazz));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) object;
    }

    /**
     * 将JSON字符串反序列化为对象
     * @param json
     * @param typeRef
     * @param <T>
     * @return
     */
    public static <T> T decodeJson(String json, TypeReference<T> typeRef) {
        if (StringUtils.isBlank(json) || null == typeRef)
            return null;
        try {
            return (T) objectMapper.readValue(json, typeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
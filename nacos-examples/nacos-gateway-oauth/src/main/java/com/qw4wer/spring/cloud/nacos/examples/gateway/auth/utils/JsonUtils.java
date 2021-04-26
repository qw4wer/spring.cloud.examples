package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.logging.log4j.util.Strings;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * 基于Jackson的JSON转换工具类
 *
 * @author ye17186
 * @version 2018/6/29 12:06
 */
@CommonsLog
public class JsonUtils {

    public static ObjectMapper mapper = new ObjectMapper();

    static {

        // 对象的所有字段全部列入，还是其他的选项，可以忽略null等
        mapper.setSerializationInclusion(Include.NON_NULL);
        // 设置Date类型的序列化及反序列化格式
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


        //关闭默认包含的视图
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

        // 忽略空Bean转json的错误
        // mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // 忽略未知属性，防止json字符串中存在，java对象中不存在对应属性的情况出现错误
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 注册一个时间序列化及反序列化的处理模块，用于解决jdk8中localDateTime等的序列化问题
        mapper.registerModule(new JavaTimeModule());
    }

    /**
     * 对象 => json字符串
     *
     * @param obj 源对象
     */
    public static <T> String toJson(T obj) {

        String json = null;
        if (obj != null) {
            try {
                json = mapper.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                log.warn(e.getMessage(), e);
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return json;
    }

    /**
     * json字符串 => 对象
     *
     * @param json  源json串
     * @param clazz 对象类
     * @param <T>   泛型
     */
    public static <T> T parse(String json, Class<T> clazz) {
        if (Strings.isBlank(json)) {
            return null;
        }
        try {
            T obj = mapper.readValue(json, clazz);
            return obj;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       return null;
    }

    /**
     * json字符串 => 对象
     *
     * @param json 源json串
     * @param type 对象类型
     * @param <T>  泛型
     */
    public static <T> T parse(String json, TypeReference<T> type) {
        if (Strings.isBlank(json)) {
            return null;
        }

        try {
            T obj = mapper.readValue(json, type);
            return obj;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parse(InputStream inputStream, TypeReference<T> type) {

        try {
            T obj = mapper.readValue(inputStream, type);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parse(InputStream inputStream, Class<T> clazz) {

        try {
            T obj = mapper.readValue(inputStream, clazz);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

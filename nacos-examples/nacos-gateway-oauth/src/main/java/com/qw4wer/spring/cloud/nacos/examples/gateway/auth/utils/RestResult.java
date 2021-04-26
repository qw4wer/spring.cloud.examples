package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.utils;

import com.qw4wer.spring.cloud.nacos.examples.gateway.auth.enums.ServerCodeEnum;
import lombok.Data;

/**
 * @author 48945
 */
@Data
public class RestResult<T> {

    private int code = 200;
    private String message = "成功";
    private boolean success = true;
    private T data;

    public static RestResult success() {
        return new RestResult();
    }

    public static RestResult success(String message) {
        RestResult restResult = new RestResult();
        restResult.setMessage(message);
        return restResult;
    }

    public static <T> RestResult success(T data) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setData(data);
        return restResult;
    }

    public static <T> RestResult success(String message, T data) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setMessage(message);
        restResult.setData(data);
        return restResult;
    }

    public static RestResult error(String message) {
        RestResult restResult = new RestResult();
        restResult.setCode(400);
        restResult.setSuccess(false);
        restResult.setMessage(message);
        return restResult;
    }

    public static RestResult error(int code,String message) {
        RestResult restResult = new RestResult();
        restResult.setCode(400);
        restResult.setSuccess(false);
        restResult.setMessage(message);
        restResult.setCode(code);
        return restResult;
    }
    public static RestResult error(ServerCodeEnum serverCodeEnum) {
        RestResult restResult = new RestResult();
        restResult.setSuccess(false);
        restResult.setCode(serverCodeEnum.getCode());
        restResult.setMessage(serverCodeEnum.getMemo());
        return restResult;
    }

}

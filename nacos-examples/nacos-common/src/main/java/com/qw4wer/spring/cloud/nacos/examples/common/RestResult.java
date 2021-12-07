package com.qw4wer.spring.cloud.nacos.examples.common;

import lombok.Data;

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

    public static RestResult error(int code, String message) {
        RestResult restResult = new RestResult();
        restResult.setCode(400);
        restResult.setSuccess(false);
        restResult.setMessage(message);
        restResult.setCode(code);
        return restResult;
    }

}

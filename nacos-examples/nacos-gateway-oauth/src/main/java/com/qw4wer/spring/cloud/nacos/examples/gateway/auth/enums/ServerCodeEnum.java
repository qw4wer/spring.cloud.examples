package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServerCodeEnum {
    NOT_LOGIN(40001, "没有登录"),
    LOGIN_ERROR(40002, "登录失败"),
    NOT_AUTHORITY(40003, "没有权限"),
    ;
    private Integer code;

    private String memo;

}

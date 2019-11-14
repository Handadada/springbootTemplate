package com.example.bootDemo.enums;

import lombok.Getter;


@Getter
public enum ErrorEnum {

    SUCCESS(200, "访问成功"),

    FAIL(300, "访问失败"),

    UNKNOWN_ERROR(301, "未知错误"),

    SYSTEM_ERROR(600, "系统错误，请刷新页面重试");


    ErrorEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private Integer code;

    private String desc;
}

package com.example.bootDemo.enums;

import lombok.Getter;


@Getter
public enum ErrorEnum {

    SUCCESS(200, "访问成功"),

    FAIL(300, "访问失败"),

    UNKNOWN_ERROR(301, "未知错误"),

    DATA_ERROR(302, "参数不能为空"),

    ID_NOT_EXIT(303, "该项内容不存在,请刷新页面"),

    TYPE_HAVE_DATA_YET(304, "该设置有字典详情设置,请确认后删除"),

    SYSTEM_ERROR(600, "系统错误，请刷新页面重试");


    ErrorEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private Integer code;

    private String desc;
}

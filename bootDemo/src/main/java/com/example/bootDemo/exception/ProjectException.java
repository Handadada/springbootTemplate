package com.example.bootDemo.exception;

import com.example.bootDemo.enums.ErrorEnum;
import lombok.Getter;

/*
 * @Description
 *
 * @Author hanchong@mail.haoyisheng.com
 * @Date 16:47 2019/11/15
 */
@Getter
public class ProjectException extends RuntimeException {

    private ErrorEnum errorEnum;

    public ProjectException(ErrorEnum errorEnum) {
        super(errorEnum.getDesc());
        this.errorEnum = errorEnum;
    }

    public ProjectException(ErrorEnum errorEnum, String addMsg) {
        super(errorEnum.getDesc() + "{" + addMsg + "}");
        this.errorEnum = errorEnum;
    }
}

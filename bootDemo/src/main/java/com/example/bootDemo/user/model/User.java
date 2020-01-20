package com.example.bootDemo.user.model;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-20 14:10
 */
@Data
public class User {

    private String id;

    private String realName;

    private String account;

    private String pwd;

    private String secondPwd;

    private Integer roleId;

    private String phoneNumber;

    private String picture;

    private Date createTime;

    private Date updateTime;

    private Integer status;

}
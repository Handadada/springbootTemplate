package com.example.bootDemo.tableBook.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:
 * 账本对象
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-19 16:39
 */
@Data
public class ExpenseCalendar {

    private Integer id;
    //消费类型
    private Integer typeId;
    //金额
    private BigDecimal money;

    private Date createDate;

    private String createUser;
    //备注
    private String mark;
}
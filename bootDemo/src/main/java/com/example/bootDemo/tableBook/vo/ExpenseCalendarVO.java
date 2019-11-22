package com.example.bootDemo.tableBook.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-19 16:44
 */
@Data
public class ExpenseCalendarVO {

    private Integer id;
    //消费类型
    private String typeName;
    //金额
    private BigDecimal money;

    private Date createDate;

    private String createUser;
    //备注
    private String mark;
}
package com.example.bootDemo.prepare.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-14 17:07
 */
@Data
public class Good {

    private Integer id;

    private String name;

    private BigDecimal price;

    private Integer num;

    private String isBuy;

    private String mark;

    private Integer status;
}
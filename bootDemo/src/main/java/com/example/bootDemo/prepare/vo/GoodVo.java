package com.example.bootDemo.prepare.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-14 17:12
 */
@Data
public class GoodVo {

    private Integer id;

    private String name;

    private BigDecimal price;

    private Integer num;

    private String isBuy;

    private String mark;

}
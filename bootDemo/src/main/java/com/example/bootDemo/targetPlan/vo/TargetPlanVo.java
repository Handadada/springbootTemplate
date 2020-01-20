package com.example.bootDemo.targetPlan.vo;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-17 14:23
 */
@Data
public class TargetPlanVo {

    private Integer id;

    private String name;

    private String planTime;

    private String createTime;

    private String location;

    private Double money;

    private String status;


}
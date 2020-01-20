package com.example.bootDemo.targetPlan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-17 14:14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TargetPlan {

    private Integer id;

    private String name;

    private Date planTime;

    private Date createTime;

    private String location;

    private Double money;

    private Integer status;
}
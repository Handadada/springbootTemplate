package com.example.bootDemo.tableBook.vo;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-19 16:53
 */
@Data
public class ExpenseSearchVO {

    //前端传过来的搜索日期
    private Date searchDate;

    private Date endDate;

    private Integer typeId;

    private String createUser;

    /**
     * 分页数据
     */
    private Integer pageNo;

    private Integer startRow;

    private Integer pageSize;
}
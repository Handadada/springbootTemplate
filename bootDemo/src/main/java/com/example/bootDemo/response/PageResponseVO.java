package com.example.bootDemo.response;

import lombok.Data;

import java.util.List;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-15 15:42
 */
@Data
public class PageResponseVO<T> {

    private List<T> list;

    /**
     * 数据总条数
     */
    private int count;
    /**
     * 数据总页数
     */
    private int pages;
    /**
     * 数据起始页
     */
    private int pageNo;
    /**
     * 每页数据量
     */
    private int pageSize;
}
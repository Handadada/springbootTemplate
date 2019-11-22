package com.example.bootDemo.tableBook.mapper;

import com.example.bootDemo.tableBook.vo.ExpenseCalendarVO;
import com.example.bootDemo.tableBook.vo.ExpenseSearchVO;

import java.util.List;

public interface ExpenseCalendarMapper {

    //查询账单个数
    int count(ExpenseSearchVO searchVO);
    //查询账单list
    List<ExpenseCalendarVO> list(ExpenseSearchVO searchVO);
}

package com.example.bootDemo.tableBook.mapper;

import com.example.bootDemo.tableBook.model.ExpenseCalendar;
import com.example.bootDemo.tableBook.vo.ExpenseCalendarVO;
import com.example.bootDemo.tableBook.vo.ExpenseSearchVO;

import java.util.List;

public interface ExpenseCalendarMapper {

    //查询账单个数
    int count(ExpenseSearchVO searchVO);
    //查询账单list
    List<ExpenseCalendarVO> list(ExpenseSearchVO searchVO);
    //添加一个账单
    void insert(ExpenseCalendar expenseCalendar);
    //删除一个账单
    void delete(Integer expenseCalendarId);
    //修改一个账单
    void update(ExpenseCalendar expenseCalendar);
}

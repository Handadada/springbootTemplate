package com.example.bootDemo.tableBook.controller;

import com.example.bootDemo.exception.ProjectException;
import com.example.bootDemo.response.PageResponseVO;
import com.example.bootDemo.response.ResponseVO;
import com.example.bootDemo.tableBook.service.ExpenseCalendarService;
import com.example.bootDemo.tableBook.vo.ExpenseCalendarVO;
import com.example.bootDemo.tableBook.vo.ExpenseSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-19 16:49
 */
@RestController
@RequestMapping("/expenseCalendar")
public class ExpenseCalendarController {

    @Autowired
    private ExpenseCalendarService calendarService;

    //主列表查询
    @RequestMapping("/list")
    public ResponseVO list(ExpenseSearchVO searchVO) {

        try {
            PageResponseVO<ExpenseCalendarVO> responseVO = calendarService.list(searchVO);
            return ResponseVO.success(responseVO);
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }

    }




}
package com.example.bootDemo.tableBook.service;

import com.example.bootDemo.common.Const;
import com.example.bootDemo.enums.ErrorEnum;
import com.example.bootDemo.exception.ProjectException;
import com.example.bootDemo.response.PageResponseVO;
import com.example.bootDemo.tableBook.mapper.ExpenseCalendarMapper;
import com.example.bootDemo.tableBook.model.ExpenseCalendar;
import com.example.bootDemo.tableBook.vo.ExpenseCalendarVO;
import com.example.bootDemo.tableBook.vo.ExpenseSearchVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-19 16:50
 */
@Service
public class ExpenseCalendarService {

    @Autowired
    private ExpenseCalendarMapper calendarMapper;

    public PageResponseVO<ExpenseCalendarVO> list(ExpenseSearchVO searchVO) {
        this.checkParams(searchVO);
        PageResponseVO<ExpenseCalendarVO> response = new PageResponseVO<>();
        int count = calendarMapper.count(searchVO);
        int pages = 0;
        if (count > 0) {
            pages = count % 15 == 0 ? count / 15 : count / 15 + 1;
        }
        List<ExpenseCalendarVO> list = calendarMapper.list(searchVO);
        response.setPageNo(searchVO.getPageNo());
        response.setPageSize(searchVO.getPageSize());
        response.setCount(count);
        response.setPages(pages);
        response.setList(list);
        return response;
    }



    //验证查询参数
    private void checkParams(ExpenseSearchVO searchVO) {
        String user = Const.CURRENT_USER;
        if (StringUtils.isBlank(user)) {
            throw new ProjectException(ErrorEnum.SYSTEM_ERROR);
        }
        searchVO.setCreateUser(user);
        //设置截止日期
        if (null != searchVO.getSearchDate()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(searchVO.getSearchDate());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            searchVO.setEndDate(calendar.getTime());
        }
        //校正分页数据
        if (searchVO.getPageNo() < 1) {
            searchVO.setPageNo(1);
        }
        if (searchVO.getPageSize() < 1) {
            searchVO.setPageSize(15);
        }
        searchVO.setStartRow((searchVO.getPageNo() - 1) * searchVO.getPageSize());
    }

    public void insert(ExpenseCalendar expenseCalendar) {

        boolean flag = this.checkExpenseCalendar(expenseCalendar);
        if (!flag) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        expenseCalendar.setCreateUser(Const.CURRENT_USER);
        calendarMapper.insert(expenseCalendar);
    }

    private boolean checkExpenseCalendar(ExpenseCalendar expenseCalendar) {
        boolean flag = true;
        if (expenseCalendar.getMoney() == null) {
            flag = false;
        }
        if (expenseCalendar.getCreateDate() == null) {
            flag = false;
        }
        if (expenseCalendar.getTypeId() == null) {
            flag = false;
        }
        return flag;
    }

    public void delete(Integer expenseCalendarId) {
        if (null == expenseCalendarId) {
            throw new ProjectException(ErrorEnum.ID_NOT_EXIT);
        }
        calendarMapper.delete(expenseCalendarId);
    }

    public void update(ExpenseCalendar expenseCalendar) {
        if (null == expenseCalendar || expenseCalendar.getId() == null) {
            throw new ProjectException(ErrorEnum.ID_NOT_EXIT);
        }
        calendarMapper.update(expenseCalendar);
    }
}
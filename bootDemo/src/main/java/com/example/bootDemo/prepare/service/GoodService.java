package com.example.bootDemo.prepare.service;

import com.example.bootDemo.enums.ErrorEnum;
import com.example.bootDemo.exception.ProjectException;
import com.example.bootDemo.prepare.mapper.GoodMapper;
import com.example.bootDemo.prepare.model.Good;
import com.example.bootDemo.prepare.vo.GoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-14 17:20
 */
@Service
public class GoodService {


    @Autowired
    private GoodMapper goodMapper;

    public List<GoodVo> getGoods(Good good) {
        String name = "";
        if (null != good && !good.getName().equals("")) {
            name = good.getName();
        }
        return goodMapper.getGoods(name);
    }

    public void addGood() {
        goodMapper.addGood();
    }

    public void deleteGood(Good good) {
        if (null == good || good.getId() == null) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        goodMapper.deleteGood(good.getId());
    }

    public void saveGood(Good good) {
        if (null == good || good.getId() == null) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        goodMapper.saveGood(good);
    }
}
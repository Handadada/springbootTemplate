package com.example.bootDemo.prepare.mapper;

import com.example.bootDemo.prepare.model.Good;
import com.example.bootDemo.prepare.vo.GoodVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodMapper {

    List<GoodVo> getGoods(@Param("name") String name);

    void addGood();

    void deleteGood(@Param("id") Integer id);

    void saveGood(@Param("good") Good good);
}

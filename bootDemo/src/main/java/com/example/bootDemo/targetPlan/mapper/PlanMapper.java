package com.example.bootDemo.targetPlan.mapper;

import com.example.bootDemo.targetPlan.model.TargetPlan;
import com.example.bootDemo.targetPlan.vo.TargetPlanVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanMapper {

    List<TargetPlanVo> getPlans(@Param("name") String name);

    void addPlan();

    void deletePlan(@Param("id") Integer id);

    void savePlan(@Param("plan") TargetPlan plan);

    TargetPlan getPlanById(@Param("id") Integer id);
}

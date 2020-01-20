package com.example.bootDemo.targetPlan.service;

import com.example.bootDemo.enums.ErrorEnum;
import com.example.bootDemo.exception.ProjectException;
import com.example.bootDemo.targetPlan.mapper.PlanMapper;
import com.example.bootDemo.targetPlan.model.TargetPlan;
import com.example.bootDemo.targetPlan.vo.TargetPlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-17 14:09
 */
@Service
public class PlanService {

    @Autowired
    private PlanMapper planMapper;


    public List<TargetPlanVo> getPlans(TargetPlan targetPlan) {
        String name = "";
        if (null != targetPlan && !targetPlan.getName().equals("")) {
            name = targetPlan.getName();
        }
        return planMapper.getPlans(name);
    }

    public void addPlan() {
        planMapper.addPlan();
    }

    public void deletePlan(TargetPlan targetPlan) {
        if (null == targetPlan || targetPlan.getId() == null) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        planMapper.deletePlan(targetPlan.getId());

    }

    public void savePlan(TargetPlan plan) {
        if (null == plan) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        planMapper.savePlan(plan);
    }

    public TargetPlan getPlanById(TargetPlan targetPlan) {
        if (null == targetPlan || targetPlan.getId() == null) {
            throw new ProjectException(ErrorEnum.DATA_ERROR);
        }
        return planMapper.getPlanById(targetPlan.getId());
    }
}
package com.example.bootDemo.targetPlan.controller;

import com.example.bootDemo.exception.ProjectException;
import com.example.bootDemo.response.ResponseVO;
import com.example.bootDemo.targetPlan.model.TargetPlan;
import com.example.bootDemo.targetPlan.service.PlanService;
import com.example.bootDemo.targetPlan.vo.TargetPlanVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-17 14:05
 */
@RestController
@Api(value = "计划清单")
@RequestMapping(value = "/target")
public class PlanController {

    @Autowired
    private PlanService planService;

    @RequestMapping(value = "/getPlans", method = RequestMethod.POST)
    @ApiOperation("获取计划列表")
    public ResponseVO getPlans(@RequestBody TargetPlan targetPlan) {

        try {
            List<TargetPlanVo> list = planService.getPlans(targetPlan);
            return ResponseVO.success(list);
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }

    }

    @RequestMapping(value = "/getPlanById", method = RequestMethod.POST)
    @ApiOperation("根据主键id获取对应数据类型的计划")
    public ResponseVO getPlanById(@RequestBody TargetPlan targetPlan) {

        try {
            TargetPlan plan = planService.getPlanById(targetPlan);
            return ResponseVO.success(plan);
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }

    }


    @RequestMapping(value = "/addPlan", method = RequestMethod.POST)
    @ApiOperation("添加一条空的计划")
    public ResponseVO addPlan() {

        try {
            planService.addPlan();
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }

    }

    @RequestMapping(value = "/deletePlan", method = RequestMethod.POST)
    @ApiOperation("根据主键id删除一条计划")
    public ResponseVO deletePlan(@RequestBody TargetPlan targetPlan) {

        try {
            planService.deletePlan(targetPlan);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }

    }

    @RequestMapping(value = "/savePlan", method = RequestMethod.POST)
    @ApiOperation("保存计划,(此处数据类型为json字符串)")
    public ResponseVO savePlan(@RequestBody TargetPlan plan) {

        try {
            planService.savePlan(plan);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }

    }

}
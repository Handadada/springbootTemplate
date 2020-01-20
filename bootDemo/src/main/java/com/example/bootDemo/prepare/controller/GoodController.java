package com.example.bootDemo.prepare.controller;

import com.example.bootDemo.exception.ProjectException;
import com.example.bootDemo.prepare.model.Good;
import com.example.bootDemo.prepare.service.GoodService;
import com.example.bootDemo.prepare.vo.GoodVo;
import com.example.bootDemo.response.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-15 15:46
 */
@RestController
@RequestMapping("/good")
@Api(value = "准备物品清单")
public class GoodController {

    @Autowired
    private GoodService goodService;

    //物品列表
    @RequestMapping(value = "/getGoods", method = RequestMethod.POST)
    @ApiOperation("物品列表")
    @ApiResponse(code = 200, message = "请求成功", response = ResponseVO.class)
    public ResponseVO getGoods(@RequestBody Good good) {
        try {
            List<GoodVo> data = goodService.getGoods(good);
            return ResponseVO.success(data);
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }


    //添加物品
    @RequestMapping(value = "/addGood", method = RequestMethod.POST)
    @ApiOperation(value = "添加物品", notes = "添加一条空信息")
    public ResponseVO addGood() {
        try {
            goodService.addGood();
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }


    //删除物品
    @RequestMapping(value = "/deleteGood", method = RequestMethod.POST)
    @ApiOperation(value = "删除物品信息", notes = "根据id删除一条信息")
    public ResponseVO deleteGood(@RequestBody Good good) {
        try {
            goodService.deleteGood(good);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }


    //保存物品
    @RequestMapping(value = "/saveGood", method = RequestMethod.POST)
    @ApiOperation(value = "修改物品信息", notes = "修改一条信息")
    @ApiModelProperty(value = "good", notes = "对象表单信息")
    public ResponseVO saveGood(@RequestBody Good good) {
        try {
            goodService.saveGood(good);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }

}
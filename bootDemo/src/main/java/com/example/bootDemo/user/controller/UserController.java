package com.example.bootDemo.user.controller;

import com.example.bootDemo.exception.ProjectException;
import com.example.bootDemo.user.service.UserService;
import com.example.bootDemo.response.ResponseVO;
import com.example.bootDemo.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @create 2020-01-20 14:19
 */
@RestController
@RequestMapping("/user")
@Api(description = "人员管理")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listUsers", method = RequestMethod.POST)
    @ApiOperation(value = "查询人员列表")
    public ResponseVO listUsers(@RequestBody User user) {
        try{
            List<User> list = userService.listUsers(user);
            return ResponseVO.success(list);
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "注册人员")
    public ResponseVO addUser(@RequestBody User user) {
        try{
            userService.addUser(user);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }


    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ApiOperation(value = "删除人员")
    public ResponseVO deleteUser(@RequestBody User user) {
        try{
            userService.deleteUser(user);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }


    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ApiOperation(value = "修改人员信息")
    public ResponseVO updateUser(@RequestBody User user) {
        try{
            userService.updateUser(user);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }

    @RequestMapping(value = "/reSetPwd", method = RequestMethod.POST)
    @ApiOperation(value = "密码重置")
    public ResponseVO reSetPwd(@RequestBody User user) {
        try{
            userService.reSetPwd(user);
            return ResponseVO.success();
        } catch (ProjectException e) {
            return ResponseVO.fail(e.getErrorEnum());
        }
    }

}
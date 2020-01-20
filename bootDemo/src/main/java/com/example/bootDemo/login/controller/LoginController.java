package com.example.bootDemo.login.controller;

import com.example.bootDemo.login.service.LoginService;
import com.example.bootDemo.response.ResponseVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-20 9:14
 */
@RestController
@RequestMapping("/login")
@Api(description = "登录控制")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /*@RequestMapping("/checkLogin")
    public ResponseVO checkLogin(@RequestBody User user){

    }*/

}
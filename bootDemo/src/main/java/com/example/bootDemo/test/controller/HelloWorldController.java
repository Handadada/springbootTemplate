package com.example.bootDemo.test.controller;


import com.example.bootDemo.response.ResponseVO;
import com.example.bootDemo.test.model.DemoModel;
import com.example.bootDemo.test.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-13 16:24
 */
@RequestMapping("/demo")
@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService service;

    @RequestMapping("/hello")
    private String helloTest() {
        return "Hello World!";
    }


    @RequestMapping("/getDemo")
    @ResponseBody
    private ResponseVO getDemo() {
        try {
            List<DemoModel> model = service.getDemo();
            return ResponseVO.success(model);
        } catch (Exception e) {
            return ResponseVO.fail(e.getMessage());
        }
    }
}
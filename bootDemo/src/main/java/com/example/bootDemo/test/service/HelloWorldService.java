package com.example.bootDemo.test.service;

import com.example.bootDemo.test.mapper.HelloWorldMapper;
import com.example.bootDemo.test.model.DemoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2019-11-14 9:41
 */
@Service
public class HelloWorldService {

    @Autowired
    private HelloWorldMapper mapper;


    public List<DemoModel> getDemo() {
        return mapper.getDemo();
    }
}
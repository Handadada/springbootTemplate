package com.example.bootDemo.login.service;

import com.example.bootDemo.login.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author hanchong@mail.haoyisheng.com
 * @create 2020-01-20 9:16
 */
@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

}
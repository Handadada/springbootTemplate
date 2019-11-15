package com.example.bootDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(value = {"com.example.bootdemo.*"})
@ComponentScan("com.example.bootdemo")
@EnableTransactionManagement//事务自动管理
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@EnableAutoConfiguration //自动装配配置文件
@EnableScheduling //定时任务
public class BootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class, args);
    }

}

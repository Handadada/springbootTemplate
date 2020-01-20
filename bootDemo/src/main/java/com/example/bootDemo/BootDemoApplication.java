package com.example.bootDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(value = {"com.example.bootDemo.*"})
@ComponentScan("com.example.bootDemo")
@EnableTransactionManagement//事务自动管理
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@EnableAutoConfiguration //自动装配配置文件
@EnableScheduling //定时任务
@Controller
public class BootDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootDemoApplication.class);
    }
}

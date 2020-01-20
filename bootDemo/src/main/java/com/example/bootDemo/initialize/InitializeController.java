package com.example.bootDemo.initialize;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;


@Controller
public class InitializeController {


    private final static String CONTEXT_PATH = "contextPath";


    @GetMapping("/initialize/{module}/{function}/{page}")
    public String initialize(@PathVariable String module
            , @PathVariable String function, @PathVariable String page,
                             Map<String, Object> params, HttpServletRequest request) {
        String contextPath = request.getContextPath();
        params.put(CONTEXT_PATH, contextPath);
        System.err.println("contextPath:"+contextPath);
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            params.put(name, value);
            System.err.println("name:"+name+"\n"+"value:"+value);
        }
        return "/" + module + "/" + function + "/" + page;
    }

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }






}

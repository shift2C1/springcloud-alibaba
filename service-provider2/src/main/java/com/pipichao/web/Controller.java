package com.pipichao.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String name;
    @RequestMapping("/hello")
    public String hello(){
        return "hello:"+name+":"+port;
    }
}

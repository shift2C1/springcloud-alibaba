package com.pipichao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//用springcloud 原生注解申明该类是一个微服务的客户端
public class ServiceProvider1 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider1.class,args);
    }
}


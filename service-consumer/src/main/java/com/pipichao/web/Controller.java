package com.pipichao.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/consumer")
    public String test(){
//        ServiceInstance serviceInstances = loadBalancerClient.choose("service-provider");//通过服务名获取一个负载均衡rest客户端
//        System.out.println(serviceInstances.toString());
//        String path = String.format("http://%s:%s/hello/%s",serviceInstances.getHost(),serviceInstances.getPort(),appName);
//        System.out.println("request path:" +path);
//        return restTemplate.getForObject(path,String.class);
        return restTemplate.getForObject("http://service-provider/hello",String.class);
    }


//    @LoadBalanced
//    @Bean
//    private



    //注入 restTemplate
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}

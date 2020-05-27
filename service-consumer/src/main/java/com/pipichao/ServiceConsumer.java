package com.pipichao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceConsumer {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ServiceConsumer.class, args);
        //动态更新配置中心的文件内容
        while (true){
            String name=applicationContext.getEnvironment().getProperty("user.name");
            String age=applicationContext.getEnvironment().getProperty("user.age");
            System.out.println(name+"::::::::"+age);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //从nacos配置中心读取到的数据
//        wangwu::::::::18
//        wangwu::::::::18
//        wangwu::::::::19
//        wangwu::::::::19

    }
}

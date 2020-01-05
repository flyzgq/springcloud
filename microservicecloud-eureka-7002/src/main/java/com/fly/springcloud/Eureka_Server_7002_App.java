package com.fly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: zhanggq
 * @Description: 作为eureka服务端
 * @Date: 2020/1/1 16:09
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableEurekaServer        //作为eureka服务端，接受其他服务的注册
public class Eureka_Server_7002_App {

    public static void main(String[] args) {
        SpringApplication.run(Eureka_Server_7002_App.class, args);
    }
}

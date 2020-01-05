package com.fly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2020/1/1 0:08
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableEurekaClient   //将服务注册到eureka中
@EnableDiscoveryClient //服务被发现
public class DeptProvider8001_App {

    public static void main(String[] args) {

        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}

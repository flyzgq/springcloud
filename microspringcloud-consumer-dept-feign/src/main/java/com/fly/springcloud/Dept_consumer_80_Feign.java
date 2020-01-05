package com.fly.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2020/1/1 11:27
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.fly.springcloud"})
@ComponentScan("com.fly.springcloud")  //大坑！！！！ 一定要加上，不然要报错
public class Dept_consumer_80_Feign {

    public static void main(String[] args) {
        SpringApplication.run(Dept_consumer_80_Feign.class, args);
    }
}

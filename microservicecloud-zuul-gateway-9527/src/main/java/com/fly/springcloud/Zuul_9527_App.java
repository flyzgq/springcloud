package com.fly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2020/1/3 22:03
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_App {

    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_App.class, args);
    }
}

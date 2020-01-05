package com.fly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2020/1/3 20:24
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class DpetConsumer_DashBoard_App {

    public static void main(String[] args) {
        SpringApplication.run(DpetConsumer_DashBoard_App.class, args);
    }
}

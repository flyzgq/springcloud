package com.fly.springcloud;

import com.fly.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2020/1/1 11:27
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERIVECLOUD-DEPT", configuration = MySelfRule.class)
public class Dept_consumer_80_App {

    public static void main(String[] args) {
        SpringApplication.run(Dept_consumer_80_App.class, args);
    }
}

package com.fly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: zhanggq
 * @Description: Config Server端
 * @Date: 2020/1/5 15:20
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableConfigServer
public class Config_3344_App {

    public static void main(String[] args) {
        SpringApplication.run(Config_3344_App.class, args);
    }
}

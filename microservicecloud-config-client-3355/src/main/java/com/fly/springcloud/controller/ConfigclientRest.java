package com.fly.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2020/1/5 15:58
 * @Version: 1.0
 **/
@RestController
public class ConfigclientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String getConfig(){
        System.out.println( applicationName  + eurekaServer + port);
        return applicationName + "\t" + eurekaServer + "\t" + port;
    }
}

package com.fly.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2020/1/1 10:37
 * @Version: 1.0
 **/
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    };

    /**
     *@desciption 自定义负载均衡算法，默认为轮寻算法
     *@return com.netflix.loadbalancer.IRule
     *@auther zhanggq
     *@date 2020/1/1 23:33
     **/
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}

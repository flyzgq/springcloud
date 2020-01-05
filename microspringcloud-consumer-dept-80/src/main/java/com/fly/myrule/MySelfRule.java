package com.fly.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhanggq
 * @Description: MySelfRule不能放在@ComponentScan的所在的包及子包下
 * @Date: 2020/1/1 23:43
 * @Version: 1.0
 **/
@Configuration
public class MySelfRule {

    /**
     *@desciption 自定义负载均衡算法
     *@return com.netflix.loadbalancer.IRule
     *@auther zhanggq
     *@date 2020/1/2 0:33
     **/
    @Bean
    public IRule myRule(){
//        return new RandomRule();
        return new MySelfRoundRobinRule();
    }
}

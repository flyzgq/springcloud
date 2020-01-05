package com.fly.springcloud.controller;

import com.fly.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2020/1/1 11:09
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/consumer")
public class Dept_consumer_controller {

//    public static final String url_pre= "http://127.0.0.1:8001";
//    public static final String url_pre= "http://MICROSERIVECLOUD-DEPT";

    //从yml中读取变量
    @Value("${deptservice.prefix}")
    private String url_pre;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){
       return restTemplate.postForObject(url_pre + "/dept/add", dept, Boolean.class);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        return restTemplate.getForObject(url_pre + "/dept/get/" + id , Dept.class);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(url_pre + "/dept/list", List.class);
    }

    @GetMapping("/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(url_pre + "/dept/discovery", Object.class);
    }

}

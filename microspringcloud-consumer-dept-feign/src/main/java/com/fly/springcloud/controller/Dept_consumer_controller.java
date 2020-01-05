package com.fly.springcloud.controller;

import com.fly.springcloud.entities.Dept;
import com.fly.springcloud.service.DeptClientService;
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

    @Autowired
    private DeptClientService service;


    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){
        return service.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return service.list();
    }

   /* @GetMapping("/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(url_pre + "/dept/discovery", Object.class);
    }*/

}

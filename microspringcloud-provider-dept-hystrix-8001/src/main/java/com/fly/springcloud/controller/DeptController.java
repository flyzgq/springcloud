package com.fly.springcloud.controller;

import com.fly.springcloud.entities.Dept;
import com.fly.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2019/12/31 23:59
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }


    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrix_get")
    public Dept get(@PathVariable Long id){
        Dept dept = deptService.get(id);
        if(null == dept){
            throw new RuntimeException("没有该ID" + id + "记录");
        }
        return dept;
    }

    public Dept hystrix_get(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("没有该ID" + id + "记录")
                .setDb_source("no database in mysql");
    }
    @GetMapping("/list")
    public List<Dept> list(){
        return deptService.list();
    }

    @GetMapping("/discovery")
    public DiscoveryClient discovery(){
        List<String> services = client.getServices();
        System.out.println("**********************" + services);

        List<ServiceInstance> instances = client.getInstances("MICROSERIVECLOUD-DEPT");
        for (ServiceInstance serviceInstance: instances){
            System.out.println(serviceInstance.getServiceId()
            +"\t" + serviceInstance.getHost()
            +"\t"+ serviceInstance.getPort()
            +"\t"+ serviceInstance.getUri());
        }
        return client;
    }
}

package com.fly.springcloud.service;

import com.fly.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2020/1/2 22:38
 * @Version: 1.0
 **/
//@FeignClient(value = "MICROSERIVECLOUD-DEPT")
@FeignClient(value = "MICROSERIVECLOUD-DEPT", fallbackFactory = DeptClientServiceFallback.class)
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    Dept get(@PathVariable("id") long id);

    @GetMapping("/dept/list")
    List<Dept> list();

    @PostMapping("/dept/add")
    boolean add(Dept dept);
}

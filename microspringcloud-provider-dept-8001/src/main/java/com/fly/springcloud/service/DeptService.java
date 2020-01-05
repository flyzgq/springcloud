package com.fly.springcloud.service;

import com.fly.springcloud.entities.Dept;

import java.util.List;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2019/12/31 23:54
 * @Version: 1.0
 **/
public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}

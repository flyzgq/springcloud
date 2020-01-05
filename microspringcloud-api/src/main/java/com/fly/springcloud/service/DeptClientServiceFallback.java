package com.fly.springcloud.service;

import com.fly.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2020/1/3 0:59
 * @Version: 1.0
 **/
@Component //一定要加上
public class DeptClientServiceFallback implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("没有该ID" + id + "记录")
                        .setDb_source("no database in mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}

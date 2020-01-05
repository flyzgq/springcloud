package com.fly.springcloud.service.impl;

import com.fly.springcloud.dao.DeptDao;
import com.fly.springcloud.entities.Dept;
import com.fly.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2019/12/31 23:55
 * @Version: 1.0
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;
    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}

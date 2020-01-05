package com.fly.springcloud.dao;

import com.fly.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2019/12/31 23:35
 * @Version: 1.0
 **/
@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}

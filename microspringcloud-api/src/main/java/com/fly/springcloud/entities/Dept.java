package com.fly.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: zhanggq
 * @Description: TODO
 * @Date: 2019/12/31 22:14
 * @Version: 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {
    //部门编号
    private long deptno;
    //部门名称
    private String dname;
    //来源
    private String db_source;

}

package com.bjsxt.mapper;

import com.bjsxt.entity.Emp;

import java.util.List;

public interface EmpMapper2 {
    public List<Emp> selectAll();
    public List<Emp> selectByNo(int deptNo);
    //n+1 模式
    public List<Emp> selectAll2();
    public List<Emp> selectByNo2(int deptNo);
}

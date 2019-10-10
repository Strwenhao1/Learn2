package com.bjsxt.mapper;

import com.bjsxt.entity.Dept;

import java.util.List;

public interface DeptMapper3 {

    public Dept selectByNo(int deptNo);
    public List<Dept> selectAll();


    public Dept selectByNo2(int deptNo);
    public List<Dept> selectAll2();
}

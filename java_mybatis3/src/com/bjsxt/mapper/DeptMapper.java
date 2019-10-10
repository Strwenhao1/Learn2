package com.bjsxt.mapper;

import com.bjsxt.entity.Dept;

import java.util.List;

public interface DeptMapper {
    public Dept selectByNo1(int deptNo);
    public List<Dept> selectAll();
}

package com.bjsxt.mapper;

import com.bjsxt.entity.Dept;

import java.util.List;

public interface DeptMapper {
    public List<Dept> selectAll();
    public Dept selectByNo(int deptNo);
    public Dept selectByName(String dname);
    public int add(Dept dept);
    public int delete(int deptNo);
    public int update(Dept dept);
}

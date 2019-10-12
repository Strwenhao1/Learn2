package com.bjsxt.mapper;

import com.bjsxt.entity.Dept;

import java.util.List;

public interface DeptMapper2 {
    public List<Dept> select();
    public int update(Dept dept);
    public int update2(Dept dept);
}

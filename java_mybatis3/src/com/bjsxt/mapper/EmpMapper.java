package com.bjsxt.mapper;

import com.bjsxt.entity.Emp;

import java.util.List;

public interface EmpMapper {
    public List<Emp> selectAll();
    public List<Emp> selectByNo(int empNo);
}

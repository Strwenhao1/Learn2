package com.bjsxt.mapper;

import com.bjsxt.entity.Emp;

import java.util.List;

public interface EmpMapper {
    public List<Emp> selectAll();
    public Emp selectByNo(int empNo);
    public List<Emp> selectByJob(String Job);
    public int add(Emp emp);
    public int delete(int empNo);
    public int update(Emp emp);
}

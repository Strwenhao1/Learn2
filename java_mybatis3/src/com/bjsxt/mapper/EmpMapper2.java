package com.bjsxt.mapper;

import com.bjsxt.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper2 {
    public List<Emp> selectByNameorId(@Param("ename") String ename, String job);
}

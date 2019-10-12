package com.bjsxt.mapper;

import com.bjsxt.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper3 {
    public List<Emp> select(@Param("ename") String ename);
    public List<Emp> select2(@Param("ename") String ename);
    public List<Emp> select3(List<String> list);
}

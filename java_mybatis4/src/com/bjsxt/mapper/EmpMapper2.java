package com.bjsxt.mapper;

import com.bjsxt.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper2 {
    public List<Emp> select(@Param("name") String name , @Param("job") String job);
    public List<Emp> select2(@Param("name") String name , @Param("job") String job);
}

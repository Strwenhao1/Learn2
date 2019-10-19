package com.bjsxt.mapper;

import com.bjsxt.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper2 {
    public List<Emp> selectByNameorId( String ename, String job);
    public List<Emp> select( String ename, String job);

    public List<Emp> select2(List<String> list);

    public List<Emp> selectByName(@Param("name") String name);
}

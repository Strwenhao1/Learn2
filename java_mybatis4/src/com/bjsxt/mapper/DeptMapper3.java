package com.bjsxt.mapper;

import com.bjsxt.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DeptMapper3 {
    @Select("select * from dept")
    public List<Dept> select();
    public List<Dept> select1();
    @Select("select * from dept where deptno = #{deptNo}")
    public List<Dept> selectByNo(int deptNo);

    @Update("update dept set dname = #{dname},loc = #{loc} where deptno = #{deptNo}")
    public int update(Dept dept);

    @Delete("delete from dept where deptno = #{deptNo}")
    public int delete(int deptNo);

    @Insert("insert into dept values(#{deptNo},#{dname},#{loc})")
    public int add(Dept dept);
}

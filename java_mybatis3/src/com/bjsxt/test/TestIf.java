package com.bjsxt.test;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.Emp;
import com.bjsxt.mapper.DeptMapper;
import com.bjsxt.mapper.EmpMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class TestIf {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);

        List<Emp> emps = mapper.selectByNameorId("JAMES","CLERK");

        for (Emp emp: emps){
            System.out.println(emp);
        }

//        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
//        List<Dept> list = mapper.selectAll();
//
//        for (Dept dept:list){
//            System.out.println(dept);
//        }

        sqlSession.commit();
        sqlSession.close();

    }
}

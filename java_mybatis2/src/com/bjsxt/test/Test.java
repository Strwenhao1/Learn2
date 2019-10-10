package com.bjsxt.test;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.Emp;
import com.bjsxt.mapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

//        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
//        List<Emp> emps = mapper.selectAll2();
//        for (Emp emp:emps) {
//            System.out.println(emp);
//        }
        DeptMapper3 mapper = sqlSession.getMapper(DeptMapper3.class);
        List<Dept> list = mapper.selectAll2();
        for (Dept dept:list){
            System.out.println(dept);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}

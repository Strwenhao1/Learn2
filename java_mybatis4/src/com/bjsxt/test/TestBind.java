package com.bjsxt.test;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.Emp;
import com.bjsxt.mapper.DeptMapper;
import com.bjsxt.mapper.EmpMapper3;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class TestBind {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        //采用原始的字符拼接  来达到模糊查询

//        EmpMapper3 mapper = sqlSession.getMapper(EmpMapper3.class);
//
//        List<Emp> a = mapper.select("A");
//        List<Emp> a1 = mapper.select("");
//
//        for (Emp emp:a1){
//            System.out.println(emp);
//        }


        //采用bind 模式

        EmpMapper3 mapper = sqlSession.getMapper(EmpMapper3.class);

        List<Emp> emps = mapper.select2("A");
        for (Emp emp:emps){
            System.out.println(emp);
        }

        sqlSession.commit();
        sqlSession.close();

    }
}

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
import java.util.ArrayList;
import java.util.List;

public class TestForeach {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        EmpMapper3 mapper = sqlSession.getMapper(EmpMapper3.class);
        List<String> list = new ArrayList<>();

        list.add("CLERK");
        list.add("ANALYST");
        List<Emp> emps = mapper.select3(list);

        for (Emp emp:emps){
            System.out.println(emp);
        }

        sqlSession.commit();
        sqlSession.close();

    }
}

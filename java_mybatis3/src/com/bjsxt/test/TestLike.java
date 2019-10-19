package com.bjsxt.test;

import com.bjsxt.entity.Emp;
import com.bjsxt.mapper.EmpMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestLike {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);


        List<Emp> emps = mapper.selectByName("A");

        for (Emp emp: emps){
            System.out.println(emp);
        }



        sqlSession.commit();
        sqlSession.close();

    }
}

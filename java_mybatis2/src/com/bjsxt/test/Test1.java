package com.bjsxt.test;

import com.bjsxt.entity.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test1 {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        List<Emp> list = sqlSession.selectList("a.c.queryEmp");
        for (Emp emp:list){
            System.out.println(emp);
        }
//        System.out.println(list);
        sqlSession.close();
    }
}

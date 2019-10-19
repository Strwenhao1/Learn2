package com.bjsxt.test;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.Emp;
import com.bjsxt.mapper.DeptMapper2;
import com.bjsxt.mapper.EmpMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class TestIf2 {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

//        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);

//        List<Emp> emps = mapper.select("","");
//
//        for (Emp emp: emps){
//            System.out.println(emp);
//        }




        DeptMapper2 mapper = sqlSession.getMapper(DeptMapper2.class);
        Dept dept = new Dept(50,"","");
        int i = mapper.update2(dept);

        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();

    }
}

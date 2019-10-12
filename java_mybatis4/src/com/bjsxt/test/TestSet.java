package com.bjsxt.test;

import com.bjsxt.entity.Dept;
import com.bjsxt.mapper.DeptMapper;
import com.bjsxt.mapper.DeptMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class TestSet {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        DeptMapper2 mapper = sqlSession.getMapper(DeptMapper2.class);

        Dept dept = new Dept(50,"ss","sssss");

        mapper.update(dept);

        sqlSession.commit();
        sqlSession.close();

    }
}

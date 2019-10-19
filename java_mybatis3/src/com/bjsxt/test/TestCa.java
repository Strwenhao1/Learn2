package com.bjsxt.test;

import com.bjsxt.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class TestCa {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        mapper.selectByNo(44);
        long date = System.currentTimeMillis();
        mapper.selectByNo(2);
        long date1 = System.currentTimeMillis();
        System.out.println("-----------------"+(date1-date));
        date = System.currentTimeMillis();
        mapper.selectByNo(75);
        date1 = System.currentTimeMillis();
        System.out.println("-----------------"+(date1-date));
        date = System.currentTimeMillis();
        mapper.selectByNo(2);
        date1 = System.currentTimeMillis();
        System.out.println(date1-date);
        sqlSession.commit();
        sqlSession.close();

    }
}

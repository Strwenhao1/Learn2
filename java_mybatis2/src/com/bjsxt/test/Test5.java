package com.bjsxt.test;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.Emp;
import com.bjsxt.mapper.DeptMapper3;
import com.bjsxt.mapper.EmpMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test5 {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        DeptMapper3 mapper = sqlSession.getMapper(DeptMapper3.class);
        EmpMapper2 mapper1 = sqlSession.getMapper(EmpMapper2.class);

        List<Dept> list = mapper.selectAll();

        for (Dept dept:list){
            int deptNo = dept.getDeptNo();
            List<Emp> emps = mapper1.selectByNo(deptNo);
            dept.setList(emps);

        }

        for (Dept dept:list){
            System.out.println(dept);
        }

        sqlSession.commit();
        sqlSession.close();
    }
}

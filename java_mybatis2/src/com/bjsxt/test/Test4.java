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

public class Test4 {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        DeptMapper3 mapper = sqlSession.getMapper(DeptMapper3.class);
        EmpMapper2 mapper1 = sqlSession.getMapper(EmpMapper2.class);

        List<Emp> emps = mapper1.selectAll();
        for (Emp emp:emps){
            int deptNo = emp.getDeptNo();
            Dept dept = mapper.selectByNo(deptNo);
            emp.setDept(dept);
        }
        for (Emp emp:emps){
            System.out.println(emp);
        }

        sqlSession.commit();
        sqlSession.close();
    }
}

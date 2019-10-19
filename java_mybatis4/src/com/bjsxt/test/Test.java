package com.bjsxt.test;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.Emp;
import com.bjsxt.mapper.DeptMapper3;
import com.bjsxt.mapper.EmpMapper3;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        DeptMapper3 mapper = sqlSession.getMapper(DeptMapper3.class);

        List<Dept> select = mapper.select();

        for (Dept dept : select) {
            System.out.println(dept);
        }

        System.out.println("-----------------");

        List<Dept> list = mapper.selectByNo(70);
        for (Dept dept : list) {
            System.out.println(dept);
        }
        System.out.println("------------------");
        Dept dd = new Dept(80, "xuexi", "bj");
//        int add = mapper.add(dd);
//        System.out.println(add > 0 ? "添加成功" : "添加失败");
        dd.setLoc("sh");
        mapper.update(dd);

        mapper.delete(80);
        sqlSession.commit();
        sqlSession.close();

    }
}

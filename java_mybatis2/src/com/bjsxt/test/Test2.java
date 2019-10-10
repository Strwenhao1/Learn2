package com.bjsxt.test;

import com.bjsxt.entity.Dept;
import com.bjsxt.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();



        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        List<Dept> list = mapper.selectAll();

        for (Dept dept:list){
            System.out.println(dept);
        }
        System.out.println("-----------------");

        Dept dept = mapper.selectByNo(10);

        System.out.println(dept);
        System.out.println("------------------");

//        int add = mapper.add(new Dept(70, "财务", "上海"));
//        System.out.println(add>0?"成功":"失败");

        int update = mapper.update(new Dept(70, "财务部", "北京"));

        System.out.println(update>0?"修改成功":"修改失败");

        int delete = mapper.delete(80);
        System.out.println(delete>0?"删除成功":"删除失败");


//        System.out.println(list);
        sqlSession.commit();
        sqlSession.close();
    }
}

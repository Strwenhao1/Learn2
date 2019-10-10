package com.bjsxt.test;

import com.bjsxt.entity.Emp;
import com.bjsxt.mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Test3 {
    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();


        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        List<Emp> list = mapper.selectAll();

        for (Emp emp:list){
            System.out.println(emp);
        }
        System.out.println("-----------------");

        Emp emp = mapper.selectByNo(7369);
        System.out.println(emp);
        System.out.println("-------------------------");

        List<Emp> salesman = mapper.selectByJob("SALESMAN");
        for (Emp emp1:salesman){
            System.out.println(emp1);
        }
        System.out.println("---------------");
//        int add = mapper.add(new Emp(7399,"na","clock",8799,new Date(1987-06-20),87.2,300.0,60));
//        System.out.println(add>0?"添加成功":"添加失败");
//        System.out.println("----------------------");
        int update = mapper.update(new Emp(7399,"naaaaa","clock",8799,new Date(1987-06-20),87.2,300.0,60));
        System.out.println();
        System.out.println(update>0?"修改成功":"修改失败");
        int delete = mapper.delete(60);
        System.out.println(delete>0?"删除成功":"删除失败");


//        System.out.println(list);
        sqlSession.commit();
        sqlSession.close();
    }
}

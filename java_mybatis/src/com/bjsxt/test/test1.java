package com.bjsxt.test;

import com.bjsxt.entity.Dept;
import org.apache.ibatis.io.ClassLoaderWrapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class test1 {

    public static void main(String[] args) throws Exception {
        InputStream is = Resources.getResourceAsStream("myBatis.xml");

        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = builder.openSession();

        List<Dept> objects = sqlSession.selectList("a.b.queryAll");

        for (Dept dept : objects) {
            System.out.println(dept);
        }
        System.out.println("---------------------------");

        Dept o = sqlSession.selectOne("a.b.selectOne",80);
        System.out.println(o);

        System.out.println("------------------------------");

        Map<Integer, Dept> depTno = sqlSession.selectMap("a.b.queryAll2", "DEPTNO");
        System.out.println(depTno);
        System.out.println("--------------------------------");

//        int insert = sqlSession.insert("a.b.insertOne", new Dept(80, "美术部", "上海"));
//        sqlSession.commit();
//        System.out.println(insert);
//        System.out.println("----------------------------------");
        int delete = sqlSession.delete("a.b.deleteOne", 70);
        System.out.println(delete);
        sqlSession.commit();
        sqlSession.close();


    }

}

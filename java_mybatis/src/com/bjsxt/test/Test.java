package com.bjsxt.test;

import com.bjsxt.entity.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        InputStream is = null;
        SqlSession sqlSession = null;
        try {

            is = Resources.getResourceAsStream("myBatis.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

            sqlSession = ssf.openSession();

            List<Dept> list = sqlSession.selectList("a.b.queryAll");

            for (Dept dept : list) {
                System.out.println(dept);
            }

            System.out.println("-------------------------");
            Dept dept = sqlSession.selectOne("a.b.selectOne", 10);

            System.out.println(dept);
            System.out.println("--------------------------");

            Map<Integer, Dept> map = sqlSession.selectMap("a.b.queryAll2", "DEPTNO");

            System.out.println(map);
            System.out.println("--------------------------");

//            sqlSession.insert("a.b.insertOne",new Dept(70,"15","15"));
//            sqlSession.commit();
            sqlSession.update("a.b.updateOne", new Dept(70, "90", "88"));
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        sqlSession.close();

    }
}

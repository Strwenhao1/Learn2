package com.bjsxt.jdbc.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_jdbc_insert {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);

        String url = "jdbc:mysql://127.0.0.1:3306/stumgr";
        String user = "root";
        String pwd = "root";
        Connection conn = DriverManager.getConnection(url,user,pwd);
        System.out.println(conn);

        Statement stmt = conn.createStatement();

        String sql = "insert into dept values(50,'clock','no')";
        int i = stmt.executeUpdate(sql);
        if(i>0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }

//        stmt.close();
//        conn.close();
//        String driver = "com.mysql.jdbc.Driver";
//        Class.forName(driver);
//
//        String url = "jdbc:mysql://127.0.0.1:3306/stumgr";
//        String user = "root";
//        String password = "root";
//        Connection conn = DriverManager.getConnection(url, user, password);
//
//        Statement stmt = conn.createStatement();
//
//        String sql = "insert into dept values(60,'cloo','losandrola')";
//
//        int j = stmt.executeUpdate(sql);
//
//        if (j > 0) {
//            System.out.println("添加成功");
//        } else {
//            System.out.println("添加失败");
//        }





    }
}

package com.bjsxt.jdbc.test1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test_jdbc_search {
    public static void main(String[] args) {
        List<Dept> deptList = findAll();
        for (Dept dept:deptList){
            System.out.println(dept);
        }
//        char c = 100;
//        System.out.println(c);
    }
    public static List<Dept> findAll(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/stumgr?useSSL=false";
        String user = "root";
        String pwd = "root";
        String sql = "select * from dept ";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet set = null;
        List<Dept> deptList = new ArrayList<Dept>();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            pstmt = conn.prepareStatement(sql);
            set = pstmt.executeQuery();


            ResultSetMetaData rsmd = set.getMetaData();
            for (int i = 1 ; i <=  rsmd.getColumnCount();i++){
                System.out.println(rsmd.getColumnName(i)+"   "+rsmd.getColumnClassName(i)
                        +"  "+rsmd.getColumnTypeName(i));
            }

            while (set.next()){
                Dept dept = new Dept(set.getInt(1),set.getString(2),set.getString(3));
                deptList.add(dept);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(set != null){
                    set.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(pstmt != null){
                    pstmt.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn != null){
                    conn.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return deptList;

    }
}


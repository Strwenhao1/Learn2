package com.bjsxt.jdbc.test1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test_shiwu {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/stumgr";
        String user = "root";
        String pwd = "root";
        String sql = "update t_user set money = money -2000 where userid = 'zhangsan' ";
        String sql1 = "update t_user set money = money -2000 where userid = 'zhangsan' ";
        Connection conn = null;
        Statement stmt = null;
        ResultSet set = null;
        List<Dept> deptList = new ArrayList<Dept>();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            stmt.executeUpdate(sql1);
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
                if(stmt != null){
                    stmt.close();

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

    }
}

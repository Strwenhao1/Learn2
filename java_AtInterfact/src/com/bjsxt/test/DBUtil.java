package com.bjsxt.test;



import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public abstract class DBUtil {
    private DBUtil(){
    }
    private static String driver = null;
    private static String url;
    private static String root;
    private static String password;

    static {
        Properties prop = new Properties();
        try {
            InputStream resourceAsStream = DBUtil.class.getResourceAsStream("/jdbc.properties");
            System.out.println(resourceAsStream);
            prop.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = prop.getProperty("driver");
        url = prop.getProperty("url");
        root = prop.getProperty("root");
        password = prop.getProperty("password");


    }

    public static int executeUpdate(String sql,Object [] parmars){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int n = 0;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0 ; i < parmars.length ; i++){
                pstmt.setObject(i+1, parmars[i]);
            }

            n = pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null,pstmt, conn);
        }
        return n;
    }

    public static Connection getConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/stumgr?useSSL=false";
        String username  = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
        try {
            if(rs != null){
                rs.close();
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

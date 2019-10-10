package com.bjsxt.util;

import com.bjsxt.entity.Employee;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class DBUtil {
    private DBUtil(){
    }
    private static String driver = null;
    private static String url;
    private static String root;
    private static String password;
    public static Logger logger = Logger.getLogger(DBUtil.class.getName());

    static {
        Properties prop = new Properties();
        try {
            prop.load(DBUtil.class.getResourceAsStream("/jdbc.properties"));
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

    public static List<Employee> executeQuery2(String sql , Object [] params){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();

            pstmt = conn.prepareStatement(sql);
            for (int i = 0 ; i < params.length ;i++){
                pstmt.setObject(i+1, params[i]);
            }

            rs = pstmt.executeQuery();
            while (rs.next()){
                int empNo = rs.getInt(1);
                String ename = rs.getString(2);
                String job = rs.getString(3);
                int mgr = rs.getInt("mgr");
                Date hiredate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");
                int deptNo = rs.getInt("deptno");
                Employee emp = new Employee(empNo,ename,job,mgr,hiredate,sal,comm,deptNo);
                list.add(emp);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs,pstmt, conn);
        }

        return list;
    }


    public static<T> List<T> executeQuery(String sql , Object [] params,Class className){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0 ; i < params.length ;i++){
                pstmt.setObject(i+1, params[i]);
            }
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1 ; i <=  rsmd.getColumnCount();i++){
                System.out.println(rsmd.getColumnName(i)+"   "+rsmd.getColumnClassName(i)
                        +"  "+rsmd.getColumnTypeName(i));
            }

            while (rs.next()){
                Class clazz = className;
                T entity = (T)clazz.newInstance();
                for (int i = 1 ; i <=  rsmd.getColumnCount();i++){
                    String columnName = rsmd.getColumnName(i).toLowerCase();
                    Object value = rs.getObject(columnName);
                    String methodName = "set"+columnName.substring(0, 1).toUpperCase()+columnName.substring(1);
                    Class paramType = Class.forName(rsmd.getColumnClassName(i));
                    Method method = clazz.getMethod(methodName,paramType);
                    method.invoke(method,value);
                }
                list.add(entity);



//                int empNo = rs.getInt(1);
//                String ename = rs.getString(2);
//                String job = rs.getString(3);
//                int mgr = rs.getInt("mgr");
//                Date hiredate = rs.getDate("hiredate");
//                double sal = rs.getDouble("sal");
//                double comm = rs.getDouble("comm");
//                int deptNo = rs.getInt("deptno");
//                Employee emp = new Employee(empNo,ename,job,mgr,hiredate,sal,comm,deptNo);
//                list.add(emp);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs,pstmt, conn);
        }

        return list;
    }
}

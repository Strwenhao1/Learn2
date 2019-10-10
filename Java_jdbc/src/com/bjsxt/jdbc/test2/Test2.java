package com.bjsxt.jdbc.test2;

import java.io.Serializable;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Test2 implements Serializable {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户编号");
        String id = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();

        User user = new User();
        user.setUserId(id);
        user.setPassword(password);
        User re = login(user);

        if (re != null){
            System.out.println("登陆成功,"+re.getRealName());
        }else {
            System.out.println("登陆失败");
        }
    }
    public static User login(User user)  {
        final String driver = "com.mysql.jdbc.Driver";
        final String url = "jdbc:mysql://127.0.0.1:3306/stumgr";
        final String userName = "root";
        final String password = "root";
        ResultSet set = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        User user1 = null;
        try {

            Class.forName(driver);
            conn = DriverManager.getConnection(url,userName,password);
            String sql = " select * from t_user where userid=? and password = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUserId());
            pstm.setString(2, user.getPassword());
            pstm.executeQuery();
            if(set.next()){//有一条记录，登录成功
                //读取各个列的数据
                String userId = set.getString("userId");
                String realName = set.getString("realName");
                String pwd = set.getString("password");
                double money = set.getDouble("money");
                //封装到User对象中
                user1 = new User(userId,realName,pwd,money);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return user1;
    }




}

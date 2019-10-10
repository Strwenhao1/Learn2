package com.bjsxt.jdbc.test2;

import java.sql.*;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        boolean flag = false;
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
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/stumgr";
        String userName = "root";
        String password = "root";
        ResultSet set = null;
        Connection conn = null;
        Statement stmt = null;
        User user1 = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,userName,password);
            stmt = conn.createStatement();
            String sql = " select * from t_user where userid='"+user.getUserId()+"' and password = '"+user.getPassword()+"';";
            set = stmt.executeQuery(sql);
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
                stmt.close();
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

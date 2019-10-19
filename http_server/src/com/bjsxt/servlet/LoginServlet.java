package com.bjsxt.servlet;

import com.bjsxt.server.Request;
import com.bjsxt.server.Response;

public class LoginServlet extends Servlet{

    @Override
    public void doGet(Request req, Response rep) throws Exception {
        String name = req.getParamter("username");
        String pwd = req.getParamter("pwd");

        if(this.login(name,pwd)){

            rep.println(name+"登陆成功");
        }else {


            rep.println(name+"登陆失败");
        }
    }
    private boolean login(String name,String pwd){
        if("bjsxt".equals(name)&&"123".equals(pwd)){

            return true;
        }
        return false;
    }

    @Override
    public void doPost(Request req, Response rep) throws Exception {

    }
}

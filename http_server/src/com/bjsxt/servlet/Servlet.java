package com.bjsxt.servlet;

import com.bjsxt.server.Request;
import com.bjsxt.server.Response;

public abstract class Servlet {
    public void service(Request req, Response rep) throws Exception{
        this.doGet(req,rep);
        this.doPost(req,rep);
    }
    public abstract void doGet(Request req,Response rep) throws Exception;
    public abstract void doPost(Request req,Response rep) throws Exception;
}

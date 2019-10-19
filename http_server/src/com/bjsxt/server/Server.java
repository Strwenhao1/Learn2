package com.bjsxt.server;

import com.bjsxt.servlet.Servlet;
import com.bjsxt.util.IOCloseUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server {
    private ServerSocket server;

    public static void main(String[] args) {
        Server server = new Server();

        server.start();
    }

    public void start() {
        this.start(8888);
    }

    public void start(int port) {
        try {
            server = new ServerSocket(port);
            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败...");
        }
    }

    private void receive() {
        try {
            Socket client = server.accept();
            Request req = new Request(client.getInputStream());

/*           StringBuilder sb = new StringBuilder();
            sb.append("HTTP/1.1").append(" ").append(200).append(" ").append("OK").append("\r\r");
            sb.append("Content-Type:text/html;charset=utf-8").append("\r\n");
            String str = "<html><head><title>响应结果</title></head><body>成功</body></html>";
            sb.append("Content-Length:" + (str.getBytes("utf-8")).length).append("\r\n");
            sb.append("\r\n");
            sb.append(str);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),"utf-8"));
            bw.write(sb.toString());
            bw.flush();
            bw.close();*/
            Response rep = new Response(client.getOutputStream());
            Servlet servlet = WebApp.getServlet(req.getUrl());
            int code = 200;
            if(servlet == null){
                code =404;
            }
            servlet.service(req,rep);
            rep.pushToClient(code);
            IOCloseUtil.closeAll(client);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void stop() {

    }
}

package com.bjsxt.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8787);
//        ServerSocket serverSocket1 = new ServerSocket(8780);
        int i = 0;
        while (true){
            Socket socket = serverSocket.accept();
//            Socket socket1 = serverSocket1.accept();
            LoginThread thread = new LoginThread(socket);
            thread.start();
            System.out.println("第"+(++i)+"次登陆,ip地址是："+thread.socket.getInetAddress());

        }
    }
}

package com.bjsxt.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LoginCelint {
    public static void main(String[] args) throws IOException {
//        System.out.println(InetAddress.getLocalHost().getHostAddress());
        Socket socket = new Socket("192.168.153.162", 8787);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        Scanner scanner = new Scanner(System.in);
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        dos.writeUTF("celent:");
        String celintResult = dis.readUTF();
        System.out.println(celintResult);


        dos.close();
        dis.close();
    }
}

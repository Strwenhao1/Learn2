package com.bjsxt.exam_1.t3_exam;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Mess_tcp_Server {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;
        DataInputStream bis = null;
        DataOutputStream dos = null;
        try {
            serverSocket= new ServerSocket(7842);
            socket = serverSocket.accept();
//            BufferedReader br = new BufferedReader (new InputStreamReader(socket.getInputStream()));
//            String str = br.readLine();
//            System.out.println("客户端说："+str);
//            OutputStream


            bis = new DataInputStream(socket.getInputStream());
            System.out.println(bis.readUTF());
//
            dos = new DataOutputStream(socket.getOutputStream());
           dos.writeUTF("你好呀");
//




        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bis!=null){
                    bis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if(dos!=null){
                    dos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}

package com.bjsxt.exam_1.t3_exam;

import java.io.*;
import java.net.Socket;

public class Mess_tcp_Celint {
    public static void main(String[] args) {
        Socket socket = null;
        DataOutputStream bos = null;
        DataInputStream dis = null;
        try {
            socket = new Socket("192.168.153.162", 7842);
            bos = new DataOutputStream(socket.getOutputStream());
            bos.writeUTF("啊啊啊啊");
//
//
            dis = new DataInputStream(socket.getInputStream());
            System.out.println(dis.readUTF());


        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try {
                if(bos!=null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

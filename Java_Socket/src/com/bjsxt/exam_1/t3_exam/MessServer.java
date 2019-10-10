package com.bjsxt.exam_1.t3_exam;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MessServer {
    public static void main(String[] args) throws  Exception{

        DatagramSocket socket = new DatagramSocket(3377);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        String s = "你好";
        byte[] buf1 = s.getBytes();
        InetAddress address = InetAddress.getByName("192.168.153.162");
        packet = new DatagramPacket(buf1,buf1.length,address,7733);
        socket.send(packet);


        socket.close();

    }
}

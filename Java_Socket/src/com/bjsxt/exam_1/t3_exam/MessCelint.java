package com.bjsxt.exam_1.t3_exam;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MessCelint {
    public static void main(String[] args) throws Exception{

        DatagramSocket socket = new DatagramSocket(7733);
        Scanner scanner = new Scanner(System.in);

        byte[] buf = scanner.nextLine().getBytes();
        InetAddress address = InetAddress.getByName("192.168.153.162");
        DatagramPacket packet = new DatagramPacket(buf,buf.length,address,3377);
        socket.send(packet);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));


        socket.close();
    }
}

package com.bjsxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class AskServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(7788);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String str = "亲，在的";
        while (flag){
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf,buf.length);
            socket.receive(packet);
            System.out.println(new String(buf,0,packet.getLength()));

            if (new String(buf,0,packet.getLength()).equals("bye")) {
                flag = false;
                break;
            }

            str = scanner.nextLine();
            byte[] buf2 = str.getBytes();
            InetAddress address = InetAddress.getByName("192.168.153.162");
            DatagramPacket packet1 = new DatagramPacket(buf2,buf2.length,address,8877);
            socket.send(packet1);


        }
        socket.close();

    }
}

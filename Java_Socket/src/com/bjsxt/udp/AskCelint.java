package com.bjsxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class AskCelint {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8877);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String str = "亲,在么";
        System.out.println(str);
        while (flag) {
            str = scanner.nextLine();
//            System.out.println(str);
            if (str.equals("bye")) {
                flag = false;
                break;
            }
            byte[] buf = str.getBytes();
            InetAddress address = InetAddress.getByName("192.168.153.162");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 7788);
            socket.send(packet);


            byte[] buf1 = new byte[1024];
            DatagramPacket packet1 = new DatagramPacket(buf1,buf1.length);
            socket.receive(packet1);
            System.out.println(new String(buf1,0,packet1.getLength()));




        }
        socket.close();
    }
}

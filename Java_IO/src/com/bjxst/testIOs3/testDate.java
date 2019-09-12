package com.bjxst.testIOs3;

import java.awt.image.DataBuffer;
import java.io.*;

public class testDate {
    public static void main(String[] args) throws  Exception{
//       write();
       read();
    }
     public static  void read() throws Exception{
        DataInputStream dis = new
                DataInputStream(new BufferedInputStream(new FileInputStream(new File("d:/jpg1.txt"))));
         System.out.println(dis.readInt());
         System.out.println(dis.readDouble());
         System.out.println(dis.readUTF());

     }
     public static void  write() throws Exception {
        DataOutputStream dos = new
                DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("d:/jpg1.txt"),true)));
        dos.writeInt(11);
        dos.writeDouble(32.5);
        dos.writeUTF("asd");
        dos.close();
    }
}

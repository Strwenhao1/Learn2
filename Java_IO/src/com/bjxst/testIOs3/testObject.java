package com.bjxst.testIOs3;

import java.io.*;
import java.util.Date;

public class testObject {
    public static void main(String [] args) throws Exception {
//        ObjectWriter();
        ObjectReader();
    }

    public static void ObjectWriter() throws Exception{
        ObjectOutputStream oos = new
                ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("d:/jpg1.txt"))));
        oos.writeInt(23);
        oos.writeBoolean(false);
        oos.writeObject(new Date());
        oos.close();
    }

    public static void ObjectReader() throws Exception{
        ObjectInputStream ois = new
                ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("d:/jpg1.txt"))));
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readObject());
    }
}

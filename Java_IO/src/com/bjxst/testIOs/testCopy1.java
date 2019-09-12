package com.bjxst.testIOs;

import java.io.*;

public class testCopy1 {
    public static void main(String[] args) throws IOException {
        InputStream fis  = new FileInputStream(new File("E:\\Program Files\\feiq\\Recv Files\\JAVA基础资料和相关软件\\相关资料\\软件\\其他\\WPS.exe"));
        OutputStream fos = new FileOutputStream(new File("E:\\Program Files\\feiq\\Recv Files\\JAVA基础资料和相关软件\\相关资料\\软件\\其他\\WPS2.exe"));

        int i ;
        int len;
        byte[] by = new byte[4096];
        len = fis.read(by);
        while (len!=-1){
            fos.write(by,0,len);
            len = fis.read(by);
        }
        fis.close();
        fos.close();

    }
}

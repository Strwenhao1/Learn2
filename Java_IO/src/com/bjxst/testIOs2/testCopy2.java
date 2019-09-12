package com.bjxst.testIOs2;

import java.io.*;

public class testCopy2 {
    public static void main(String[] args) throws IOException {
        InputStream fis = new FileInputStream(new File("E:\\迅雷下载\\妄想学生会 剧场版.RMVB"));
        OutputStream fos = new FileOutputStream(new File("E:\\迅雷下载\\妄想学生会 剧场版1.RMVB"));
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] c = new byte[4096];
        int len ;

        while ((len = bis.read(c) )!= -1){
                fos.write(c,0,len);
        }
        fis.close();
        fos.close();
    }
}

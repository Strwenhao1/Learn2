package com.bjsxt.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadCelint {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("d:/settings.zip");
        BufferedInputStream bis = new BufferedInputStream(is);


        Socket socket = new Socket("192.168.153.163", 8800);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] buf = new byte[2048];
        int len = bis.read(buf);
        while (len>0){
            bos.write(buf,0,len);
            len = bis.read(buf);
        }
        bos.close();
        bis.close();
    }
}

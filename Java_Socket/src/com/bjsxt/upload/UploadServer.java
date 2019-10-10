package com.bjsxt.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(773);
        Socket socket = serverSocket.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\src/asdas33d.zip"));
        byte[] buf = new byte[2048];
        int len = bis.read(buf);
        while (len> 0){
            bos.write(buf,0,len);
            len = bis.read(buf);
        }
        bis.close();
        bos.close();
    }
}

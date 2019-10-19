package com.bjsxt.server;

import com.bjsxt.util.IOCloseUtil;

import java.io.*;
import java.nio.Buffer;

public class Response {
    private StringBuilder headInfo;
    private StringBuilder content;
    private int length;
    private BufferedWriter bw;

    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";

    public Response() {
        headInfo = new StringBuilder();
        content = new StringBuilder();

    }

    public Response(OutputStream os) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(os, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            headInfo = null;
            e.printStackTrace();
        }

    }

    public Response print(String info) {
        content.append(info);
        try {
            length += info.getBytes("utf-8").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Response println(String info) {
        content.append(info).append(CRLF);
        try {
            length += (info + CRLF).getBytes("utf-8").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this;
    }

    private void createHeadInfo(int code) {
        headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
        switch (code) {
            case 200:
                headInfo.append("OK");
                break;
            case 500:
                headInfo.append("SERVER ERROR");
                break;
            default:
                headInfo.append("NOT FOUND");
                break;
        }
        headInfo.append(CRLF);
        headInfo.append("Content-Type:text/html;charset=utf-8").append(CRLF);
        headInfo.append("Content-Length:" + length).append(CRLF).append(CRLF);

    }


    public void pushToClient(int code){
        if(headInfo == null){
            code = 500;
        }
        this.createHeadInfo(code);
        try {
            bw.write(headInfo.toString());
            bw.write(content.toString());
            bw.flush();
            this.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        IOCloseUtil.closeAll(bw);
    }
}

package com.bjsxt.server;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

public class Request {
    private InputStream is;
    private String requestInfo;
    private String method;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;
    private Map<String, List<String>> parametermapValues;
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";

    public Request() {
        parametermapValues = new HashMap<String, List<String>>();
        method = "";
        url = "";
        requestInfo = "";

    }
    public Request(InputStream is){
        this();
        this.is = is;
        byte[] buf = new byte[20480];
        try {

            int len = this.is.read(buf);
//            System.out.println(len);
            requestInfo = new String(buf,0,len);
        } catch (IOException e) {
            return;
        }
        this.parseRequestInfo();
    }
    public void parseRequestInfo(){
        String paraString="";
        String firstLine = requestInfo.substring(0,requestInfo.indexOf(CRLF));
        int index = firstLine.indexOf("/");
        this.method = firstLine.substring(0,index).trim();
        String urlString = firstLine.substring(index,firstLine.indexOf("HTTP/")).trim();
        if("get".equalsIgnoreCase(this.method)){
            if(urlString.contains("?")){
                String[] urlArray = urlString.split("\\?");
                this.url = urlArray[0];
                paraString = urlArray[1];

            }else {
                this.url = urlString;
            }
        }else {
            this.url = urlString;
            paraString = requestInfo.substring(requestInfo.lastIndexOf(CRLF));
        }
        if (paraString.equals("")){
            return;
        }

        this.parseParam(paraString);
//        System.out.println(paraString);
    }
//    public void show(){
//        System.out.println(this.url);
//        System.out.println(this.method);
//    }

    public void parseParam(String prarString){
        String[] token = prarString.split("&");
        for (int i = 0 ; i <token.length;i++){
            String keyValues = token[i];
            String[] keyValue = keyValues.split("=");
            if(keyValue.length == 1){
                keyValue = Arrays.copyOf(keyValue, 2);
                keyValue[1] = null;
            }
            String key = keyValue[0].trim();
            String value = keyValue[1] == null?null:decode(keyValue[1].trim(), "utf-8");
            if (!parametermapValues.containsKey(key)){
                parametermapValues.put(key, new ArrayList<String>());
            }
            List<String> values = parametermapValues.get(key);
            values.add(value);
        }
    }

    public String[] getParamterValues(String name){
        List<String> values = parametermapValues.get(name);
        if (values == null){
            return null;
        }else {
            return values.toArray(new String[0]);
        }
    }

    public String getParamter(String name){
        String[] values = this.getParamterValues(name);
        if(values == null){
            return  null;
        }else {
            return  values[0];
        }

    }

    private String decode(String value,String code){
        try {
            return URLDecoder.decode(value,code);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Request req = new Request();
        req.parseParam("username=%e6%96%87%e8%b1%aa&pwd=123&hobby=ball&hobby=paint");
        System.out.println(req.parametermapValues);
        String[] str = req.getParamterValues("hobby");
        for (String string:str){
            System.out.println(string);
        }
        System.out.println(req.getParamter("pwd"));
    }
}

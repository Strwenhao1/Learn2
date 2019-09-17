package com.bjxst.Other;

import java.io.*;


public class CopyFolder {
    public static void main(String[] args) throws Exception{
//        File file = new File("D:\\src\\comwww");
//        System.out.println(file.mkdirs());
        copyFol("D:\\src\\com","D:\\src\\comww");

    }


    public static void copyFol(String oldFolder, String newFolder) throws IOException{
        File file = new File(oldFolder);
        File file2 = new File(newFolder);
        if (file.isDirectory()){

            boolean b = file2.mkdirs();
            System.out.println( b);
            File[] files = file.listFiles();
            for (File f:files){
                copyFol(oldFolder+"/"+f.getName(),newFolder+"/"+f.getName());
            }
        }
        if (file.isFile()){
            InputStream is = new FileInputStream(oldFolder);
            OutputStream os = new FileOutputStream(newFolder);
            BufferedInputStream bfs = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] c = new byte[2048];
            int len = bfs.read(c);
            if(len!=-1){
                bos.write(c);
                len = bfs.read(c);

            }
            bfs.close();
            bos.close();
        }

    }
}

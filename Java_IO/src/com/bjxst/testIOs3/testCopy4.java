package com.bjxst.testIOs3;

import java.io.*;

public class testCopy4 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("d:/jpg.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("d:/jpg1.txt")));
        String str = bf.readLine();
        while (str!=null){
            bw.write(str);
            bw.newLine();
            str = bf.readLine();
        }
        bf.close();
        bw.close();
    }
}

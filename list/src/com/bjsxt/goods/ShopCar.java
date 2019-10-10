package com.bjsxt.goods;

import java.io.*;
import java.util.*;

public class ShopCar {

   static void saveMap(Map<Integer,goods> map) throws IOException {

//        goods good1 = new goods(1, 198, "礼盒月饼", 88);
//        goods good2 = new goods(2, 1076, "中秋套装", 33);
//        goods good3 = new goods(3, 98, "普通月饼", 73);
//        goods good4 = new goods(4, 333, "端午套装", 38);
//        goods good5 = new goods(5, 35, "咸鸭蛋+粽子", 81);
//        addGoods ad = new addGoods();
//        ad.addNewGoods(map1, good1, good2, good3, good4);


        Map<Integer, goods> map1 = new TreeMap<>();
        map1 = map;
        Set<Map.Entry<Integer, goods>> list = map1.entrySet();
        Iterator<Map.Entry<Integer, goods>> it = list.iterator();
        String str;
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("d:/Mapgoods.txt")));
        while (it.hasNext()) {
            Map.Entry<Integer, goods> entry = it.next();
            str = entry.getValue().getGid() + " " + entry.getValue().getGprice() + " "+ entry.getValue().getGname() + " " + entry.getValue().getGamount();
            bw.write(str);
            bw.newLine();
        }
        bw.close();


//
//        BufferedReader br = new BufferedReader(new FileReader("d:/goods.txt"));
//        String str1 = null;
//
//        Map<Integer, goods> map = new TreeMap<>();
//        while ((str1 = br.readLine()) != null) {
//            System.out.println(1 + " " + str1);
//            String[] st = str1.split(" ");
//
//            map.put(Integer.parseInt(st[0]), new goods(Integer.parseInt(st[0]), Integer.parseInt(st[1]), st[2], Integer.parseInt(st[3])));
//        }
//        Set<Map.Entry<Integer,goods>> entrySet = map.entrySet();
//        Iterator<Map.Entry<Integer,goods>> it1 = entrySet.iterator();
//
//        while (it1.hasNext()){
//            System.out.println(it1.next());
//        }
//
//        br.close();

    }

    static void saveCar(Map<Integer,goods> map) throws IOException {

//        goods good1 = new goods(1, 198, "礼盒月饼", 88);
//        goods good2 = new goods(2, 1076, "中秋套装", 33);
//        goods good3 = new goods(3, 98, "普通月饼", 73);
//        goods good4 = new goods(4, 333, "端午套装", 38);
//        goods good5 = new goods(5, 35, "咸鸭蛋+粽子", 81);
//        addGoods ad = new addGoods();
//        ad.addNewGoods(map1, good1, good2, good3, good4);


        Map<Integer, goods> map1 = new TreeMap<>();
        map1 = map;
        Set<Map.Entry<Integer, goods>> list = map1.entrySet();
        Iterator<Map.Entry<Integer, goods>> it = list.iterator();
        String str;
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("d:/Cargoods.txt")));
        while (it.hasNext()) {
            Map.Entry<Integer, goods> entry = it.next();
            str = entry.getValue().getGid() + " " + entry.getValue().getGprice() + " "+ entry.getValue().getGname() + " " + entry.getValue().getGamount();
            bw.write(str);
            bw.newLine();
        }
        bw.close();


//
//        BufferedReader br = new BufferedReader(new FileReader("d:/goods.txt"));
//        String str1 = null;
//
//        Map<Integer, goods> map = new TreeMap<>();
//        while ((str1 = br.readLine()) != null) {
//            System.out.println(1 + " " + str1);
//            String[] st = str1.split(" ");
//
//            map.put(Integer.parseInt(st[0]), new goods(Integer.parseInt(st[0]), Integer.parseInt(st[1]), st[2], Integer.parseInt(st[3])));
//        }
//        Set<Map.Entry<Integer,goods>> entrySet = map.entrySet();
//        Iterator<Map.Entry<Integer,goods>> it1 = entrySet.iterator();
//
//        while (it1.hasNext()){
//            System.out.println(it1.next());
//        }
//
//        br.close();

    }
}

package com.bjsxt.goods;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {


    void fountShow(){
        System.out.print("商品id      商品价格     商品名称     商品数量");
    }

    void show(){
        Set<Map.Entry<Integer,goods>> set = store.map.entrySet();
        Iterator<Map.Entry<Integer,goods>> it = set.iterator();

        System.out.print("商品id      商品价格     商品名称     商品数量");
        System.out.println();
        while (it.hasNext()){
            Map.Entry<Integer,goods> entry = it.next();
//            System.out.println("");
            System.out.println(" "+entry.getValue().getGid()+
                    "    "+entry.getValue().getGprice()+"    "+
                            entry.getValue().getGname()+"    "+
                            entry.getValue().getGamount()
                    );
        }
    }
    void idToGoods(Integer id){
        Set<Map.Entry<Integer,goods>> set = store.map.entrySet();
        Iterator<Map.Entry<Integer,goods>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,goods> entry= it.next();
            if(entry.getKey()==id){
                System.out.println(entry.getValue());
            }
        }
    }

    void idToGoods(String name){
        Pattern pattern = Pattern.compile(name);
        Set<Map.Entry<Integer,goods>> set = store.map.entrySet();
        Iterator<Map.Entry<Integer,goods>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,goods> entry = it.next();
            Matcher matcher = pattern.matcher(entry.getValue().getGname());
            if(matcher.find()){
                System.out.println(entry.getValue());
            }
        }




    }


    boolean searchId(Integer id){
        Set<Map.Entry<Integer,goods>> set = store.map.entrySet();
        Iterator<Map.Entry<Integer,goods>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,goods> entry= it.next();
            if(entry.getKey()==id){
               return true;
            }
        }
        return false;
    }
}

package com.bjsxt.goods;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
//private Map<Integer,goods> map;
//
//Search(Map<Integer,goods> map){
//    this.map = map;
//}

    void fountShow(Map.Entry<Integer,goods> entry){
        System.out.println("商品id      商品价格     商品名称     商品数量");
        System.out.println("   "+entry.getValue().getGid()+
                "         "+entry.getValue().getGprice()+"        "+
                entry.getValue().getGname()+"         "+
                entry.getValue().getGamount()
        );
    }
    
//展示所有商品
    void show(Map<Integer,goods> map){
        Set<Map.Entry<Integer,goods>> set = map.entrySet();
        Iterator<Map.Entry<Integer,goods>> it = set.iterator();
        System.out.print("商品id      商品价格     商品名称     商品数量");
        System.out.println();
        while (it.hasNext()){
            Map.Entry<Integer,goods> entry = it.next();
            System.out.println("   "+entry.getValue().getGid()+
                    "         "+entry.getValue().getGprice()+"        "+
                            entry.getValue().getGname()+"         "+
                            entry.getValue().getGamount()
                    );
        }
    }
    boolean  idToGoods(Map<Integer,goods> map,Integer id){
        Set<Map.Entry<Integer,goods>> set = map.entrySet();
        Iterator<Map.Entry<Integer,goods>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,goods> entry= it.next();
            if(entry.getKey()==id){
                fountShow(entry);
                return true;
            }
        }
        return false;
    }

    boolean nameToGoods(Map<Integer,goods> map,String name){
        Pattern pattern = Pattern.compile(name);
        Set<Map.Entry<Integer,goods>> set = map.entrySet();
        Map<Integer,goods> map1 = new TreeMap<>();
        Iterator<Map.Entry<Integer,goods>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,goods> entry = it.next();
            Matcher matcher = pattern.matcher(entry.getValue().getGname());
            if(matcher.find()){
                 map1.put(entry.getKey(),entry.getValue());
            }
        }
        if(!map1.isEmpty()){
            show(map1);
            return true;
        }
        return false;
    }


    boolean searchId(Map<Integer,goods> map,Integer id){
        Set<Map.Entry<Integer,goods>> set = map.entrySet();
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

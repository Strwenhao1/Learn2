package com.bjsxt.goods;

import java.util.Map;

public class addGoods {

    public void addNewGoods(goods...Element){
        goods[] ele = Element;
        for (goods d:ele){
            store.map.put(d.getGid(),d);
        }
    }

}

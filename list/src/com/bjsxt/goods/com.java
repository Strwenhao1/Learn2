package com.bjsxt.goods;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class com implements Comparator<Object> {


    @Override
    public int compare(Object o1, Object o2) {
        System.out.println(o1.toString());
        return (int)o2-(int)o1;
    }
}

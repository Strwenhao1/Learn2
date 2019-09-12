package com.bjsxt.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class testItrator {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 12,52,8,899,44,25,78,98,66);
        Collections.sort(list);
        System.out.println(list);
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()){
            int i = it.next();
            System.out.println(i);
            if(i==78){
                it.remove();
            }
        }
        System.out.println(list);
    }
}

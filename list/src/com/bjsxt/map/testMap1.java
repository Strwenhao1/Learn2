package com.bjsxt.map;

import com.bjsxt.Set.Student;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class testMap1 {
    public static void main(String[] agrs){
        Student stud1 = new Student(1,"张三",17,77);
        Student stud2 = new Student(2,"李四",18,77);
        Student stud3 = new Student(3,"王五",17,85);
        Student stud4 = new Student(1,"张三",17,77);
        //创建一个Hashmap对象
        HashMap<Integer, Student> map = new HashMap<Integer, Student>();
        map.put(stud1.getSid(), stud1);
        map.put(stud2.getSid(), stud2 );
        map.put(stud3.getSid(), stud3);
        map.put(stud4.getSid(), stud4 );

        System.out.println(map.size());
//        Set<Integer> set = map.keySet();
//        for (int i:set){
//            System.out.println(map.get(i));
//        }
        Set<Entry<Integer,Student>> set = map.entrySet();

        Iterator<Entry<Integer,Student>> it = set.iterator();
        while (it.hasNext()){
            Entry<Integer,Student> entry = it.next();
            System.out.println(entry.getValue());
        }

//        System.out.println(set);
//        System.out.println(map.);

    }
}

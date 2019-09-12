package com.bjsxt.Set;

import java.util.*;

/***
 * HashSet 唯一 无序
 *
 */
public class testSet2 {
    public static void main(String[] args){
        Deque deque = new LinkedList<>();

//        Set<Student> set  = new HashSet<Student>();
        LinkedHashSet<Student> set = new LinkedHashSet<>();
//        Set<Student> set  = new TreeSet<>();
        Student stud1 = new Student(1,"张三",17,77);
        Student stud2 = new Student(2,"李四",18,77);
        Student stud3 = new Student(3,"王五",17,85);
        Student stud4 = new Student(1,"张三",17,77);
        set.add(stud3);
        set.add(stud1);
        set.add(stud2);
        set.add(stud4);

        for (Student s: set){
            System.out.println(s);
        }


    }
}

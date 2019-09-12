package com.bjsxt.list;

import java.util.*;

/***
 * 如果不添加泛型的ArrayList会导致添加内容不确定
 * 例：list.add(22);  list.add("JAVA");
 * 两者添加之后再遍历过程中会造成数据类型错误，所以这种方式是不安全的
 * 在进行遍历或者操作的时候必须使用强制类型转换，这样使得基本的操作繁琐。
 * 所以在我们使用ArrayList的时候所需要添加的数据类型设置泛型。保障数据安全和操作的简便性
 *
 *
 * ArrayList的操作
 * 第一种：添加
 * list.add(99); 在list末尾添加元素
 * list.add(0,43);  在指定index位置添加元素
 * list.addAll(list2)   在list末尾添加list2的内容
 * list.add(0,list2)    在指定index位置添加list2的内容
 * 第二种：删除
 * list.remove(2)   删除指定index位置的值
 * list.remove(Integer.valueOf(3)); 删除指定的元素值
 * 上面两种删除如果是
 *
 *
 */
public class testArraylist {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(55);
        list.add(88);
        list.add(0,100);
        list.add(27);
        ArrayList list2 = new ArrayList();
        list2.add(27);
        list2.add(45);
        list2.add(38);
        list.addAll(list2);

        Deque a = new LinkedList();
        a.push(22);
        a.push(55);
        System.out.println(a.peek());
        System.out.println(a.pop());
        System.out.println(a.pop());

//        System.out.println(list);

//        System.out.println("==================");
//        list.remove(Integer.valueOf(38));
//        System.out.println("==================");
//        System.out.println(list);

    }
}

package com.bjsxt.list2;

public class TestSingleLinkedList {
    public static void main(String[] args) {
        java.util.ArrayList arrayList = new java.util.ArrayList(220);
        arrayList.add(1);
        SingleLinkedList list = new SingleLinkedList();
        list.add("11111");
        list.add("22222");
        list.add("aaaaa");
        list.add("bbbbb");
        list.add("33333");

        list.add(3,"AAAAAA");
        System.out.println(list.get(3));
        list.remove(3);
        System.out.println(list.get(3));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains("aaaaa"));
        System.out.println(list.indexOf("AAAAAA"));
        System.out.println(list.toString());
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()){
//            String elem = it.next();
//            System.out.println(elem);
//        }
//        it.next();
//        it.next();

    }
}

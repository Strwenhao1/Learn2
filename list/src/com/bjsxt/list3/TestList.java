package com.bjsxt.list3;

public class TestList {
    public static void main(String[] args) {
        java.util.LinkedList li;
        LinkedList list = new LinkedList();
        list.add("11111");
        list.add("22222");
        list.add("aaaaa");
        list.add("bbbbb");
        list.add("33333");

        list.add(3,"AAAAAA");
        System.out.println(list.get(3));

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
    }
}

package com.bjsxt.Set;

public class TestHashSet {
    public static void main(String[] args) {


        java.util.HashSet s;
        HashSet set = new HashSet();
        set.add("HTML");
        set.add("Java");
        set.add("MySQL");
        set.add("Java");
        System.out.println(set.size());
        System.out.println(set);

        System.out.println(set.contains("HTML"));
    }
}

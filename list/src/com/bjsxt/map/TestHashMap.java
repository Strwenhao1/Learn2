package com.bjsxt.map;

public class TestHashMap {
    public static void main(String[] args) {

        java.util.HashMap ha ;

        HashMap map = new HashMap();
        map.put(23,"China");
        map.put(36,"Japan");
        map.put(48,"America");
        map.put(86,"The United States");
        map.put(67,"France");
        map.put(23,"Italian");
        map.put(3,"England");
        System.out.println(map.get(Integer.valueOf(23)));
        System.out.println(map.size());
//        System.out.println(map.get(36));
        System.out.println(map.isEmpty());
        System.out.println(map);
    }
}

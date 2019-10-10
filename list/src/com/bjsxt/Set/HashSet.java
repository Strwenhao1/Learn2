package com.bjsxt.Set;
import com.bjsxt.map.HashMap;
public class HashSet implements Set {
    private transient HashMap map;

    private static final Object PRESENT = new Object();

    public HashSet(){
        map = new HashMap();
    }
    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void add(Object obj) {
//        map.put(obj,new Object());
        map.put(obj, PRESENT);
    }

    @Override
    public boolean isEmpty() {
        return map.size() == 0;
    }

    @Override
    public boolean contains(Object obj) {
        return map.get(obj) != null;
    }
}

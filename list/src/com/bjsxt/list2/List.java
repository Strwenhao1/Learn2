package com.bjsxt.list2;
import com.bjsxt.list.Iterator;
public interface List {
    public int size();

    public Object get(int i);

    public boolean isEmpty();

    public  boolean contains(Object e);

    public int indexOf(Object e);

    public void add(int i,Object e);

    public void add(Object e);

    public boolean addBefore (Object obj, Object e);

    public boolean addAfter (Object obj, Object e);

    public Object remove(int i);

    public boolean remove(Object e);

    public Object replace(int i, Object e);

    public Iterator iterator();
}
